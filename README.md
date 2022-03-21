# GasTracker

基于Java构建的以太坊气体追踪器

Building an Ethereum Gas Tracker on Java

支持Alchemy,Infura及web3底层升级了EIP-1559提案的所有节点

Support Alchemy, Infura and web3 bottom layer upgrade all nodes of EIP-1559 proposal

喜欢的帮忙点个starred

If you like it, starred it

Example:
```json
{
    "avgFill": "43.98%",
    "avgGasFee": 18,
    "fastGasFee": 22,
    "slowGasFee": 14,
    "gasList": [
        {
            "reward": [
                1,
                2,
                38
            ],
            "blockNumber": 14429619,
            "baseFeePerGas": 22.38930059,
            "gasUsedRatio": "19.28%"
        },
        {
            "reward": [
                0,
                2,
                29
            ],
            "blockNumber": 14429620,
            "baseFeePerGas": 20.66971845,
            "gasUsedRatio": "84.64%"
        },
        {
            "reward": [
                1,
                3,
                10
            ],
            "blockNumber": 14429621,
            "baseFeePerGas": 22.45953658,
            "gasUsedRatio": "4.61%"
        },
        {
            "reward": [
                1,
                2,
                28
            ],
            "blockNumber": 14429622,
            "baseFeePerGas": 19.91086431,
            "gasUsedRatio": "18.9%"
        },
        {
            "reward": [
                1,
                2,
                12
            ],
            "blockNumber": 14429623,
            "baseFeePerGas": 18.36272359,
            "gasUsedRatio": "13.93%"
        },
        {
            "reward": [
                1,
                1,
                5
            ],
            "blockNumber": 14429624,
            "baseFeePerGas": 16.70701746,
            "gasUsedRatio": "62.36%"
        },
        {
            "reward": [
                2,
                3,
                31
            ],
            "blockNumber": 14429625,
            "baseFeePerGas": 17.22336955,
            "gasUsedRatio": "11.44%"
        },
        {
            "reward": [
                2,
                3,
                32
            ],
            "blockNumber": 14429626,
            "baseFeePerGas": 15.56315614,
            "gasUsedRatio": "20.03%"
        },
        {
            "reward": [
                1,
                2,
                10
            ],
            "blockNumber": 14429627,
            "baseFeePerGas": 14.39713478,
            "gasUsedRatio": "99.94%"
        },
        {
            "reward": [
                1,
                2,
                32
            ],
            "blockNumber": 14429628,
            "baseFeePerGas": 16.19477678,
            "gasUsedRatio": "74.42%"
        },
        {
            "reward": [
                1,
                2,
                22
            ],
            "blockNumber": 14429629,
            "baseFeePerGas": 17.18358802,
            "gasUsedRatio": "36.57%"
        },
        {
            "reward": [
                1,
                2,
                13
            ],
            "blockNumber": 14429630,
            "baseFeePerGas": 16.60678423,
            "gasUsedRatio": "30.77%"
        },
        {
            "reward": [
                0,
                2,
                57
            ],
            "blockNumber": 14429631,
            "baseFeePerGas": 15.80839661,
            "gasUsedRatio": "88.54%"
        },
        {
            "reward": [
                0,
                0,
                0
            ],
            "blockNumber": 14429632,
            "baseFeePerGas": 17.33155169,
            "gasUsedRatio": "0%"
        },
        {
            "reward": [
                2,
                2,
                40
            ],
            "blockNumber": 14429633,
            "baseFeePerGas": 15.16510773,
            "gasUsedRatio": "99.98%"
        },
        {
            "reward": [
                0,
                2,
                27
            ],
            "blockNumber": 14429634,
            "baseFeePerGas": 17.05999125,
            "gasUsedRatio": "87.9%"
        },
        {
            "reward": [
                0,
                2,
                35
            ],
            "blockNumber": 14429635,
            "baseFeePerGas": 18.67633025,
            "gasUsedRatio": "52.63%"
        },
        {
            "reward": [
                1,
                2,
                89
            ],
            "blockNumber": 14429636,
            "baseFeePerGas": 18.79894448,
            "gasUsedRatio": "44.36%"
        },
        {
            "reward": [
                0,
                2,
                12
            ],
            "blockNumber": 14429637,
            "baseFeePerGas": 18.53394714,
            "gasUsedRatio": "29.24%"
        },
        {
            "reward": [
                0,
                0,
                0
            ],
            "blockNumber": 14429638,
            "baseFeePerGas": 17.57200636,
            "gasUsedRatio": "0%"
        }
    ]
}
```