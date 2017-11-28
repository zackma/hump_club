<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>t_wechat_fans</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tWechatFansController.do?doUpdate" >
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								openid:
							</label>
						</td>
						<td class="value">
						     	 <input id="openid" name="openid" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tWechatFansPage.openid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">openid</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								昵称:
							</label>
						</td>
						<td class="value">
						     	 <input id="nickname" name="nickname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.nickname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">昵称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								头像:
							</label>
						</td>
						<td class="value">
						     	 <input id="headimgurl" name="headimgurl" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.headimgurl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">头像</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								identityNo:
							</label>
						</td>
						<td class="value">
						     	 <input id="identityNo" name="identityNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.identityNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">identityNo</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								国家:
							</label>
						</td>
						<td class="value">
						     	 <input id="country" name="country" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.country}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国家</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								省:
							</label>
						</td>
						<td class="value">
						     	 <input id="province" name="province" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.province}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">省</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								城市:
							</label>
						</td>
						<td class="value">
						     	 <input id="city" name="city" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.city}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">城市</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								密码:
							</label>
						</td>
						<td class="value">
						     	 <input id="password" name="password" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.password}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">密码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								电话号码:
							</label>
						</td>
						<td class="value">
						     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.phone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电话号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								电子邮箱:
							</label>
						</td>
						<td class="value">
						     	 <input id="email" name="email" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.email}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电子邮箱</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								生日:
							</label>
						</td>
						<td class="value">
						     	 <input id="birthday" name="birthday" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.birthday}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生日</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.sex}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								职业:
							</label>
						</td>
						<td class="value">
						     	 <input id="career" name="career" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.career}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职业</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								关注时间:
							</label>
						</td>
						<td class="value">
									  <input id="joinTime" name="joinTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" value='<fmt:formatDate value='${tWechatFansPage.joinTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">关注时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								角色编码:
							</label>
						</td>
						<td class="value">
						     	 <input id="roleCode" name="roleCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.roleCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">角色编码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								活动标签（预留）:
							</label>
						</td>
						<td class="value">
						     	 <input id="actTag" name="actTag" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tWechatFansPage.actTag}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动标签（预留）</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/com.hump.wechatuser/tWechatFans.js"></script>		
