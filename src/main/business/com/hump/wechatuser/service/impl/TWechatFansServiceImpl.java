package com.hump.wechatuser.service.impl;
import com.hump.wechatuser.entity.TWechatFansEntity;
import com.hump.wechatuser.service.TWechatFansServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
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

@Service("tWechatFansService")
@Transactional
public class TWechatFansServiceImpl extends CommonServiceImpl implements TWechatFansServiceI {

	
 	public void delete(TWechatFansEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TWechatFansEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TWechatFansEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TWechatFansEntity t) throws Exception{
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
	private void doUpdateBus(TWechatFansEntity t) throws Exception{
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
	private void doDelBus(TWechatFansEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TWechatFansEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("openid", t.getOpenid());
		map.put("nickname", t.getNickname());
		map.put("headimgurl", t.getHeadimgurl());
		map.put("identity_no", t.getIdentityNo());
		map.put("name", t.getName());
		map.put("country", t.getCountry());
		map.put("province", t.getProvince());
		map.put("city", t.getCity());
		map.put("password", t.getPassword());
		map.put("phone", t.getPhone());
		map.put("email", t.getEmail());
		map.put("birthday", t.getBirthday());
		map.put("sex", t.getSex());
		map.put("career", t.getCareer());
		map.put("join_time", t.getJoinTime());
		map.put("role_code", t.getRoleCode());
		map.put("act_tag", t.getActTag());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TWechatFansEntity t){
 		sql  = sql.replace("#{openid}",String.valueOf(t.getOpenid()));
 		sql  = sql.replace("#{nickname}",String.valueOf(t.getNickname()));
 		sql  = sql.replace("#{headimgurl}",String.valueOf(t.getHeadimgurl()));
 		sql  = sql.replace("#{identity_no}",String.valueOf(t.getIdentityNo()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{country}",String.valueOf(t.getCountry()));
 		sql  = sql.replace("#{province}",String.valueOf(t.getProvince()));
 		sql  = sql.replace("#{city}",String.valueOf(t.getCity()));
 		sql  = sql.replace("#{password}",String.valueOf(t.getPassword()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{birthday}",String.valueOf(t.getBirthday()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{career}",String.valueOf(t.getCareer()));
 		sql  = sql.replace("#{join_time}",String.valueOf(t.getJoinTime()));
 		sql  = sql.replace("#{role_code}",String.valueOf(t.getRoleCode()));
 		sql  = sql.replace("#{act_tag}",String.valueOf(t.getActTag()));
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
					javaInter.execute("t_wechat_fans",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}