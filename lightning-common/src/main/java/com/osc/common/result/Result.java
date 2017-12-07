package com.osc.common.result;

/**
 * @description: 返回结果对象
 * @author: lizhiming
 * @since: 2017/11/25
 */
public class Result {

    private int code;
    private String msg;
    private Object data;

    protected Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    protected Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
