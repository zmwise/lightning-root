package com.osc.common.exception;

/**
 * @description: 业务异常
 * @author: lizhiming
 * @since: 2017/12/6
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int code;

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(int code, String message){
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
