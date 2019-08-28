/**
 * 
 */
package org.jpractice.zuul;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-30 19:16:45
 * @Description: TODO
 * @version V1.0
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception ex, HttpServletResponse response) {
        return "xxx";
    }
}
