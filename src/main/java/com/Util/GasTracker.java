package com.example.springboot_fastweb.web3config;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.web3j.utils.Numeric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.ROUND_DOWN;

/**
 * 以太坊Gas追踪器 (Ethereum Gas Tracker)
 *
 * @author justin
 * @create 2022-03-21 17-08
 */
public class GasTracker {
    //ALCHEMY
    //public static String ALCHEMYURL = "https://eth-mainnet.alchemyapi.io/v2/API-KEY";
    //INFURA
    public static String INFURAURL = "https://mainnet.infura.io/v3/API-KEY";
    //gwei单位(gwei unit)
    public static BigDecimal GWEI = new BigDecimal("1000000000");
    public static BigDecimal PERCENTAGE = new BigDecimal("100");
    //历史范围区块数(The number of blocks for which to fetch historical fees. Can be an integer or a hex string.)
    public static Integer BLOCKRANGE = 10;
    //开始搜索的块,从当前往后看 可以是16进制字符串或预定义的块字符串 例如:"latest" (The block to start the search. The result will look backwards from here. Can be a hex string or a predefined block string e.g. "latest".)
    public static String STARTINGBLOCK = "latest";
    //一组数字,用于定义每个区块查看的奖励值的百分位数 25%,50%,75% ((Optional) An array of numbers that define which percentiles of reward values you want to see for each block.)
    public static Object[] PERCENTILES = {25, 50, 75};
    //method
    public static String ETH_FEEHISTORY = "eth_feeHistory";

    public static void main(String[] args) {
        Object[] params = {BLOCKRANGE, STARTINGBLOCK, PERCENTILES};
        Map map = setMap(ETH_FEEHISTORY, params);
        String jsonString = JSON.toJSONString(map);
        String requestResult = HttpRequest.post(INFURAURL).body(jsonString).execute().body();
        JSONObject resultJsonObject = JSONObject.parseObject(requestResult);
        JSONObject alchemyResult = resultJsonObject.getJSONObject("result");
        String oldestBlock = alchemyResult.getString("oldestBlock");
        JSONArray reward = alchemyResult.getJSONArray("reward");
        JSONArray baseFeePerGas = alchemyResult.getJSONArray("baseFeePerGas");
        JSONArray gasUsedRatio = alchemyResult.getJSONArray("gasUsedRatio");
        BigInteger decodedStr = Numeric.toBigInt(oldestBlock);
        JSONArray jsonArray = new JSONArray();
        BigDecimal avgFill = BigDecimal.ZERO;
        BigDecimal avgGasFee = BigDecimal.ZERO;
        JSONObject responseResultJsonObject = new JSONObject();
        for (int i = 0; i < reward.size(); i++) {
            Object rewardResult = reward.get(i);
            JSONArray list = (JSONArray) rewardResult;
            List<BigDecimal> newReward = new ArrayList<>();
            for (int k = 0; k < list.size(); k++) {
                String rewardNumber = list.getString(k);
                BigDecimal decodedRewardNumber = new BigDecimal(Numeric.toBigInt(rewardNumber));
                decodedRewardNumber = decodedRewardNumber.divide(GWEI, 0, RoundingMode.HALF_UP);
                newReward.add(decodedRewardNumber);
            }
            Object baseFeePerGasResult = baseFeePerGas.get(i);
            BigDecimal decodedBaseFeePerGasResult = new BigDecimal(Numeric.toBigInt(String.valueOf(baseFeePerGasResult)));
            decodedBaseFeePerGasResult = decodedBaseFeePerGasResult.divide(GWEI, 8, ROUND_DOWN);
            Object gasUsedRatioResult = gasUsedRatio.get(i);

            BigDecimal castDecodedGasUsedRatioResult = new BigDecimal(String.valueOf(gasUsedRatioResult));
            castDecodedGasUsedRatioResult = castDecodedGasUsedRatioResult.multiply(PERCENTAGE).setScale(2, RoundingMode.HALF_UP);

            avgFill = avgFill.add(castDecodedGasUsedRatioResult);
            avgGasFee = avgGasFee.add(decodedBaseFeePerGasResult);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("blockNumber", decodedStr.add(BigInteger.valueOf(i)));
            jsonObject.put("reward", newReward);
            jsonObject.put("baseFeePerGas", decodedBaseFeePerGasResult);
            jsonObject.put("gasUsedRatio", castDecodedGasUsedRatioResult.stripTrailingZeros().toPlainString() + "%");
            jsonArray.add(jsonObject);
        }
        avgFill = avgFill.divide(new BigDecimal(BLOCKRANGE), 2, RoundingMode.HALF_UP);
        avgGasFee = avgGasFee.divide(new BigDecimal(BLOCKRANGE), 0, RoundingMode.HALF_UP);
        responseResultJsonObject.put("gasList", jsonArray);
        responseResultJsonObject.put("avgFill", avgFill.stripTrailingZeros().toPlainString() + "%");
        responseResultJsonObject.put("avgGasFee", avgGasFee);
        System.out.println(responseResultJsonObject);
    }

    public static Map setMap(String method, Object params) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("jsonrpc", "2.0");
        map.put("method", method);
        map.put("params", params);
        map.put("id", "1");
        return map;
    }
}
