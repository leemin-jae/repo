//blockchain.js 모듈을 가져와 씀
const Blockchain = require('./blockchain');

//위에서 가져온 모듈의 객체 생성
const bitcoin = new Blockchain();

//제네시스 블록
console.log(bitcoin)

const previousBlockHash = '0INAISDFN09N09ASDNF90N90ASNDF';
const currentBlockData = [
    {
        amount: 101,
        sender: 'N90ANS90N90ANSDFN',
        recipient: '90NA90SNDF90ANSDF09N',
    },
    {
        amount: 30,
        sender: '09ANS09DFNA8SDNF',
        recipient: 'UIANSIUDFUIABSDUIFB',
    },
    {
        amount: 200,
        sender: '89ANS89DFN98ASNDF89',
        recipient: 'AUSDF89ANSD9FNASD',
    }
];

const nonce = 0;

console.log(bitcoin.hashBlock (previousBlockHash, currentBlockData, nonce));