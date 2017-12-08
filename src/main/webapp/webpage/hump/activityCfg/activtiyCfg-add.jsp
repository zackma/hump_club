<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>t_activtiy_cfg</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="activtiyCfgController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${activtiyCfgPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="actName" name="actName" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							活动类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="actType" name="actType" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动开始日期:
						</label>
					</td>
					<td class="value">
							   <input id="actStart" name="actStart" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动开始日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							活动结束日期:
						</label>
					</td>
					<td class="value">
							   <input id="actEnd" name="actEnd" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动结束日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动报名开始日期:
						</label>
					</td>
					<td class="value">
							   <input id="actEnrollstart" name="actEnrollstart" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动报名开始日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							活动报名结束日期:
						</label>
					</td>
					<td class="value">
							   <input id="actEnrollend" name="actEnrollend" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动报名结束日期</label>
						</td>
					</tr>
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							活动备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动备注</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							活动标签（预留）:
						</label>
					</td>
					<td class="value">
					     	 <input id="actTag" name="actTag" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动标签（预留）</label>
						</td>
					</tr>--%>
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							当前状态：1已发布，0未发布:
						</label>
					</td>
					<td class="value">
					     	 <input id="pubStatus" name="pubStatus" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当前状态：1已发布，0未发布</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建人id:
						</label>
					</td>
					<td class="value">
					     	 <input id="createId" name="createId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人id</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
							   <input id="createTime" name="createTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							修改人id:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateId" name="updateId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改人id</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							修改时间:
						</label>
					</td>
					<td class="value">
							   <input id="updateTime" name="updateTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							逻辑删除:
						</label>
					</td>
					<td class="value">
					     	 <input id="isDelete" name="isDelete" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">逻辑删除</label>
						</td>
					</tr>--%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							选择标签:
						</label>
					</td>
					<td class="value" nowrap>
						<input id="roleid2" name="roleid2" type="hidden" value="${id}"/>
						<input name="roleName2" id="roleName2" class="inputxt" value="${roleName }" readonly="readonly"  />
						<t:choose hiddenName="roleid2" hiddenid="id2" textname="roleName2" url="userController.do?roles" name="roleList2" icon="icon-search" title="common.role.list" isclear="true" isInit="true"></t:choose>
						<span class="Validform_checktip">标签可多选</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							选择领队:
						</label>
					</td>
					<td class="value" nowrap>
						<input id="roleid" name="roleid" type="hidden" value="${id}"/>
						<input name="roleName" id="roleName" class="inputxt" value="${roleName }" readonly="readonly"  />
						<t:choose hiddenName="roleid" hiddenid="id" textname="roleName" url="userController.do?roles" name="roleList" icon="icon-search" title="common.role.list" isclear="true" isInit="true"></t:choose>
						<span class="Validform_checktip">选择领队</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动备注:
						</label>
					</td>
					<td class="value"  colspan="3" >
						<textarea style="width:600px;" class="inputxt" rows="5" name="remark"   ignore="checked" ></textarea>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动详情:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="actDetail" name="actDetail"  datatype="*"  ignore="checked" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动详情</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/hump/activityCfg/activtiyCfg.js"></script>
 <script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
 <script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
 <script type="text/javascript">
     var editor = UE.getEditor('actDetail');
 </script>
