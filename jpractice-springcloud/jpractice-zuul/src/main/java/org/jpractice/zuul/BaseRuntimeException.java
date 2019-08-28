/**
 * 
 */
package org.jpractice.zuul;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-21 18:45:50
 * @Description: TODO
 * @version V1.0
 */
public class BaseRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 3870860880677044873L;
    protected String errorCode;

    public BaseRuntimeException() {
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(String message) {
        super(message);
        this.errorCode = "400";
    }

    public BaseRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRuntimeException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.getErrorCode() + ":" + super.getMessage();
    }
}
