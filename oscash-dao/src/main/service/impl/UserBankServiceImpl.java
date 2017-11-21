package src.main.service.impl;

import src.main.java.com.osc.oscashdao.entity.user.bank.UserBank;
import src.main.java.com.osc.oscashdao.dao.user.bank.UserBankDao;
import src.main.service.IUserBankService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizhiming
 * @since 2017-11-21
 */
@Service
public class UserBankServiceImpl extends ServiceImpl<UserBankDao, UserBank> implements IUserBankService {
	
}
