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
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class SimpleWriteAccessController extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b031916331790556001805460ff60a01b1916600160a01b1790556106f7806100456000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c80638823da6c116100665780638823da6c1461017c5780638da5cb5b146101a2578063a118f249146101c6578063dc7f0124146101ec578063f2fde38b146101f457610093565b80630a756983146100985780636b14daf8146100a257806379ba50971461016c5780638038e4a114610174575b600080fd5b6100a061021a565b005b610158600480360360408110156100b857600080fd5b6001600160a01b0382351691908101906040810160208201356401000000008111156100e357600080fd5b8201836020820111156100f557600080fd5b8035906020019184600183028401116401000000008311171561011757600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506102bd945050505050565b604080519115158252519081900360200190f35b6100a06102f5565b6100a06103a4565b6100a06004803603602081101561019257600080fd5b50356001600160a01b031661044b565b6101aa61051d565b604080516001600160a01b039092168252519081900360200190f35b6100a0600480360360208110156101dc57600080fd5b50356001600160a01b031661052c565b61015861058d565b6100a06004803603602081101561020a57600080fd5b50356001600160a01b031661059d565b6000546001600160a01b03163314610272576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b600154600160a01b900460ff16156102bb576001805460ff60a01b191690556040517f3be8a977a014527b50ae38adda80b56911c267328965c98ddc385d248f53963890600090a15b565b6001600160a01b03821660009081526002602052604081205460ff16806102ee5750600154600160a01b900460ff16155b9392505050565b6001546001600160a01b0316331461034d576040805162461bcd60e51b815260206004820152601660248201527526bab9ba10313290383937b837b9b2b21037bbb732b960511b604482015290519081900360640190fd5b60008054336001600160a01b0319808316821784556001805490911690556040516001600160a01b0390921692909183917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a350565b6000546001600160a01b031633146103fc576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b600154600160a01b900460ff166102bb576001805460ff60a01b1916600160a01b1790556040517faebf329500988c6488a0074e5a0a9ff304561fc5c6fc877aeb1d59c8282c348090600090a1565b6000546001600160a01b031633146104a3576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b6001600160a01b03811660009081526002602052604090205460ff161561051a576001600160a01b038116600081815260026020908152604091829020805460ff19169055815192835290517f3d68a6fce901d20453d1a7aa06bf3950302a735948037deb182a8db66df2a0d19281900390910190a15b50565b6000546001600160a01b031681565b6000546001600160a01b03163314610584576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b61051a81610646565b600154600160a01b900460ff1681565b6000546001600160a01b031633146105f5576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b600180546001600160a01b0319166001600160a01b0383811691821790925560008054604051929316917fed8889f560326eb138920d842192f0eb3dd22b4f139c87a2c57538e05bae12789190a350565b6001600160a01b03811660009081526002602052604090205460ff1661051a576001600160a01b038116600081815260026020908152604091829020805460ff19166001179055815192835290517f87286ad1f399c8e82bf0c4ef4fcdc570ea2e1e92176e5c848b6413545b885db49281900390910190a15056fea26469706673582212206307215a284f08badafd713f130baced78b6acc0882dbcc9070561bcc838eae464736f6c63430007060033";

    public static final String FUNC_ACCEPTOWNERSHIP = "acceptOwnership";

    public static final String FUNC_ADDACCESS = "addAccess";

    public static final String FUNC_CHECKENABLED = "checkEnabled";

    public static final String FUNC_DISABLEACCESSCHECK = "disableAccessCheck";

    public static final String FUNC_ENABLEACCESSCHECK = "enableAccessCheck";

    public static final String FUNC_HASACCESS = "hasAccess";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_REMOVEACCESS = "removeAccess";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event ADDEDACCESS_EVENT = new Event("AddedAccess", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event CHECKACCESSDISABLED_EVENT = new Event("CheckAccessDisabled", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event CHECKACCESSENABLED_EVENT = new Event("CheckAccessEnabled", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event OWNERSHIPTRANSFERREQUESTED_EVENT = new Event("OwnershipTransferRequested", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event REMOVEDACCESS_EVENT = new Event("RemovedAccess", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected SimpleWriteAccessController(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SimpleWriteAccessController(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SimpleWriteAccessController(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SimpleWriteAccessController(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddedAccessEventResponse> getAddedAccessEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDEDACCESS_EVENT, transactionReceipt);
        ArrayList<AddedAccessEventResponse> responses = new ArrayList<AddedAccessEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddedAccessEventResponse typedResponse = new AddedAccessEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddedAccessEventResponse> addedAccessEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddedAccessEventResponse>() {
            @Override
            public AddedAccessEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDEDACCESS_EVENT, log);
                AddedAccessEventResponse typedResponse = new AddedAccessEventResponse();
                typedResponse.log = log;
                typedResponse.user = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddedAccessEventResponse> addedAccessEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDEDACCESS_EVENT));
        return addedAccessEventFlowable(filter);
    }

    public List<CheckAccessDisabledEventResponse> getCheckAccessDisabledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHECKACCESSDISABLED_EVENT, transactionReceipt);
        ArrayList<CheckAccessDisabledEventResponse> responses = new ArrayList<CheckAccessDisabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CheckAccessDisabledEventResponse typedResponse = new CheckAccessDisabledEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CheckAccessDisabledEventResponse> checkAccessDisabledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CheckAccessDisabledEventResponse>() {
            @Override
            public CheckAccessDisabledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHECKACCESSDISABLED_EVENT, log);
                CheckAccessDisabledEventResponse typedResponse = new CheckAccessDisabledEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<CheckAccessDisabledEventResponse> checkAccessDisabledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHECKACCESSDISABLED_EVENT));
        return checkAccessDisabledEventFlowable(filter);
    }

    public List<CheckAccessEnabledEventResponse> getCheckAccessEnabledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHECKACCESSENABLED_EVENT, transactionReceipt);
        ArrayList<CheckAccessEnabledEventResponse> responses = new ArrayList<CheckAccessEnabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CheckAccessEnabledEventResponse typedResponse = new CheckAccessEnabledEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CheckAccessEnabledEventResponse> checkAccessEnabledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CheckAccessEnabledEventResponse>() {
            @Override
            public CheckAccessEnabledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHECKACCESSENABLED_EVENT, log);
                CheckAccessEnabledEventResponse typedResponse = new CheckAccessEnabledEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<CheckAccessEnabledEventResponse> checkAccessEnabledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHECKACCESSENABLED_EVENT));
        return checkAccessEnabledEventFlowable(filter);
    }

    public List<OwnershipTransferRequestedEventResponse> getOwnershipTransferRequestedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERREQUESTED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferRequestedEventResponse> responses = new ArrayList<OwnershipTransferRequestedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferRequestedEventResponse typedResponse = new OwnershipTransferRequestedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferRequestedEventResponse> ownershipTransferRequestedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferRequestedEventResponse>() {
            @Override
            public OwnershipTransferRequestedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERREQUESTED_EVENT, log);
                OwnershipTransferRequestedEventResponse typedResponse = new OwnershipTransferRequestedEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferRequestedEventResponse> ownershipTransferRequestedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERREQUESTED_EVENT));
        return ownershipTransferRequestedEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public List<RemovedAccessEventResponse> getRemovedAccessEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REMOVEDACCESS_EVENT, transactionReceipt);
        ArrayList<RemovedAccessEventResponse> responses = new ArrayList<RemovedAccessEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RemovedAccessEventResponse typedResponse = new RemovedAccessEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RemovedAccessEventResponse> removedAccessEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RemovedAccessEventResponse>() {
            @Override
            public RemovedAccessEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REMOVEDACCESS_EVENT, log);
                RemovedAccessEventResponse typedResponse = new RemovedAccessEventResponse();
                typedResponse.log = log;
                typedResponse.user = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RemovedAccessEventResponse> removedAccessEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REMOVEDACCESS_EVENT));
        return removedAccessEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ACCEPTOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addAccess(String _user) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> checkEnabled() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHECKENABLED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> disableAccessCheck() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DISABLEACCESSCHECK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> enableAccessCheck() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ENABLEACCESSCHECK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> hasAccess(String _user, byte[] param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.DynamicBytes(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> removeAccess(String _user) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVEACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String _to) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SimpleWriteAccessController load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleWriteAccessController(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SimpleWriteAccessController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleWriteAccessController(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SimpleWriteAccessController load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SimpleWriteAccessController(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SimpleWriteAccessController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SimpleWriteAccessController(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SimpleWriteAccessController> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SimpleWriteAccessController.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<SimpleWriteAccessController> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SimpleWriteAccessController.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SimpleWriteAccessController> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SimpleWriteAccessController.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SimpleWriteAccessController> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SimpleWriteAccessController.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AddedAccessEventResponse extends BaseEventResponse {
        public String user;
    }

    public static class CheckAccessDisabledEventResponse extends BaseEventResponse {
    }

    public static class CheckAccessEnabledEventResponse extends BaseEventResponse {
    }

    public static class OwnershipTransferRequestedEventResponse extends BaseEventResponse {
        public String from;

        public String to;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String from;

        public String to;
    }

    public static class RemovedAccessEventResponse extends BaseEventResponse {
        public String user;
    }
}
