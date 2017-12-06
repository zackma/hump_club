package com.hump.activitycfg.service;
import com.hump.activitycfg.entity.ActivtiyCfgEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ActivtiyCfgServiceI extends CommonService{
	
 	public void delete(ActivtiyCfgEntity entity) throws Exception;
 	
 	public Serializable save(ActivtiyCfgEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ActivtiyCfgEntity entity) throws Exception;
 	
}
