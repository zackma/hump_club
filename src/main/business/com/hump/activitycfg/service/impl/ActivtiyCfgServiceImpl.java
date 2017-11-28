package com.hump.activitycfg.service.impl;
import com.hump.activitycfg.service.ActivtiyCfgServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.hump.activitycfg.entity.ActivtiyCfgEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("activtiyCfgService")
@Transactional
public class ActivtiyCfgServiceImpl extends CommonServiceImpl implements ActivtiyCfgServiceI {

	
 	public void delete(ActivtiyCfgEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ActivtiyCfgEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ActivtiyCfgEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ActivtiyCfgEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(ActivtiyCfgEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(ActivtiyCfgEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(ActivtiyCfgEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("act_name", t.getActName());
		map.put("act_detail", t.getActDetail());
		map.put("act_type", t.getActType());
		map.put("act_start", t.getActStart());
		map.put("act_end", t.getActEnd());
		map.put("act_enrollstart", t.getActEnrollstart());
		map.put("act_enrollend", t.getActEnrollend());
		map.put("remark", t.getRemark());
		map.put("act_tag", t.getActTag());
		map.put("pub_status", t.getPubStatus());
		map.put("create_id", t.getCreateId());
		map.put("create_time", t.getCreateTime());
		map.put("update_id", t.getUpdateId());
		map.put("update_time", t.getUpdateTime());
		map.put("is_delete", t.getIsDelete());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,ActivtiyCfgEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{act_name}",String.valueOf(t.getActName()));
 		sql  = sql.replace("#{act_detail}",String.valueOf(t.getActDetail()));
 		sql  = sql.replace("#{act_type}",String.valueOf(t.getActType()));
 		sql  = sql.replace("#{act_start}",String.valueOf(t.getActStart()));
 		sql  = sql.replace("#{act_end}",String.valueOf(t.getActEnd()));
 		sql  = sql.replace("#{act_enrollstart}",String.valueOf(t.getActEnrollstart()));
 		sql  = sql.replace("#{act_enrollend}",String.valueOf(t.getActEnrollend()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{act_tag}",String.valueOf(t.getActTag()));
 		sql  = sql.replace("#{pub_status}",String.valueOf(t.getPubStatus()));
 		sql  = sql.replace("#{create_id}",String.valueOf(t.getCreateId()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_id}",String.valueOf(t.getUpdateId()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("t_activtiy_cfg",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}