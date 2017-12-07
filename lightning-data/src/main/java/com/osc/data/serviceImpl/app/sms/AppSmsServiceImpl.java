package com.osc.data.serviceImpl.app.sms;

import com.osc.data.entity.app.sms.AppSms;
import com.osc.data.dao.app.sms.AppSmsDao;
import com.osc.data.service.app.sms.IAppSmsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP短信表(抓取) 服务实现类
 * </p>
 *
 * @author lizhiming
 * @since 2017-12-05
 */
@Service
public class AppSmsServiceImpl extends ServiceImpl<AppSmsDao, AppSms> implements IAppSmsService {
	
}
