package com.hump.wechatuser.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hump.wechatuser.entity.TWechatFansEntity;
import com.hump.wechatuser.service.TWechatFansServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller  
 * @Description: t_wechat_fans
 * @author onlineGenerator
 * @date 2017-11-28 10:59:05
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tWechatFansController")
public class TWechatFansController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TWechatFansController.class);

	@Autowired
	private TWechatFansServiceI tWechatFansService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * t_wechat_fans列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("hump/wechatuser/tWechatFansList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param tWechatFans
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TWechatFansEntity tWechatFans, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TWechatFansEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tWechatFans, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tWechatFansService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除t_wechat_fans
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TWechatFansEntity tWechatFans, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tWechatFans = systemService.getEntity(TWechatFansEntity.class, tWechatFans.getOpenid());
		message = "t_wechat_fans删除成功";
		try{
			tWechatFansService.delete(tWechatFans);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "t_wechat_fans删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除t_wechat_fans
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "t_wechat_fans删除成功";
		try{
			for(String id:ids.split(",")){
				TWechatFansEntity tWechatFans = systemService.getEntity(TWechatFansEntity.class, 
				id
				);
				tWechatFansService.delete(tWechatFans);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "t_wechat_fans删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加t_wechat_fans
	 * 
	 * @param tWechatFans
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TWechatFansEntity tWechatFans, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "t_wechat_fans添加成功";
		try{
			tWechatFansService.save(tWechatFans);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "t_wechat_fans添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新t_wechat_fans
	 * 
	 * @param tWechatFans
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TWechatFansEntity tWechatFans, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "t_wechat_fans更新成功";
		TWechatFansEntity t = tWechatFansService.get(TWechatFansEntity.class, tWechatFans.getOpenid());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tWechatFans, t);
			tWechatFansService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "t_wechat_fans更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * t_wechat_fans新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TWechatFansEntity tWechatFans, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tWechatFans.getOpenid())) {
			tWechatFans = tWechatFansService.getEntity(TWechatFansEntity.class, tWechatFans.getOpenid());
			req.setAttribute("tWechatFansPage", tWechatFans);
		}
		return new ModelAndView("hump/wechatuser/tWechatFans-add");
	}
	/**
	 * t_wechat_fans编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TWechatFansEntity tWechatFans, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tWechatFans.getOpenid())) {
			tWechatFans = tWechatFansService.getEntity(TWechatFansEntity.class, tWechatFans.getOpenid());
			req.setAttribute("tWechatFansPage", tWechatFans);
		}
		return new ModelAndView("hump/wechatuser/tWechatFans-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tWechatFansController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TWechatFansEntity tWechatFans,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TWechatFansEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tWechatFans, request.getParameterMap());
		List<TWechatFansEntity> tWechatFanss = this.tWechatFansService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"t_wechat_fans");
		modelMap.put(NormalExcelConstants.CLASS,TWechatFansEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("t_wechat_fans列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tWechatFanss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TWechatFansEntity tWechatFans,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"t_wechat_fans");
    	modelMap.put(NormalExcelConstants.CLASS,TWechatFansEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("t_wechat_fans列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<TWechatFansEntity> listTWechatFansEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TWechatFansEntity.class,params);
				for (TWechatFansEntity tWechatFans : listTWechatFansEntitys) {
					tWechatFansService.save(tWechatFans);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TWechatFansEntity> list() {
		List<TWechatFansEntity> listTWechatFanss=tWechatFansService.getList(TWechatFansEntity.class);
		return listTWechatFanss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TWechatFansEntity task = tWechatFansService.get(TWechatFansEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TWechatFansEntity tWechatFans, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TWechatFansEntity>> failures = validator.validate(tWechatFans);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tWechatFansService.save(tWechatFans);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String openid = tWechatFans.getOpenid();
		URI uri = uriBuilder.path("/rest/tWechatFansController/" + openid).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TWechatFansEntity tWechatFans) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TWechatFansEntity>> failures = validator.validate(tWechatFans);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tWechatFansService.saveOrUpdate(tWechatFans);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		tWechatFansService.deleteEntityById(TWechatFansEntity.class, id);
	}
}
