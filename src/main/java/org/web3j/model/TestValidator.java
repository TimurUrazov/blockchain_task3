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
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class TestValidator extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506101a1806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806311a8f41314610046578063beed9b5114610060578063c4792df4146100a3575b600080fd5b61004e6100c8565b60408051918252519081900360200190f35b61008f6004803603608081101561007657600080fd5b50803590602081013590604081013590606001356100ce565b604080519115158252519081900360200190f35b6100c6600480360360208110156100b957600080fd5b503563ffffffff1661014f565b005b60015490565b6000805a6040805188815260208101889052808201879052606081018690526080810183905290519192507fdb623f4f39d41e75ae1cbe50460c3d1496b6cf9a0db391b7197f82cab2744d21919081900360a00190a1600184905560005463ffffffff165b805a8303101561014257610133565b5060019695505050505050565b6000805463ffffffff191663ffffffff9290921691909117905556fea26469706673582212204ee3f4c51a830914cd4d13fd0fdb4f17b8fc30bb8adc3e9483529dc812d03d6564736f6c63430007060033";

    public static final String FUNC_LATESTROUNDID = "latestRoundId";

    public static final String FUNC_SETMINGASUSE = "setMinGasUse";

    public static final String FUNC_VALIDATE = "validate";

    public static final Event VALIDATED_EVENT = new Event("Validated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected TestValidator(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TestValidator(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TestValidator(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TestValidator(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ValidatedEventResponse> getValidatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(VALIDATED_EVENT, transactionReceipt);
        ArrayList<ValidatedEventResponse> responses = new ArrayList<ValidatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ValidatedEventResponse typedResponse = new ValidatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousRoundId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.previousAnswer = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.currentRoundId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.currentAnswer = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.initialGas = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ValidatedEventResponse> validatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ValidatedEventResponse>() {
            @Override
            public ValidatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(VALIDATED_EVENT, log);
                ValidatedEventResponse typedResponse = new ValidatedEventResponse();
                typedResponse.log = log;
                typedResponse.previousRoundId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.previousAnswer = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.currentRoundId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.currentAnswer = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.initialGas = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ValidatedEventResponse> validatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VALIDATED_EVENT));
        return validatedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> latestRoundId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTROUNDID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setMinGasUse(BigInteger minGasUse) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETMINGASUSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(minGasUse)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> validate(BigInteger previousRoundId, BigInteger previousAnswer, BigInteger currentRoundId, BigInteger currentAnswer) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_VALIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(previousRoundId), 
                new org.web3j.abi.datatypes.generated.Int256(previousAnswer), 
                new org.web3j.abi.datatypes.generated.Uint256(currentRoundId), 
                new org.web3j.abi.datatypes.generated.Int256(currentAnswer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TestValidator load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestValidator(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TestValidator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestValidator(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TestValidator load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TestValidator(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TestValidator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TestValidator(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TestValidator> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestValidator.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TestValidator> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestValidator.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TestValidator> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestValidator.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TestValidator> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestValidator.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ValidatedEventResponse extends BaseEventResponse {
        public BigInteger previousRoundId;

        public BigInteger previousAnswer;

        public BigInteger currentRoundId;

        public BigInteger currentAnswer;

        public BigInteger initialGas;
    }
}
