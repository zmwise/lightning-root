package com.osc.oscashcommon.constant.status;

/**
 * @description: HTTP状态码常量
 *  编号	已定义范围	分类
	1XX	100-101	信息提示
	2XX	200-206	成功
	3XX	300-305	重定向
	4XX	400-415	客户端错误
	5XX	500-505	服务器错误
	1XXX 1000-~ 业务状态码
 * @author: lizhiming
 * @since: 2017/11/10
 */
public class Status {

	//#########################自定义业务状态码【常用状态码】##############################
	/**
	 * (处理成功) 服务器处理请求，并成功返回处理结果
	 */
	public final static int SUCCESS = 1000;
	public final static String SUCCESS_MSG = "处理成功";




	//#########################http状态返回代码 1xx（临时响应）##############################
	/**
	 * （继续） 请求者应当继续提出请求。 服务器返回此代码表示已收到请求的第一部分，正在等待其余部分
	 */
	public final static int CONTINUE = 100;
	public final static String CONTINUE_MSG = "继续";

	/**
	 * （切换协议） 请求者已要求服务器切换协议，服务器已确认并准备切换
	 */
	public final static int SWITCHING_PROTOCOLS = 101;
	public final static String SWITCHING_PROTOCOLS_MSG = "切换协议";


	//#########################http状态返回代码 2xx （成功）################################
	/**
	 * （成功）  服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页
	 */
	public final static int OK = 200;
	public final static String OK_MSG = "成功";


	//#########################http状态返回代码 3xx （重定向）###############################
	/**
	 * （多种选择）  针对请求，服务器可执行多种操作
	 */
	public final static int MULTIPLE_CHOICES = 300;
	public final static String MULTIPLE_CHOICES_MSG = "多种选择";


	//#########################http状态返回代码 4xx（请求错误）##############################
	/**
	 * （错误请求） 服务器不理解请求的语法
	 */
	public final static int BAD_REQUEST = 400;
	public final static String BAD_REQUEST_MSG = "错误请求";
	/**
	 * （未授权） 请求要求身份验证
	 */
	public final static int UNAUTHORIZED = 401;
	public final static String UNAUTHORIZED_MSG = "未授权";
	/**
	 * （禁止） 服务器拒绝请求
	 */
	public final static int FORBIDDEN = 403;
	public final static String FORBIDDEN_MSG = "禁止";
	/**
	 * （未找到） 服务器找不到请求的网页
	 */
	public final static int NOT_FOUND = 404;
	public final static String NOT_FOUND_MSG = "未找到";


	//#########################http状态返回代码 5xx（服务器错误）############################
	/**
	 * （服务器内部错误） 服务器遇到错误，无法完成请求
	 */
	public final static int INTERNAL_SERVER_ERROR = 500;
	public final static String INTERNAL_SERVER_ERROR_MSG = "服务器内部错误";
	/**
	 * （服务不可用） 服务器目前无法使用（由于超载或停机维护）
	 */
	public final static int SERVICE_UNAVAILABLE = 503;
	public final static String SERVICE_UNAVAILABLE_MSG = "服务不可用";
	/**
	 * （网关超时）  服务器作为网关或代理，但是没有及时从上游服务器收到请求
	 */
	public final static int GATEWAY_TIMEOUT = 504;
	public final static String GATEWAY_TIMEOUT_MSG = "网关超时";

}
