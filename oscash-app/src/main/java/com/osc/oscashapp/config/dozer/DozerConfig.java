package com.osc.oscashapp.config.dozer;

import com.alibaba.fastjson.JSON;
import com.osc.oscashcommon.utils.dozer.BeanUtil;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @description: DozerConfig
 * @author: lizhiming
 * @since: 2017/11/27
 */
@Configuration
public class DozerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(DozerConfig.class);

    @Bean(name = "org.dozer.Mapper")
    public BeanUtil dozerBean() {
        List<String> mappingFiles = Arrays.asList(
                "dozer/dozer-mapping-config.xml"
        );
        LOGGER.info("【Dozer配置】初始化加载配置文件>>"+ JSON.toJSONString(mappingFiles));
        BeanUtil dozerBean = new BeanUtil();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }
}





