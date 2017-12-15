<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tWechatFansList" checkbox="true" pagination="true" fitColumns="true" title="t_wechat_fans" actionUrl="tWechatFansController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="openid"  field="openid" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="昵称"  field="nickname"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="头像"  field="headimgurl" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="identityNo"  field="identityNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="国家"  field="country"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="省"  field="province"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="城市"  field="city"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="密码"  field="password" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="电话号码"  field="phone"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="电子邮箱"  field="email"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="生日"  field="birthday"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职业"  field="career"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="关注时间"  field="joinTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="角色编码"  field="roleCode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动标签"  field="actTag"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="tWechatFansController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tWechatFansController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tWechatFansController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/hump/wechatuser/tWechatFansList.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tWechatFansController.do?upload', "tWechatFansList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tWechatFansController.do?exportXls","tWechatFansList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tWechatFansController.do?exportXlsByT","tWechatFansList");
}

 </script>