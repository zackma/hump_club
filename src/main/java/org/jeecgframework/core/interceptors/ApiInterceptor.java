package org.jeecgframework.core.interceptors;

import com.hump.constant.JWTConstant;
import com.hump.util.JwtUtil;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Zackma on 2017/12/2.
 */
public class ApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String requestPath = ResourceUtil.getRequestPath(request);
        if (requestPath.length()>3&& requestPath.startsWith("rest/")&&!requestPath.contains("wxFans")) {
            String token = request.getHeader("token");
            String openid = request.getParameter("openid");
            // token is not needed when debug
            // if(token == null) return true;  // 测试不带token时打开注释
            //校验token
            AjaxJson j = JwtUtil.getInstance().parseToken(token);
            //解析通过
            if(j.isSuccess()){
                return j.isSuccess();
            }else{
            //解析不通过
                //如果老token超时，则用userid和当前时间戳重新生成新token
                if(j.getObj()== JWTConstant.JWT_ERROR_TIMEOUT){
                    String dt = String.valueOf(new Date().getTime());
                    String subject = openid +"."+ dt;
                    token = JwtUtil.getInstance().createJWT(JWTConstant.JWT_ID,subject,JWTConstant.JWT_TTL);
                    response.addHeader("token",token);
                    return true;
                }else{
                //其它token解析报错一并不允许通过
                    request.setAttribute("tokenValidRst",j);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
