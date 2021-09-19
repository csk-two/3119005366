/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: readAndWrite
 * Author:   asus
 * Date:     2021/9/13 14:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package utils;

import java.io.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author asus
 * @create 2021/9/13
 * @since 1.0.0
 */
public class readAndWrite {
    //读取文件
    public static String readText(String textPath) {
        Reader reader = null;
        StringBuilder builder = null;
        if (textPath == null || textPath.length() == 0) {
            return "错误";
        }
        try {
            reader = new FileReader(textPath);
            builder = new StringBuilder();
            // 2.定义字符数组
            char[] chs = new char[1024];
            // 定义一个变量，记录读到的有效字符数.
            int len;
            while ((len = reader.read(chs)) != -1) {
                /*
                    chs：表示要操作的数组.
                    0：表示起始索引.
                    len：表示要操作字符的个数.
                */
                String s = new String(chs, 0, len);
                builder.append(s);
            }
        } catch (IOException e) {
            System.out.println("读取文件出错！");
            e.printStackTrace();
        } finally {
            //3.释放资源
            try {
                // 判断输出流是否为空
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("关闭输出流出错！");
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
    //写出文件
    public static void writeText(String textPath, String content) {
        Writer writer = null;
        try {
            //1.创建创建文件对象与字符输出流对象
            File file = new File(textPath);
            writer = new FileWriter(file);

            //2.写数据
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.err.println("读取异常");
        }
    }
}