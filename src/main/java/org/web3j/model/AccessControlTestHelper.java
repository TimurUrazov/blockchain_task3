package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class AccessControlTestHelper extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061053c806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063c0c9c7db1161005b578063c0c9c7db1461013f578063c9592ab914610165578063d2f79c4714610191578063eea2913a146101b757610088565b806304cefda51461008d57806320f2c97c146100b557806395319deb146100db578063bf5fc18b14610113575b600080fd5b6100b3600480360360208110156100a357600080fd5b50356001600160a01b03166101dd565b005b6100b3600480360360208110156100cb57600080fd5b50356001600160a01b0316610245565b6100b3600480360360408110156100f157600080fd5b5080356001600160a01b0316906020013569ffffffffffffffffffff166102d6565b6100b36004803603604081101561012957600080fd5b506001600160a01b03813516906020013561037f565b6100b36004803603602081101561015557600080fd5b50356001600160a01b03166103ed565b6100b36004803603604081101561017b57600080fd5b506001600160a01b038135169060200135610450565b6100b3600480360360208110156101a757600080fd5b50356001600160a01b0316610494565b6100b3600480360360208110156101cd57600080fd5b50356001600160a01b03166104cd565b806001600160a01b031663e5fe45776040518163ffffffff1660e01b815260040160a06040518083038186803b15801561021657600080fd5b505afa15801561022a573d6000803e3d6000fd5b505050506040513d60a081101561024057600080fd5b505050565b806001600160a01b031663feaf968c6040518163ffffffff1660e01b815260040160a06040518083038186803b15801561027e57600080fd5b505afa158015610292573d6000803e3d6000fd5b505050506040513d60a08110156102a857600080fd5b50506040517f10e4ab9f2ce395bf5539d7c60c9bfeef0b416602954734c5bb8bfd9433c9ff6890600090a150565b816001600160a01b0316639a6fc8f5826040518263ffffffff1660e01b8152600401808269ffffffffffffffffffff16815260200191505060a06040518083038186803b15801561032657600080fd5b505afa15801561033a573d6000803e3d6000fd5b505050506040513d60a081101561035057600080fd5b50506040517f10e4ab9f2ce395bf5539d7c60c9bfeef0b416602954734c5bb8bfd9433c9ff6890600090a15050565b816001600160a01b031663b5ab58dc826040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156103c357600080fd5b505afa1580156103d7573d6000803e3d6000fd5b505050506040513d602081101561035057600080fd5b806001600160a01b03166350d25bcd6040518163ffffffff1660e01b815260040160206040518083038186803b15801561042657600080fd5b505afa15801561043a573d6000803e3d6000fd5b505050506040513d60208110156102a857600080fd5b816001600160a01b031663b633620c826040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156103c357600080fd5b806001600160a01b0316638205bf6a6040518163ffffffff1660e01b815260040160206040518083038186803b15801561042657600080fd5b806001600160a01b031663668a0f026040518163ffffffff1660e01b815260040160206040518083038186803b15801561042657600080fdfea2646970667358221220e70a40d4b4881573eb7293e6ebb59852ddd39b726ec737e41215539b47fd82da64736f6c63430007060033";

    public static final String FUNC_READGETANSWER = "readGetAnswer";

    public static final String FUNC_READGETROUNDDATA = "readGetRoundData";

    public static final String FUNC_READGETTIMESTAMP = "readGetTimestamp";

    public static final String FUNC_READLATESTANSWER = "readLatestAnswer";

    public static final String FUNC_READLATESTROUND = "readLatestRound";

    public static final String FUNC_READLATESTROUNDDATA = "readLatestRoundData";

    public static final String FUNC_READLATESTTIMESTAMP = "readLatestTimestamp";

    public static final String FUNC_TESTLATESTTRANSMISSIONDETAILS = "testLatestTransmissionDetails";

    public static final Event DUMMY_EVENT = new Event("Dummy", 
            Arrays.<TypeReference<?>>asList());
    ;

    @Deprecated
    protected AccessControlTestHelper(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AccessControlTestHelper(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AccessControlTestHelper(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AccessControlTestHelper(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DummyEventResponse> getDummyEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DUMMY_EVENT, transactionReceipt);
        ArrayList<DummyEventResponse> responses = new ArrayList<DummyEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DummyEventResponse typedResponse = new DummyEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DummyEventResponse> dummyEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DummyEventResponse>() {
            @Override
            public DummyEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DUMMY_EVENT, log);
                DummyEventResponse typedResponse = new DummyEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<DummyEventResponse> dummyEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DUMMY_EVENT));
        return dummyEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> readGetAnswer(String _aggregator, BigInteger _roundID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_READGETANSWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _aggregator), 
                new org.web3j.abi.datatypes.generated.Uint256(_roundID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readGetRoundData(String _aggregator, BigInteger _roundID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_READGETROUNDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _aggregator), 
                new org.web3j.abi.datatypes.generated.Uint80(_roundID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readGetTimestamp(String _aggregator, BigInteger _roundID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_READGETTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _aggregator), 
                new org.web3j.abi.datatypes.generated.Uint256(_roundID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readLatestAnswer(String _aggregator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_READLATESTANSWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _aggregator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readLatestRound(String _aggregator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_READLATESTROUND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _aggregator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readLatestRoundData(String _aggregator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_READLATESTROUNDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _aggregator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readLatestTimestamp(String _aggregator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_READLATESTTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _aggregator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AccessControlTestHelper load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AccessControlTestHelper(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AccessControlTestHelper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AccessControlTestHelper(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AccessControlTestHelper load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AccessControlTestHelper(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AccessControlTestHelper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AccessControlTestHelper(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AccessControlTestHelper> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AccessControlTestHelper.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AccessControlTestHelper> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AccessControlTestHelper.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AccessControlTestHelper> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AccessControlTestHelper.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AccessControlTestHelper> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AccessControlTestHelper.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class DummyEventResponse extends BaseEventResponse {
    }
}
