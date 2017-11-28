package com.osc.oscashcommon.utils.ip;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.osc.oscashcommon.utils.common.CommonUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: IP工具类
 * @author: lizhiming
 * @since: 2017/11/27
 */
public class IPUtil {

    private static final Logger LOGGER = LogManager.getLogger(IPUtil.class);

    private static final String URL = "http://apis.baidu.com/apistore/iplookupservice/iplookup";
    private static final String APIKEY = "3de55e2300d42027a48f38c7de57ca6f";

    /**
     * 根据ip查询地址
     * @author oudebin
     * @param ip
     * @return
     */
    public static IPAddress getAddressByIP(String ip) {
        IPAddress ipAddress = null;
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod(URL);
        try {
            LOGGER.info("【IP工具类】根据查询地址IPod>>"+ip);
            method.addRequestHeader("apikey", APIKEY);
            method.setQueryString("ip="+ip);
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                String response = method.getResponseBodyAsString();
                LOGGER.info("【IP工具类】根据查询地址response>>"+response);
                if(StringUtils.isNotEmpty(response)) {
                    JSONObject jo = JSON.parseObject(response);
                    if(jo.getIntValue("errNum") == 0) {
                        JSONObject retData = jo.getJSONObject("retData");
                        ipAddress = new IPAddress();
                        ipAddress.setIp(retData.getString("ip"));
                        ipAddress.setCountry(retData.getString("country"));
                        ipAddress.setProvince(retData.getString("province"));
                        ipAddress.setCity(retData.getString("city"));
                        ipAddress.setDistrict(retData.getString("district"));
                        ipAddress.setCarrier(retData.getString("carrier"));
                    }
                }
                LOGGER.info("【IP工具类】根据查询地址response>>"+response);
            }
        } catch (Exception e) {
            LOGGER.info("【IP工具类】根据IP查询地址出现异常>>"+e);
        }
        return ipAddress;
    }

    /**
     * 获取访问者IP
     *
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过NGINX等反向代理软件后，这个方法会失效。
     *
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
     * 如果还不存在则调用Request .getRemoteAddr()。
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (CommonUtil.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (CommonUtil.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public static void main(String[] args) {
        System.out.println(getAddressByIP("163.177.151.109"));
    }
}
