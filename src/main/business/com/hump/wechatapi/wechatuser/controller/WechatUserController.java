package com.hump.wechatapi.wechatuser.controller;

import com.hump.wechatuser.entity.TWechatFansEntity;
import com.hump.wechatuser.service.TWechatFansServiceI;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zackma on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/wxFans")
public class WechatUserController {

    @Autowired
    private SystemService systemService;
    @Autowired
    private TWechatFansServiceI wechatFansService;

    /**
     * 关注公众号后新增微信用户信息
     * @param wechatFans
     * @return
     */
    @RequestMapping(value = "/insertFans",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson insertFans(@RequestBody TWechatFansEntity wechatFans){
        AjaxJson j = new AjaxJson();
        String msg = "新增微信用户成功！";
        String openid = wechatFans.getOpenid()==null?"":wechatFans.getOpenid();
        if(!"".equals(openid)){
            try {
                wechatFansService.save(wechatFans);
            }catch (Exception e){
                msg = "新增业务执行失败！";
                e.printStackTrace();
            }
        }else{
            msg = "openid为空，新增微信用户失败！";
            j.setSuccess(false);
        }
        j.setMsg(msg);
        return j;
    }

    /**
     * 取消关注公众号后移除微信用户信息
     * @param openid
     * @return
     */
    @RequestMapping(value = "/removeFans",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson removeFans(@RequestParam String openid){
        AjaxJson j = new AjaxJson();
        String msg = "取关用户已经移除！";
        if(StringUtil.isNotEmpty(openid)){
            try{
                TWechatFansEntity wechatFans = systemService.findUniqueByProperty(TWechatFansEntity.class,"openid",openid);
                wechatFansService.delete(wechatFans);
            }catch (Exception e){
                msg = "取关业务失败！";
                j.setSuccess(false);
            }
        }
        j.setMsg(msg);
        return j;
    }
}
