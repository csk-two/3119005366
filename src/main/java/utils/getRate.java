package utils; /**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: getRate
 * Author:   asus
 * Date:     2021/9/18 21:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */


import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static utils.readAndWrite.readText;
import static utils.selectWord.selectWordList;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author asus
 * @create 2021/9/18
 * @since 1.0.0
 */
public class getRate {

    static public Map<String, Integer> getRate(String path, Set<String> WordSet) {
        int number = 0;
        Map<String, Integer> wordRate = new HashMap<>();
        String TextStr = readText(path);
        List<Term> word = HanLP.segment(TextStr);
        List<String> wordList = selectWordList(word);
        for (String s : WordSet) {
            number = 0;
            for (String s1 : wordList) {
                if (s.equals(s1)) {
                    number++;
                    wordRate.put(s, number);
                }
            }
        }
        return wordRate;
    }

}