package com.omega.platform.core.request;

import com.omega.platform.common.usualenum.LanguageEnum;
import com.omega.platform.common.usualenum.ReqSourceEnum;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.omega.platform.common.usualenum.LanguageEnum.CN;


/**
 * 基础请求头
 *
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 3/23/2020
 * @Time 8:38 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OmegaReqHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 客户端id
     */
    private String cid;
    /**
     * 系统版本
     */
    private String version;
    /**
     * Token类型(1-前端,2-管理后台)
     */
    private Integer tokenType;
    /**
     * token
     */
    private String token;
    /**
     * 语言(CN-中文,EN-英文)
     */
    @ApiParam(defaultValue = "CN")
    private LanguageEnum lang = CN;
    /**
     * 时间戳（毫秒）
     */
    private long currentTime;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 请求来源
     */
    private ReqSourceEnum reqSource;
}
