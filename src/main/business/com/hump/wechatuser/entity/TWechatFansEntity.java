package com.hump.wechatuser.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: t_wechat_fans
 * @author onlineGenerator
 * @date 2017-11-28 10:59:05
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_wechat_fans", schema = "")
@SuppressWarnings("serial")
public class TWechatFansEntity implements java.io.Serializable {
	/**openid*/
	@Excel(name="openid",width=15)
	private String openid;
	/**昵称*/
	@Excel(name="昵称",width=15)
	private String nickname;
	/**头像*/
	@Excel(name="头像",width=15)
	private String headimgurl;
	/**identityNo*/
	@Excel(name="identityNo",width=15)
	private String identityNo;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private String name;
	/**国家*/
	@Excel(name="国家",width=15)
	private String country;
	/**省*/
	@Excel(name="省",width=15)
	private String province;
	/**城市*/
	@Excel(name="城市",width=15)
	private String city;
	/**密码*/
	@Excel(name="密码",width=15)
	private String password;
	/**电话号码*/
	@Excel(name="电话号码",width=15)
	private String phone;
	/**电子邮箱*/
	@Excel(name="电子邮箱",width=15)
	private String email;
	/**生日*/
	@Excel(name="生日",width=15)
	private String birthday;
	/**性别*/
	@Excel(name="性别",width=15)
	private String sex;
	/**职业*/
	@Excel(name="职业",width=15)
	private String career;
	/**关注时间*/
	@Excel(name="关注时间",width=15,format = "yyyy-MM-dd")
	private Date joinTime;
	/**角色编码*/
	@Excel(name="角色编码",width=15)
	private String roleCode;
	/**活动标签（预留）*/
	@Excel(name="活动标签（预留）",width=15)
	private String actTag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  openid
	 */

	@Id
//	@GeneratedValue(generator = "paymentableGenerator")
//	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="OPENID",nullable=false,length=64)
	public String getOpenid(){
		return this.openid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  openid
	 */
	public void setOpenid(String openid){
		this.openid = openid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  昵称
	 */

	@Column(name ="NICKNAME",nullable=true,length=64)
	public String getNickname(){
		return this.nickname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  昵称
	 */
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */

	@Column(name ="HEADIMGURL",nullable=true,length=64)
	public String getHeadimgurl(){
		return this.headimgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setHeadimgurl(String headimgurl){
		this.headimgurl = headimgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  identityNo
	 */

	@Column(name ="IDENTITY_NO",nullable=true,length=100)
	public String getIdentityNo(){
		return this.identityNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  identityNo
	 */
	public void setIdentityNo(String identityNo){
		this.identityNo = identityNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="NAME",nullable=true,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国家
	 */

	@Column(name ="COUNTRY",nullable=true,length=50)
	public String getCountry(){
		return this.country;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家
	 */
	public void setCountry(String country){
		this.country = country;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省
	 */

	@Column(name ="PROVINCE",nullable=true,length=100)
	public String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省
	 */
	public void setProvince(String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城市
	 */

	@Column(name ="CITY",nullable=true,length=50)
	public String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城市
	 */
	public void setCity(String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  密码
	 */

	@Column(name ="PASSWORD",nullable=true,length=64)
	public String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话号码
	 */

	@Column(name ="PHONE",nullable=true,length=11)
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话号码
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子邮箱
	 */

	@Column(name ="EMAIL",nullable=true,length=64)
	public String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子邮箱
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生日
	 */

	@Column(name ="BIRTHDAY",nullable=true,length=32)
	public String getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生日
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=1)
	public String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职业
	 */

	@Column(name ="CAREER",nullable=true,length=64)
	public String getCareer(){
		return this.career;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职业
	 */
	public void setCareer(String career){
		this.career = career;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  关注时间
	 */

	@Column(name ="JOIN_TIME",nullable=false)
	public Date getJoinTime(){
		return this.joinTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  关注时间
	 */
	public void setJoinTime(Date joinTime){
		this.joinTime = joinTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  角色编码
	 */

	@Column(name ="ROLE_CODE",nullable=true,length=64)
	public String getRoleCode(){
		return this.roleCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  角色编码
	 */
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动标签（预留）
	 */

	@Column(name ="ACT_TAG",nullable=true,length=255)
	public String getActTag(){
		return this.actTag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动标签（预留）
	 */
	public void setActTag(String actTag){
		this.actTag = actTag;
	}
}
