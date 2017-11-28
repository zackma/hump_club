package com.hump.wechatapi.wechatuser.controller;

import com.hump.wechatuser.entity.TWechatFansEntity;
import com.hump.wechatuser.service.TWechatFansServiceI;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Zackma on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/wechatUserApi")
public class WechatUserController {

    @Autowired
    private TWechatFansServiceI wechatFansService;

    @RequestMapping(value = "/insertUsers")
    @ResponseBody
    public AjaxJson insertUsers(HttpServletRequest request, HttpServletResponse response, TWechatFansEntity wechatFans){
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
            j.setObj(false);
        }
        j.setMsg(msg);
        return j;
    }
}
