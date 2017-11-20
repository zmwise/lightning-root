package com.osc.oscashdao.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.osc.oscashentity.user.User;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lizhiming
 * @since 2017-11-17
 */
public interface UserDao extends BaseMapper<User> {
    /**
     * 保存用户
     * @return
     */
    int saveUser(User user);
}