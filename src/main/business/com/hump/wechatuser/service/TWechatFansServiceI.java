package com.hump.wechatuser.service;
import com.hump.wechatuser.entity.TWechatFansEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TWechatFansServiceI extends CommonService{
	
 	public void delete(TWechatFansEntity entity) throws Exception;
 	
 	public Serializable save(TWechatFansEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TWechatFansEntity entity) throws Exception;
 	
}
