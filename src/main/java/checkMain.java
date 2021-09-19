/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: checkMain
 * Author:   asus
 * Date:     2021/9/18 23:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import static paperPass.check.check;
import static utils.readAndWrite.writeText;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author asus
 * @create 2021/9/18
 * @since 1.0.0
 */
public class checkMain {

    public static void main(String[] args) {
        String path1=args[0];//获取原文路径
        String path2=args[1];//获取抄袭论文路径
        String path3=args[2];//获取写出论文路径
        String check =String.valueOf(check(path1,path2,path3)*100);//计算余弦相似度
        writeText(path3, check+"%");//将结果写出
    }

}