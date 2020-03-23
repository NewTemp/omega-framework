package com.omega.platform.core.exception;

/**
*@Description Happy!
*@Author Allen.Lv
*@Date 3/23/2020
*@Time 7:29 PM
*/
public interface BaseServiceException {
    /**
     * 获取异常状态码
     */
    Integer getCode();

    /**
     * 获取异常提示信息
     */
    String getMessage();
}
