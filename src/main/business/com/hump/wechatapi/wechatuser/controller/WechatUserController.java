package com.hump.wechatapi.wechatuser.controller;

import com.hump.wechatuser.entity.TWechatFansEntity;
import org.jeecgframework.core.common.model.json.AjaxJson;
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

    @RequestMapping(value = "/insertUsers")
    @ResponseBody
    public AjaxJson insertUsers(HttpServletRequest request, HttpServletResponse response, TWechatFansEntity wechatFans){
        AjaxJson j = new AjaxJson();
        String msg = "新增微信用户成功！";
        //do something...
        j.setMsg(msg);
        return j;
    }
}
