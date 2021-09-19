/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: FileException
 * Author:   asus
 * Date:     2021/9/19 10:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exception;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author asus
 * @create 2021/9/19
 * @since 1.0.0
 */
public class FileException extends Exception {
    public FileException() {
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(Throwable cause) {
        super(cause);
    }

    public FileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}