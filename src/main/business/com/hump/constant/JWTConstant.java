package com.hump.constant;

/**
 * Created by Zackma on 2017/12/2.
 */
public class JWTConstant {
    public static final String JWT_ID = "jwt";
    // public static final String JWT_SECRET = "hong1mu2zhi3ruan4jian5";
    public static final long JWT_TTL = 60 * 60 * 1000; // millisecond
    public static final int JWT_REFRESH_INTERVAL = 55 * 60 * 1000; // millisecond
    public static final int JWT_REFRESH_TTL = 12 * 60 * 60 * 1000; // millisecond

    /**
     * 超时
     */
    public static final String JWT_ERROR_TIMEOUT = "T";
    /**
     * 解析异常
     */
    public static final String JWT_ERROR_ERRORKEY = "E";
    /**
     * 未知异常
     */
    public static final String JWT_ERROR_UNERROR = "W";
}
