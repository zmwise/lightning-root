package com.osc.serviceuser.user;

import com.baomidou.mybatisplus.service.IService;
import com.osc.data.entity.user.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizhiming
 * @since 2017-11-17
 */
public interface IUserService extends IService<User> {
    /**
     * 保存用户
     * @return
     */
    int saveUser(User user);
    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();
}
