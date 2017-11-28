package com.osc.oscashcommon.utils.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: 简单封装Dozer,实现深度转换Bean<->Bean的Mapper.实现:
 *              1. 持有Mapper的单例
 *              2. 返回值类型转换
 *              3. 批量转换Collection中的所有对象
 *              4. 区分创建新的B对象与将对象A值复制到已存在的B对象两种函数
 * @author: lizhiming
 * @since: 2017/11/28
 */
public class BeanMapper {
    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    static Mapper mapper = null;

    if(mapper == null){
        mapper = new DozerBeanMapper();
    }

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozerMapper.map(source, destinationClass);
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

    /**
     * 基于Dozer转换分页Page对象中泛型类型.
     */
    /*public static <T> Page<T> mapPage(Page<?> sourcePage, Class<T> destinationClass) {
        if (sourcePage == null) {
            return null;
        }
        Page<T> destinationList = dozerMapper.map(sourcePage, Page.class);
        destinationList.clear(); // 清掉所有映射过来的数据
        for (Object sourceObject : sourcePage) {
            T destinationObject = dozerMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }*/

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     */
    public static void copy(Object source, Object destinationObject) {
        dozerMapper.map(source, destinationObject);
    }
}
