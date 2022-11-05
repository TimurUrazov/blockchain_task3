package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
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
public class OffchainAggregatorBilling extends Contract {
    public static final String BINARY = "60a06040523480156200001157600080fd5b5060405162001f7b38038062001f7b833981810160405260e08110156200003757600080fd5b508051602082015160408301516060840151608085015160a086015160c090960151600080546001600160a01b03191633179055949593949293919290919062000085878787878762000136565b620000908162000228565b6001600160601b0319606083901b16608052620000ac620002a1565b620000b6620002a1565b60005b601f8160ff16101562000106576001838260ff16601f8110620000d857fe5b61ffff909216602092909202015260018260ff8316601f8110620000f857fe5b6020020152600101620000b9565b5062000116600483601f620002c0565b5062000126600882601f6200035d565b50505050505050505050620003a5565b6040805160a0808201835263ffffffff88811680845288821660208086018290528984168688018190528985166060808901829052958a1660809889018190526002805463ffffffff1916871763ffffffff60201b191664010000000087021763ffffffff60401b19166801000000000000000085021763ffffffff60601b19166c0100000000000000000000000084021763ffffffff60801b1916600160801b830217905589519586529285019390935283880152928201529283015291517fd0d9486a2c673e2a4b57fc82e4c8a556b3e2b82dd5db07e2c04a920ca0f469b6929181900390910190a15050505050565b6003546001600160a01b0390811690821681146200029d57600380546001600160a01b0319166001600160a01b03848116918217909255604080519284168352602083019190915280517f793cb73064f3c8cde7e187ae515511e6e56d1ee89bf08b82fa60fb70f8d489129281900390910190a15b5050565b604051806103e00160405280601f906020820280368337509192915050565b6002830191839082156200034b5791602002820160005b838211156200031957835183826101000a81548161ffff021916908361ffff1602179055509260200192600201602081600101049283019260010302620002d7565b8015620003495782816101000a81549061ffff021916905560020160208160010104928301926001030262000319565b505b50620003599291506200038e565b5090565b82601f81019282156200034b579160200282015b828111156200034b57825182559160200191906001019062000371565b5b808211156200035957600081556001016200038f565b60805160601c611b9f620003dc600039806105275280610c325280610d195280610e16528061126652806115b35250611b9f6000f3fe608060405234801561001057600080fd5b50600436106101005760003560e01c8063b121e14711610097578063e4902f8211610066578063e4902f821461033f578063eb5dcd6c1461037c578063f2fde38b146103aa578063fbffd2c1146103d057610100565b8063b121e147146102a0578063bd824706146102c6578063c10753291461030b578063d09dc3391461033757610100565b80638ac28d5a116100d35780638ac28d5a146101ac5780638da5cb5b146101d2578063996e8298146101da5780639c849b30146101e257610100565b80630eafb25b146101055780631b6b6d231461013d578063299372681461016157806379ba5097146101a2575b600080fd5b61012b6004803603602081101561011b57600080fd5b50356001600160a01b03166103f6565b60408051918252519081900360200190f35b610145610525565b604080516001600160a01b039092168252519081900360200190f35b610169610549565b6040805163ffffffff96871681529486166020860152928516848401529084166060840152909216608082015290519081900360a00190f35b6101aa6105aa565b005b6101aa600480360360208110156101c257600080fd5b50356001600160a01b0316610659565b6101456106d3565b6101456106e2565b6101aa600480360360408110156101f857600080fd5b810190602081018135600160201b81111561021257600080fd5b82018360208201111561022457600080fd5b803590602001918460208302840111600160201b8311171561024557600080fd5b919390929091602081019035600160201b81111561026257600080fd5b82018360208201111561027457600080fd5b803590602001918460208302840111600160201b8311171561029557600080fd5b5090925090506106f1565b6101aa600480360360208110156102b657600080fd5b50356001600160a01b03166108ff565b6101aa600480360360a08110156102dc57600080fd5b5063ffffffff8135811691602081013582169160408201358116916060810135821691608090910135166109e0565b6101aa6004803603604081101561032157600080fd5b506001600160a01b038135169060200135610b0f565b61012b610e11565b6103656004803603602081101561035557600080fd5b50356001600160a01b0316610ec2565b6040805161ffff9092168252519081900360200190f35b6101aa6004803603604081101561039257600080fd5b506001600160a01b0381358116916020013516610f6f565b6101aa600480360360208110156103c057600080fd5b50356001600160a01b03166110b3565b6101aa600480360360208110156103e657600080fd5b50356001600160a01b031661115c565b6001600160a01b03811660009081526027602090815260408083208151808301909252805460ff80821684528594840191610100900416600281111561043857fe5b600281111561044357fe5b905250905060008160200151600281111561045a57fe5b141561046a576000915050610520565b6040805160a08101825260025463ffffffff8082168352600160201b820481166020840152600160401b8204811693830193909352600160601b8104831660608301819052600160801b90910490921660808201528251909160009160019060049060ff16601f81106104d957fe5b601091828204019190066002029054906101000a900461ffff160361ffff1602633b9aca0002905060016008846000015160ff16601f811061051757fe5b01540301925050505b919050565b7f000000000000000000000000000000000000000000000000000000000000000081565b6040805160a08101825260025463ffffffff808216808452600160201b8304821660208501819052600160401b84048316958501869052600160601b8404831660608601819052600160801b90940490921660809094018490529490939290565b6001546001600160a01b03163314610602576040805162461bcd60e51b815260206004820152601660248201527526bab9ba10313290383937b837b9b2b21037bbb732b960511b604482015290519081900360640190fd5b60008054336001600160a01b0319808316821784556001805490911690556040516001600160a01b0390921692909183917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a350565b6001600160a01b038181166000908152600660205260409020541633146106c7576040805162461bcd60e51b815260206004820152601760248201527f4f6e6c792070617965652063616e207769746864726177000000000000000000604482015290519081900360640190fd5b6106d0816111bd565b50565b6000546001600160a01b031681565b6003546001600160a01b031690565b6000546001600160a01b03163314610749576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b82811461079d576040805162461bcd60e51b815260206004820181905260248201527f7472616e736d6974746572732e73697a6520213d207061796565732e73697a65604482015290519081900360640190fd5b60005b838110156108f85760008585838181106107b657fe5b905060200201356001600160a01b0316905060008484848181106107d657fe5b6001600160a01b0385811660009081526006602090815260409091205492029390930135831693509091169050801580806108225750826001600160a01b0316826001600160a01b0316145b610867576040805162461bcd60e51b81526020600482015260116024820152701c185e595948185b1c9958591e481cd95d607a1b604482015290519081900360640190fd5b6001600160a01b03848116600090815260066020526040902080546001600160a01b031916858316908117909155908316146108e857826001600160a01b0316826001600160a01b0316856001600160a01b03167f78af32efdcad432315431e9b03d27e6cd98fb79c405fdc5af7c1714d9c0f75b360405160405180910390a45b5050600190920191506107a09050565b5050505050565b6001600160a01b0381811660009081526007602052604090205416331461096d576040805162461bcd60e51b815260206004820152601f60248201527f6f6e6c792070726f706f736564207061796565732063616e2061636365707400604482015290519081900360640190fd5b6001600160a01b0381811660008181526006602090815260408083208054336001600160a01b031980831682179093556007909452828520805490921690915590519416939092849290917f78af32efdcad432315431e9b03d27e6cd98fb79c405fdc5af7c1714d9c0f75b39190a45050565b6003546000546001600160a01b039182169116331480610aa1575060408051630d629b5f60e31b815233600482018181526024830193845236604484018190526001600160a01b03861694636b14daf8946000939190606401848480828437600083820152604051601f909101601f1916909201965060209550909350505081840390508186803b158015610a7457600080fd5b505afa158015610a88573d6000803e3d6000fd5b505050506040513d6020811015610a9e57600080fd5b50515b610af2576040805162461bcd60e51b815260206004820181905260248201527f4f6e6c79206f776e65722662696c6c696e6741646d696e2063616e2063616c6c604482015290519081900360640190fd5b610afa6113c3565b610b078686868686611761565b505050505050565b6000546001600160a01b0316331480610bd1575060035460408051630d629b5f60e31b815233600482018181526024830193845236604484018190526001600160a01b0390951694636b14daf894929360009391929190606401848480828437600083820152604051601f909101601f1916909201965060209550909350505081840390508186803b158015610ba457600080fd5b505afa158015610bb8573d6000803e3d6000fd5b505050506040513d6020811015610bce57600080fd5b50515b610c22576040805162461bcd60e51b815260206004820181905260248201527f4f6e6c79206f776e65722662696c6c696e6741646d696e2063616e2063616c6c604482015290519081900360640190fd5b6000610c2c61184a565b905060007f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166370a08231306040518263ffffffff1660e01b815260040180826001600160a01b0316815260200191505060206040518083038186803b158015610c9d57600080fd5b505afa158015610cb1573d6000803e3d6000fd5b505050506040513d6020811015610cc757600080fd5b5051905081811015610d17576040805162461bcd60e51b8152602060048201526014602482015273696e73756666696369656e742062616c616e636560601b604482015290519081900360640190fd5b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b031663a9059cbb85610d53858503876119fe565b6040518363ffffffff1660e01b815260040180836001600160a01b0316815260200182815260200192505050602060405180830381600087803b158015610d9957600080fd5b505af1158015610dad573d6000803e3d6000fd5b505050506040513d6020811015610dc357600080fd5b5051610e0b576040805162461bcd60e51b8152602060048201526012602482015271696e73756666696369656e742066756e647360701b604482015290519081900360640190fd5b50505050565b6000807f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166370a08231306040518263ffffffff1660e01b815260040180826001600160a01b0316815260200191505060206040518083038186803b158015610e8157600080fd5b505afa158015610e95573d6000803e3d6000fd5b505050506040513d6020811015610eab57600080fd5b505190506000610eb961184a565b90910391505090565b6001600160a01b03811660009081526027602090815260408083208151808301909252805460ff808216845285948401916101009004166002811115610f0457fe5b6002811115610f0f57fe5b9052509050600081602001516002811115610f2657fe5b1415610f36576000915050610520565b60016004826000015160ff16601f8110610f4c57fe5b601091828204019190066002029054906101000a900461ffff1603915050919050565b6001600160a01b03828116600090815260066020526040902054163314610fdd576040805162461bcd60e51b815260206004820152601d60248201527f6f6e6c792063757272656e742070617965652063616e20757064617465000000604482015290519081900360640190fd5b336001600160a01b038216141561103b576040805162461bcd60e51b815260206004820152601760248201527f63616e6e6f74207472616e7366657220746f2073656c66000000000000000000604482015290519081900360640190fd5b6001600160a01b03808316600090815260076020526040902080548383166001600160a01b0319821681179092559091169081146110ae576040516001600160a01b038084169133918616907f84f7c7c80bb8ed2279b4aab5f61cd05e6374073d38f46d7f32de8c30e9e3836790600090a45b505050565b6000546001600160a01b0316331461110b576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b600180546001600160a01b0319166001600160a01b0383811691821790925560008054604051929316917fed8889f560326eb138920d842192f0eb3dd22b4f139c87a2c57538e05bae12789190a350565b6000546001600160a01b031633146111b4576040805162461bcd60e51b815260206004820152601660248201527527b7363c9031b0b63630b1363290313c9037bbb732b960511b604482015290519081900360640190fd5b6106d081611a18565b6001600160a01b03811660009081526027602090815260408083208151808301909252805460ff8082168452929391929184019161010090910416600281111561120357fe5b600281111561120e57fe5b9052509050600061121e836103f6565b905080156110ae576001600160a01b03808416600090815260066020908152604080832054815163a9059cbb60e01b81529085166004820181905260248201879052915191947f0000000000000000000000000000000000000000000000000000000000000000169363a9059cbb9360448084019491939192918390030190829087803b1580156112ae57600080fd5b505af11580156112c2573d6000803e3d6000fd5b505050506040513d60208110156112d857600080fd5b5051611320576040805162461bcd60e51b8152602060048201526012602482015271696e73756666696369656e742066756e647360701b604482015290519081900360640190fd5b60016004846000015160ff16601f811061133657fe5b601091828204019190066002026101000a81548161ffff021916908361ffff16021790555060016008846000015160ff16601f811061137157fe5b0155604080516001600160a01b0380871682528316602082015280820184905290517fe8ec50e5150ae28ae37e493ff389ffab7ffaec2dc4dccfca03f12a3de29d12b29181900360600190a150505050565b6040805160a08101825260025463ffffffff8082168352600160201b820481166020840152600160401b8204811683850152600160601b820481166060840152600160801b90910416608082015281516103e0810192839052909160009190600490601f908285855b82829054906101000a900461ffff1661ffff168152602001906002019060208260010104928301926001038202915080841161142c575050604080516103e0810191829052959650600095945060089350601f9250905082845b8154815260200190600101908083116114865750505050509050600060298054806020026020016040519081016040528092919081815260200182805480156114f857602002820191906000526020600020905b81546001600160a01b031681526001909101906020018083116114da575b5050505050905060005b815181101561174557600060018483601f811061151b57fe5b6020020151039050600060018684601f811061153357fe5b60200201510361ffff169050600082886060015163ffffffff168302633b9aca0002019050600081111561173a5760006006600087878151811061157357fe5b60200260200101516001600160a01b03166001600160a01b0316815260200190815260200160002060009054906101000a90046001600160a01b031690507f00000000000000000000000000000000000000000000000000000000000000006001600160a01b031663a9059cbb82846040518363ffffffff1660e01b815260040180836001600160a01b0316815260200182815260200192505050602060405180830381600087803b15801561162857600080fd5b505af115801561163c573d6000803e3d6000fd5b505050506040513d602081101561165257600080fd5b505161169a576040805162461bcd60e51b8152602060048201526012602482015271696e73756666696369656e742066756e647360701b604482015290519081900360640190fd5b60018886601f81106116a857fe5b61ffff909216602092909202015260018786601f81106116c457fe5b602002015285517fe8ec50e5150ae28ae37e493ff389ffab7ffaec2dc4dccfca03f12a3de29d12b2908790879081106116f957fe5b6020026020010151828460405180846001600160a01b03168152602001836001600160a01b03168152602001828152602001935050505060405180910390a1505b505050600101611502565b50611753600484601f611a90565b506108f8600883601f611b26565b6040805160a0808201835263ffffffff88811680845288821660208086018290528984168688018190528985166060808901829052958a1660809889018190526002805463ffffffff1916871767ffffffff000000001916600160201b8702176bffffffff00000000000000001916600160401b85021763ffffffff60601b1916600160601b84021763ffffffff60801b1916600160801b830217905589519586529285019390935283880152928201529283015291517fd0d9486a2c673e2a4b57fc82e4c8a556b3e2b82dd5db07e2c04a920ca0f469b6929181900390910190a15050505050565b604080516103e0810191829052600091829190600490601f908285855b82829054906101000a900461ffff1661ffff16815260200190600201906020826001010492830192600103820291508084116118675790505050505050905060005b601f8110156118d75760018282601f81106118c057fe5b60200201510361ffff1692909201916001016118a9565b506040805160a08101825260025463ffffffff8082168352600160201b82048116602080850191909152600160401b8304821684860152600160601b8304821660608501819052600160801b90930490911660808401526029805485518184028101840190965280865296909202633b9aca000295929360009390929183018282801561198d57602002820191906000526020600020905b81546001600160a01b0316815260019091019060200180831161196f575b5050604080516103e0810191829052949550600094935060089250601f915082845b8154815260200190600101908083116119af575050505050905060005b82518110156119f65760018282601f81106119e357fe5b60200201510395909501946001016119cc565b505050505090565b600081831015611a0f575081611a12565b50805b92915050565b6003546001600160a01b039081169082168114611a8c57600380546001600160a01b0319166001600160a01b03848116918217909255604080519284168352602083019190915280517f793cb73064f3c8cde7e187ae515511e6e56d1ee89bf08b82fa60fb70f8d489129281900390910190a15b5050565b600283019183908215611b165791602002820160005b83821115611ae657835183826101000a81548161ffff021916908361ffff1602179055509260200192600201602081600101049283019260010302611aa6565b8015611b145782816101000a81549061ffff0219169055600201602081600101049283019260010302611ae6565b505b50611b22929150611b54565b5090565b82601f8101928215611b16579160200282015b82811115611b16578251825591602001919060010190611b39565b5b80821115611b225760008155600101611b5556fea264697066735822122018bb5a1931681b96e69372dd7f7ab806a3b5eeb7493b74f947a5ccdddb39e7fa64736f6c63430007060033";

