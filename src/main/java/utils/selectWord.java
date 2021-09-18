/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: selectWord
 * Author:   asus
 * Date:     2021/9/13 19:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package utils;

import com.hankcs.hanlp.seg.common.Term;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author asus
 * @create 2021/9/13
 * @since 1.0.0
 */
public class selectWord {

    static public Set<String> selectWord(List<Term> terms) {
        Set<String> words = new HashSet<>();
        for (Term term : terms) {
            for (int i = 0; i < term.word.length(); i++) {
                char s = term.word.charAt(i);
                if (!String.valueOf(s).matches("[\\u4e00-\\u9fa5]")) {
                    continue;
                } else {
                    if (i == term.word.length() - 1) {
                        words.add(term.word);
                    }
                }
            }
        }
        return words;
    }

    static public List<String> selectWordList(List<Term> terms) {
        List<String> words = new ArrayList<>();
        for (Term term : terms) {
            for (int i = 0; i < term.word.length(); i++) {
                char s = term.word.charAt(i);
                if (!String.valueOf(s).matches("[\\u4e00-\\u9fa5]")) {
                    continue;
                } else {
                    if (i == term.word.length() - 1) {
                        words.add(term.word);
                    }
                }
            }
        }
        return words;
    }

}