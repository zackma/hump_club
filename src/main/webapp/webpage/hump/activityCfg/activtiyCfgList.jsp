<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="activtiyCfgList" checkbox="true" pagination="true" fitColumns="true" title="t_activtiy_cfg" actionUrl="activtiyCfgController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动名称"  field="actName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动详情"  field="actDetail"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动类型"  field="actType"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动开始日期"  field="actStart"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动结束日期"  field="actEnd"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动报名开始日期"  field="actEnrollstart"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动报名结束日期"  field="actEnrollend"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动标签（预留）"  field="actTag"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="当前状态：1已发布，0未发布"  field="pubStatus"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人id"  field="createId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改人id"  field="updateId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="updateTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="逻辑删除"  field="isDelete"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="activtiyCfgController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="activtiyCfgController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="activtiyCfgController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="activtiyCfgController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="activtiyCfgController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/hump/activityCfg/activtiyCfgList.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'activtiyCfgController.do?upload', "activtiyCfgList");
}

//导出
function ExportXls() {
	JeecgExcelExport("activtiyCfgController.do?exportXls","activtiyCfgList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("activtiyCfgController.do?exportXlsByT","activtiyCfgList");
}

 </script>