    public static final String FUNC_LINK = "LINK";

    public static final String FUNC_ACCEPTOWNERSHIP = "acceptOwnership";

    public static final String FUNC_ACCEPTPAYEESHIP = "acceptPayeeship";

    public static final String FUNC_BILLINGACCESSCONTROLLER = "billingAccessController";

    public static final String FUNC_GETBILLING = "getBilling";

    public static final String FUNC_LINKAVAILABLEFORPAYMENT = "linkAvailableForPayment";

    public static final String FUNC_ORACLEOBSERVATIONCOUNT = "oracleObservationCount";

    public static final String FUNC_OWEDPAYMENT = "owedPayment";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETBILLING = "setBilling";

    public static final String FUNC_SETBILLINGACCESSCONTROLLER = "setBillingAccessController";

    public static final String FUNC_SETPAYEES = "setPayees";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_TRANSFERPAYEESHIP = "transferPayeeship";

    public static final String FUNC_WITHDRAWFUNDS = "withdrawFunds";

    public static final String FUNC_WITHDRAWPAYMENT = "withdrawPayment";

    public static final Event BILLINGACCESSCONTROLLERSET_EVENT = new Event("BillingAccessControllerSet", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event BILLINGSET_EVENT = new Event("BillingSet", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}));
    ;

    public static final Event ORACLEPAID_EVENT = new Event("OraclePaid", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERREQUESTED_EVENT = new Event("OwnershipTransferRequested", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PAYEESHIPTRANSFERREQUESTED_EVENT = new Event("PayeeshipTransferRequested", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PAYEESHIPTRANSFERRED_EVENT = new Event("PayeeshipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected OffchainAggregatorBilling(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected OffchainAggregatorBilling(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected OffchainAggregatorBilling(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected OffchainAggregatorBilling(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<BillingAccessControllerSetEventResponse> getBillingAccessControllerSetEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BILLINGACCESSCONTROLLERSET_EVENT, transactionReceipt);
        ArrayList<BillingAccessControllerSetEventResponse> responses = new ArrayList<BillingAccessControllerSetEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BillingAccessControllerSetEventResponse typedResponse = new BillingAccessControllerSetEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.old = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.current = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BillingAccessControllerSetEventResponse> billingAccessControllerSetEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BillingAccessControllerSetEventResponse>() {
            @Override
            public BillingAccessControllerSetEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BILLINGACCESSCONTROLLERSET_EVENT, log);
                BillingAccessControllerSetEventResponse typedResponse = new BillingAccessControllerSetEventResponse();
                typedResponse.log = log;
                typedResponse.old = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.current = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BillingAccessControllerSetEventResponse> billingAccessControllerSetEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BILLINGACCESSCONTROLLERSET_EVENT));
        return billingAccessControllerSetEventFlowable(filter);
    }

    public List<BillingSetEventResponse> getBillingSetEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BILLINGSET_EVENT, transactionReceipt);
        ArrayList<BillingSetEventResponse> responses = new ArrayList<BillingSetEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BillingSetEventResponse typedResponse = new BillingSetEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.maximumGasPrice = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.reasonableGasPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.microLinkPerEth = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.linkGweiPerObservation = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.linkGweiPerTransmission = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BillingSetEventResponse> billingSetEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BillingSetEventResponse>() {
            @Override
            public BillingSetEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BILLINGSET_EVENT, log);
                BillingSetEventResponse typedResponse = new BillingSetEventResponse();
                typedResponse.log = log;
                typedResponse.maximumGasPrice = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.reasonableGasPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.microLinkPerEth = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.linkGweiPerObservation = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.linkGweiPerTransmission = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BillingSetEventResponse> billingSetEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BILLINGSET_EVENT));
        return billingSetEventFlowable(filter);
    }

    public List<OraclePaidEventResponse> getOraclePaidEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ORACLEPAID_EVENT, transactionReceipt);
        ArrayList<OraclePaidEventResponse> responses = new ArrayList<OraclePaidEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OraclePaidEventResponse typedResponse = new OraclePaidEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.transmitter = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.payee = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OraclePaidEventResponse> oraclePaidEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OraclePaidEventResponse>() {
            @Override
            public OraclePaidEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ORACLEPAID_EVENT, log);
                OraclePaidEventResponse typedResponse = new OraclePaidEventResponse();
                typedResponse.log = log;
                typedResponse.transmitter = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.payee = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OraclePaidEventResponse> oraclePaidEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ORACLEPAID_EVENT));
        return oraclePaidEventFlowable(filter);
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

    public List<PayeeshipTransferRequestedEventResponse> getPayeeshipTransferRequestedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAYEESHIPTRANSFERREQUESTED_EVENT, transactionReceipt);
        ArrayList<PayeeshipTransferRequestedEventResponse> responses = new ArrayList<PayeeshipTransferRequestedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PayeeshipTransferRequestedEventResponse typedResponse = new PayeeshipTransferRequestedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.transmitter = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.current = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.proposed = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PayeeshipTransferRequestedEventResponse> payeeshipTransferRequestedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PayeeshipTransferRequestedEventResponse>() {
            @Override
            public PayeeshipTransferRequestedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAYEESHIPTRANSFERREQUESTED_EVENT, log);
                PayeeshipTransferRequestedEventResponse typedResponse = new PayeeshipTransferRequestedEventResponse();
                typedResponse.log = log;
                typedResponse.transmitter = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.current = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.proposed = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PayeeshipTransferRequestedEventResponse> payeeshipTransferRequestedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYEESHIPTRANSFERREQUESTED_EVENT));
        return payeeshipTransferRequestedEventFlowable(filter);
    }

    public List<PayeeshipTransferredEventResponse> getPayeeshipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAYEESHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<PayeeshipTransferredEventResponse> responses = new ArrayList<PayeeshipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PayeeshipTransferredEventResponse typedResponse = new PayeeshipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.transmitter = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previous = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.current = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PayeeshipTransferredEventResponse> payeeshipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PayeeshipTransferredEventResponse>() {
            @Override
            public PayeeshipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAYEESHIPTRANSFERRED_EVENT, log);
                PayeeshipTransferredEventResponse typedResponse = new PayeeshipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.transmitter = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.previous = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.current = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PayeeshipTransferredEventResponse> payeeshipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYEESHIPTRANSFERRED_EVENT));
        return payeeshipTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<String> LINK() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LINK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ACCEPTOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptPayeeship(String _transmitter) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ACCEPTPAYEESHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _transmitter)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> billingAccessController() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BILLINGACCESSCONTROLLER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getBilling() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBILLING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}));
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

    public RemoteFunctionCall<BigInteger> linkAvailableForPayment() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LINKAVAILABLEFORPAYMENT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> oracleObservationCount(String _signerOrTransmitter) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ORACLEOBSERVATIONCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _signerOrTransmitter)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> owedPayment(String _transmitter) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWEDPAYMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _transmitter)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setBilling(BigInteger _maximumGasPrice, BigInteger _reasonableGasPrice, BigInteger _microLinkPerEth, BigInteger _linkGweiPerObservation, BigInteger _linkGweiPerTransmission) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBILLING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_maximumGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_reasonableGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_microLinkPerEth), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerObservation), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerTransmission)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBillingAccessController(String _billingAccessController) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBILLINGACCESSCONTROLLER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _billingAccessController)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setPayees(List<String> _transmitters, List<String> _payees) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETPAYEES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_transmitters, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_payees, org.web3j.abi.datatypes.Address.class))), 
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

    public RemoteFunctionCall<TransactionReceipt> transferPayeeship(String _transmitter, String _proposed) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERPAYEESHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _transmitter), 
                new org.web3j.abi.datatypes.Address(160, _proposed)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawFunds(String _recipient, BigInteger _amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAWFUNDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawPayment(String _transmitter) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAWPAYMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _transmitter)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static OffchainAggregatorBilling load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new OffchainAggregatorBilling(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static OffchainAggregatorBilling load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new OffchainAggregatorBilling(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static OffchainAggregatorBilling load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new OffchainAggregatorBilling(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static OffchainAggregatorBilling load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new OffchainAggregatorBilling(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<OffchainAggregatorBilling> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _maximumGasPrice, BigInteger _reasonableGasPrice, BigInteger _microLinkPerEth, BigInteger _linkGweiPerObservation, BigInteger _linkGweiPerTransmission, String _link, String _billingAccessController) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_maximumGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_reasonableGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_microLinkPerEth), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerObservation), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerTransmission), 
                new org.web3j.abi.datatypes.Address(160, _link), 
                new org.web3j.abi.datatypes.Address(160, _billingAccessController)));
        return deployRemoteCall(OffchainAggregatorBilling.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<OffchainAggregatorBilling> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _maximumGasPrice, BigInteger _reasonableGasPrice, BigInteger _microLinkPerEth, BigInteger _linkGweiPerObservation, BigInteger _linkGweiPerTransmission, String _link, String _billingAccessController) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_maximumGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_reasonableGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_microLinkPerEth), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerObservation), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerTransmission), 
                new org.web3j.abi.datatypes.Address(160, _link), 
                new org.web3j.abi.datatypes.Address(160, _billingAccessController)));
        return deployRemoteCall(OffchainAggregatorBilling.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<OffchainAggregatorBilling> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _maximumGasPrice, BigInteger _reasonableGasPrice, BigInteger _microLinkPerEth, BigInteger _linkGweiPerObservation, BigInteger _linkGweiPerTransmission, String _link, String _billingAccessController) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_maximumGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_reasonableGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_microLinkPerEth), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerObservation), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerTransmission), 
                new org.web3j.abi.datatypes.Address(160, _link), 
                new org.web3j.abi.datatypes.Address(160, _billingAccessController)));
        return deployRemoteCall(OffchainAggregatorBilling.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<OffchainAggregatorBilling> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _maximumGasPrice, BigInteger _reasonableGasPrice, BigInteger _microLinkPerEth, BigInteger _linkGweiPerObservation, BigInteger _linkGweiPerTransmission, String _link, String _billingAccessController) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_maximumGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_reasonableGasPrice), 
                new org.web3j.abi.datatypes.generated.Uint32(_microLinkPerEth), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerObservation), 
                new org.web3j.abi.datatypes.generated.Uint32(_linkGweiPerTransmission), 
                new org.web3j.abi.datatypes.Address(160, _link), 
                new org.web3j.abi.datatypes.Address(160, _billingAccessController)));
        return deployRemoteCall(OffchainAggregatorBilling.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class BillingAccessControllerSetEventResponse extends BaseEventResponse {
        public String old;

        public String current;
    }

    public static class BillingSetEventResponse extends BaseEventResponse {
        public BigInteger maximumGasPrice;

        public BigInteger reasonableGasPrice;

        public BigInteger microLinkPerEth;

        public BigInteger linkGweiPerObservation;

        public BigInteger linkGweiPerTransmission;
    }

    public static class OraclePaidEventResponse extends BaseEventResponse {
        public String transmitter;

        public String payee;

        public BigInteger amount;
    }

    public static class OwnershipTransferRequestedEventResponse extends BaseEventResponse {
        public String from;

        public String to;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String from;

        public String to;
    }

    public static class PayeeshipTransferRequestedEventResponse extends BaseEventResponse {
        public String transmitter;

        public String current;

        public String proposed;
    }

    public static class PayeeshipTransferredEventResponse extends BaseEventResponse {
        public String transmitter;

        public String previous;

        public String current;
    }
}
