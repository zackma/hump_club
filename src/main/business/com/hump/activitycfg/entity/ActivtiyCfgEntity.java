package com.hump.activitycfg.entity;

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
 * @Description: t_activtiy_cfg
 * @author onlineGenerator
 * @date 2017-11-28 11:42:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_activtiy_cfg", schema = "")
@SuppressWarnings("serial")
public class ActivtiyCfgEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**活动名称*/
	@Excel(name="活动名称",width=15)
	private String actName;
	/**活动详情*/
	@Excel(name="活动详情",width=15)
	private String actDetail;
	/**活动类型*/
	@Excel(name="活动类型",width=15)
	private String actType;
	/**活动开始日期*/
	@Excel(name="活动开始日期",width=15,format = "yyyy-MM-dd")
	private Date actStart;
	/**活动结束日期*/
	@Excel(name="活动结束日期",width=15,format = "yyyy-MM-dd")
	private Date actEnd;
	/**活动报名开始日期*/
	@Excel(name="活动报名开始日期",width=15,format = "yyyy-MM-dd")
	private Date actEnrollstart;
	/**活动报名结束日期*/
	@Excel(name="活动报名结束日期",width=15,format = "yyyy-MM-dd")
	private Date actEnrollend;
	/**活动备注*/
	@Excel(name="活动备注",width=15)
	private String remark;
	/**活动标签（预留）*/
	@Excel(name="活动标签（预留）",width=15)
	private String actTag;
	/**当前状态：1已发布，0未发布*/
	@Excel(name="当前状态：1已发布，0未发布",width=15)
	private Integer pubStatus;
	/**创建人id*/
	@Excel(name="创建人id",width=15)
	private String createId;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd")
	private Date createTime;
	/**修改人id*/
	@Excel(name="修改人id",width=15)
	private String updateId;
	/**修改时间*/
	@Excel(name="修改时间",width=15,format = "yyyy-MM-dd")
	private Date updateTime;
	/**逻辑删除*/
	@Excel(name="逻辑删除",width=15)
	private String isDelete;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=32)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动名称
	 */

	@Column(name ="ACT_NAME",nullable=false,length=64)
	public String getActName(){
		return this.actName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动名称
	 */
	public void setActName(String actName){
		this.actName = actName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动详情
	 */

	@Column(name ="ACT_DETAIL",nullable=false,length=65535)
	public String getActDetail(){
		return this.actDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动详情
	 */
	public void setActDetail(String actDetail){
		this.actDetail = actDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动类型
	 */

	@Column(name ="ACT_TYPE",nullable=false,length=64)
	public String getActType(){
		return this.actType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动类型
	 */
	public void setActType(String actType){
		this.actType = actType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动开始日期
	 */

	@Column(name ="ACT_START",nullable=false)
	public Date getActStart(){
		return this.actStart;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动开始日期
	 */
	public void setActStart(Date actStart){
		this.actStart = actStart;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动结束日期
	 */

	@Column(name ="ACT_END",nullable=false)
	public Date getActEnd(){
		return this.actEnd;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动结束日期
	 */
	public void setActEnd(Date actEnd){
		this.actEnd = actEnd;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动报名开始日期
	 */

	@Column(name ="ACT_ENROLLSTART",nullable=false)
	public Date getActEnrollstart(){
		return this.actEnrollstart;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动报名开始日期
	 */
	public void setActEnrollstart(Date actEnrollstart){
		this.actEnrollstart = actEnrollstart;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动报名结束日期
	 */

	@Column(name ="ACT_ENROLLEND",nullable=false)
	public Date getActEnrollend(){
		return this.actEnrollend;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动报名结束日期
	 */
	public void setActEnrollend(Date actEnrollend){
		this.actEnrollend = actEnrollend;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动备注
	 */

	@Column(name ="REMARK",nullable=true,length=2000)
	public String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动备注
	 */
	public void setRemark(String remark){
		this.remark = remark;
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  当前状态：1已发布，0未发布
	 */

	@Column(name ="PUB_STATUS",nullable=true,length=10)
	public Integer getPubStatus(){
		return this.pubStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  当前状态：1已发布，0未发布
	 */
	public void setPubStatus(Integer pubStatus){
		this.pubStatus = pubStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人id
	 */

	@Column(name ="CREATE_ID",nullable=true,length=32)
	public String getCreateId(){
		return this.createId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人id
	 */
	public void setCreateId(String createId){
		this.createId = createId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CREATE_TIME",nullable=false)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人id
	 */

	@Column(name ="UPDATE_ID",nullable=true,length=32)
	public String getUpdateId(){
		return this.updateId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人id
	 */
	public void setUpdateId(String updateId){
		this.updateId = updateId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */

	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  逻辑删除
	 */

	@Column(name ="IS_DELETE",nullable=true,length=1)
	public String getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  逻辑删除
	 */
	public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
}
