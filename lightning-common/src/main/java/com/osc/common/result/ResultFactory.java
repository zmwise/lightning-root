package com.osc.common.result;

import com.baomidou.mybatisplus.plugins.Page;
import com.osc.common.constant.status.Status;

import java.util.List;
import java.util.Map;

/**
 * @description: 返回结果生成工厂类
 * @author: lizhiming
 * @since: 2017/11/25
 */
public class ResultFactory {

    private static final Result successResult = new Result(Status.SUCCESS, Status.SUCCESS_MSG);

    private ResultFactory() {
    }

    /**
     * 生成返回成功结果
     */
    public static Result successResult() {
        return successResult;
    }

    /**
     * 生成返回成功结果T data
     */
    public static <T> Result successData(T data){
        return new Result(Status.SUCCESS, Status.SUCCESS_MSG,data);
    }

    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @return 结果对象
     */
    public static Result result(int code, String msg) {
        return new Result(code, msg);
    }

    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @param listData
     *            数据对象
     * @return 结果对象
     */
    public static <T> Result result(int code, String msg, List<T> listData) {
        if (listData instanceof Page) {
            Page<T> page = (Page<T>) listData;
            return new Result(code, msg, page);
        } else {
            return new Result(code, msg, listData);
        }
    }

    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @param data
     *            数据对象
     * @return 结果对象
     */
    public static <T> Result result(int code, String msg, T data) {
        return new Result(code, msg, data);
    }

    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @param mapData
     *            数据对象
     * @return 结果对象
     */
    public static <K, V> Result result(int code, String msg, Map<K, V> mapData) {
        return new Result(code, msg, mapData);
    }
}
