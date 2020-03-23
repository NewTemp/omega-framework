package com.omega.platform.common.usualenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 3/23/2020
 * @Time 11:22 PM
 */
@Getter
@AllArgsConstructor
public enum ReqSourceEnum {

    H5(1, "h5", "h5"),
    APP(2, "app", "app"),
    WEB(3, "web", "web服务");


    /**
     * 系统内使用代码
     */
    private final int code;
    /**
     * name
     */
    private final String name;
    /**
     * 备注
     */
    private final String remark;

}
