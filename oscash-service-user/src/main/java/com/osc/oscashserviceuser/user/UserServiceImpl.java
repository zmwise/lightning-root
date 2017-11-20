package com.osc.oscashserviceuser.user;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.osc.oscashdao.mapper.user.UserDao;
import com.osc.oscashentity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizhiming
 * @since 2017-11-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int saveUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public List<User> getAllUser() {
        PageHelper.startPage(1, 10);
        return userDao.selectList(null);
    }
}
