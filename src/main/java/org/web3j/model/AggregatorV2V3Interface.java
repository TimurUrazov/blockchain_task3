package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.abi.datatypes.generated.Uint80;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class AggregatorV2V3Interface extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DESCRIPTION = "description";

    public static final String FUNC_GETANSWER = "getAnswer";

    public static final String FUNC_GETROUNDDATA = "getRoundData";

    public static final String FUNC_GETTIMESTAMP = "getTimestamp";

    public static final String FUNC_LATESTANSWER = "latestAnswer";

    public static final String FUNC_LATESTROUND = "latestRound";

    public static final String FUNC_LATESTROUNDDATA = "latestRoundData";

    public static final String FUNC_LATESTTIMESTAMP = "latestTimestamp";

    public static final String FUNC_VERSION = "version";

    public static final Event ANSWERUPDATED_EVENT = new Event("AnswerUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NEWROUND_EVENT = new Event("NewRound", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected AggregatorV2V3Interface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AggregatorV2V3Interface(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AggregatorV2V3Interface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AggregatorV2V3Interface(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AnswerUpdatedEventResponse> getAnswerUpdatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ANSWERUPDATED_EVENT, transactionReceipt);
        ArrayList<AnswerUpdatedEventResponse> responses = new ArrayList<AnswerUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AnswerUpdatedEventResponse typedResponse = new AnswerUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.current = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.updatedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AnswerUpdatedEventResponse> answerUpdatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AnswerUpdatedEventResponse>() {
            @Override
            public AnswerUpdatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ANSWERUPDATED_EVENT, log);
                AnswerUpdatedEventResponse typedResponse = new AnswerUpdatedEventResponse();
                typedResponse.log = log;
                typedResponse.current = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.updatedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AnswerUpdatedEventResponse> answerUpdatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ANSWERUPDATED_EVENT));
        return answerUpdatedEventFlowable(filter);
    }

    public List<NewRoundEventResponse> getNewRoundEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWROUND_EVENT, transactionReceipt);
        ArrayList<NewRoundEventResponse> responses = new ArrayList<NewRoundEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewRoundEventResponse typedResponse = new NewRoundEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.startedBy = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.startedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewRoundEventResponse> newRoundEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewRoundEventResponse>() {
            @Override
            public NewRoundEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWROUND_EVENT, log);
                NewRoundEventResponse typedResponse = new NewRoundEventResponse();
                typedResponse.log = log;
                typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.startedBy = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.startedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewRoundEventResponse> newRoundEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWROUND_EVENT));
        return newRoundEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> description() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getAnswer(BigInteger roundId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETANSWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(roundId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getRoundData(BigInteger _roundId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROUNDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint80(_roundId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint80>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint80>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getTimestamp(BigInteger roundId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(roundId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> latestAnswer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTANSWER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> latestRound() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTROUND, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> latestRoundData() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTROUNDDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint80>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint80>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> latestTimestamp() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTTIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> version() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static AggregatorV2V3Interface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AggregatorV2V3Interface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AggregatorV2V3Interface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AggregatorV2V3Interface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AggregatorV2V3Interface load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AggregatorV2V3Interface(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AggregatorV2V3Interface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AggregatorV2V3Interface(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AggregatorV2V3Interface> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AggregatorV2V3Interface.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AggregatorV2V3Interface> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AggregatorV2V3Interface.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AggregatorV2V3Interface> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AggregatorV2V3Interface.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AggregatorV2V3Interface> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AggregatorV2V3Interface.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AnswerUpdatedEventResponse extends BaseEventResponse {
        public BigInteger current;

        public BigInteger roundId;

        public BigInteger updatedAt;
    }

    public static class NewRoundEventResponse extends BaseEventResponse {
        public BigInteger roundId;

        public String startedBy;

        public BigInteger startedAt;
    }
}
