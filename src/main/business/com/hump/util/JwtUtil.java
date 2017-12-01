package com.hump.util;

import com.hump.constant.JWTConstant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;

import java.security.Key;
import java.util.Date;

/**
 * Created by Zackma on 2017/12/2.
 */
public class JwtUtil {
    private static final Key key = MacProvider.generateKey();
    private static JwtUtil instance = null;

    /**
     * 单例初始化工具类
     *
     * @return
     */
    public static JwtUtil getInstance() {
        if (instance == null) {
            instance = new JwtUtil();
        }
        return instance;
    }

    /**
     * 创建jwt
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public String createJWT(String id, String subject, long ttlMillis)
            throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now)
                .setSubject(subject).signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     *
     * @param token
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException | MalformedJwtException e) {
            e.printStackTrace();
            throw new BusinessException(JWTConstant.JWT_ERROR_ERRORKEY);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            throw new BusinessException(JWTConstant.JWT_ERROR_TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(JWTConstant.JWT_ERROR_UNERROR);
        }
        return claims;
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public AjaxJson parseToken(String token) {
        AjaxJson json = new AjaxJson();
        try {
            Claims claims = parseJWT(token);
            json.setMsg("验证通过");
            json.setObj(claims.getSubject());
        } catch (BusinessException e) {
            switch (e.getMessage()) {
                case JWTConstant.JWT_ERROR_TIMEOUT:
                    json.setMsg("token 超时");
                    json.setSuccess(false);
                    json.setObj(JWTConstant.JWT_ERROR_TIMEOUT);
                    break;
                case JWTConstant.JWT_ERROR_ERRORKEY:
                    json.setMsg("token 解析错误");
                    json.setSuccess(false);
                    json.setObj(JWTConstant.JWT_ERROR_UNERROR);
                    break;
                case JWTConstant.JWT_ERROR_UNERROR:
                    json.setMsg("token解析未知错误");
                    json.setSuccess(false);
                    json.setObj(JWTConstant.JWT_ERROR_UNERROR);
                    break;
                default:
                    json.setMsg("非法操作");
                    json.setSuccess(false);
                    break;
            }
        }
        return json;
    }
}
