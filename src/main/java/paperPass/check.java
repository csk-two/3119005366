/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: check
 * Author:   asus
 * Date:     2021/9/13 14:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package paperPass;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.junit.Test;
import utils.selectWord;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static oracle.jrockit.jfr.events.Bits.doubleValue;
import static utils.getRate.getRate;
import static utils.selectWord.selectWord;
import static utils.readAndWrite.readText;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author asus
 * @create 2021/9/13
 * @since 1.0.0
 */
public class check {
    //计算出词向量的余弦相似度
    static public Double check(String path1, String path2, String path3) {

        String wordStr = readText(path1);//读取原文的词语为字符串
        List<Term> segment = HanLP.segment(wordStr);//提取出其中的词语(包含标点符号)
        Set<String> set = selectWord(segment);//不重复的取出词语(不含标点符号）
        Map<String, Integer> orate = getRate(path1, set);//以原文为词库,将原文转化为词频向量,存在Map中
        Map<String, Integer> crate = getRate(path2, set);//将需要查重的存在Map中

        //最后的结果
        double result = 0.0;
        //余弦方程的上部
        double equationUp = 0;
        //余弦方程的下部部分一
        double equationDown1 = 0;
        //余弦方程的下部部分二
        double equationDown2 = 0;
        //每一个词的相似度相加
        double sum = 0;
        for (String s : set) {
            Integer n1 = orate.get(s);
            Integer n2 = crate.get(s);
            double v1 = doubleValue(n1);
            double v2 = doubleValue(n2);
            equationUp += v1 * v2;
            equationDown1 += v1 * v1;
            equationDown2 += v2 * v2;
        }
        result = equationUp / (Math.sqrt(equationDown1) * Math.sqrt(equationDown2));//计算余弦相似度
        return result;
    }
}