import org.web3j.abi.EventEncoder
import org.web3j.abi.FunctionReturnDecoder
import org.web3j.abi.TypeReference
import org.web3j.abi.datatypes.Event
import org.web3j.abi.datatypes.generated.Int256
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.crypto.Credentials
import org.web3j.crypto.Keys
import org.web3j.model.OffchainAggregator
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.request.EthFilter
import org.web3j.protocol.websocket.WebSocketService
import org.web3j.tx.gas.DefaultGasProvider
import java.math.BigDecimal
import java.math.MathContext
import java.net.ConnectException

class ListenerException(message: String): Exception(message)

class Listener(url: String) {
    private val web3: Web3j
    private val decimals: Map<String, BigDecimal>

    init {
        val socket = WebSocketService(url, false)
        try {
            socket.connect()
        } catch (e: ConnectException) {
            throw ListenerException("Error while connecting to WSS occurred: $e")
        }
        web3 = Web3j.build(socket)
        decimals = ADDRESS_PRICE.keys.associateWith { address ->
            BigDecimal.valueOf(10L).pow(
                (OffchainAggregator.load(
                    address,
                    web3,
                    Credentials.create(Keys.createEcKeyPair()),
                    DefaultGasProvider()
                ).decimals()?.send()?.toInt() ?: run {
                    throw ListenerException("Error while retrieving decimals from contract $address occurred.")
                })
            )
        }
    }

    fun listen() {
        val filter = EthFilter(
            DefaultBlockParameter.valueOf("latest"),
            DefaultBlockParameter.valueOf("latest"),
            ADDRESS_PRICE.keys.toList()
        )

        val eventTopic = Event(
            "AnswerUpdated",
            listOf(
                object : TypeReference<Int256?>(true) {},
                object : TypeReference<Uint256?>(true) {},
                object : TypeReference<Uint256?>(false) {}
            )
        )
        filter.addSingleTopic(EventEncoder.encode(eventTopic))
        web3.ethLogFlowable(filter).subscribe({ currentEvent ->
            println("Processing block ${currentEvent.blockHash}...")
            val price = FunctionReturnDecoder.decodeIndexedValue(
                currentEvent.topics[1],
                object : TypeReference<Int256?>() {}
            ) as Int256
            val address = currentEvent.address
            println(
                "${ADDRESS_PRICE[address]}: " +
                "${BigDecimal(price.value).divide(decimals[address], MathContext.DECIMAL32)}"
            )
        }) { error -> throw ListenerException("Error occurred while listening to 'AnswerUpdated' event: $error")}
    }

    companion object {
        val ADDRESS_PRICE = mapOf(
            "0x37bC7498f4FF12C19678ee8fE19d713b87F6a9e6".lowercase() to "ETH/USD",
            "0xbba12740DE905707251525477bAD74985DeC46D2".lowercase() to "LINK/ETH",
            "0x7De0d6fce0C128395C488cb4Df667cdbfb35d7DE".lowercase() to "USDT/ETH"
        )
    }
}

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("You should pass API key")
        return
    }
    try {
        Listener("wss://eth-mainnet.g.alchemy.com/v2/${args[0]}").listen()
    } catch(e: ListenerException) {
        println("Listener exception occurred. $e")
    }
}