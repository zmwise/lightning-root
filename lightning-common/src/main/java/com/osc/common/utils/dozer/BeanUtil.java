package com.osc.common.utils.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: 简单封装Dozer,实现深度转换实现:
 *              1. 持有Mapper的单例
 *              2. 返回值类型转换
 *              3. 批量转换Collection中的所有对象
 *              4. 区分创建新的B对象与将对象A值复制到已存在的B对象两种函数
 * @author: lizhiming
 * @since: 2017/11/28
 */
public class BeanUtil extends DozerBeanMapper{

    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    private static Mapper dozerMapper;

    public void setDozerMapper(Mapper mapper) {
        BeanUtil.dozerMapper = mapper;
    }

    public Mapper getDozerMapper() {
        return BeanUtil.dozerMapper;
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<T>();
        if (sourceList == null) {
            return null;
        }
        for (Object sourceObject : sourceList) {
            T destinationObject = dozerMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
