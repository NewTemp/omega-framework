package com.omega.platform.common.usualenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
*@Description 时间格式枚举类
*@Author Allen.Lv
*@Date 3/25/2020
*@Time 3:05 PM
*/
@Getter
@AllArgsConstructor
public enum DateFormatEnum {
    YEAR("yyyy", "年份"),
    YMD("yyyy-MM-dd", "年月日"),
    YMD_NUM("yyyyMMdd", "数字类型的年月日，即不包含分隔符-"),
    YMDHMS("yyyy-MM-dd HH:mm:ss", "年月日时分秒"),
    YMDHMS_NUM("yyyyMMddHHmmss", "数字类型的年月日时分秒，即不包含分隔符-"),
    YMDHMS_SSS_NUM("yyyyMMddHHmmssSSS", "数字类型的年月日时分秒毫秒，即不包含分隔符-"),

    ;

    private final String value;
    private final String remark;

}
