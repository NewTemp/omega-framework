package com.omega.platform.core.exception.enums;

import com.omega.platform.core.exception.BaseServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description Api状态码枚举类
 * @Author Allen.Lv
 * @Date 3/24/2020
 * @Time 12:07 AM
 */
@Getter
@AllArgsConstructor
public enum ApiErrorCodeEnum implements BaseServiceException {
    /**
     * 成功-0，失败-1
     */
    SYS_SUCCESS("0", "成功", "执行成功"),
    SYS_FAILED("1", "执行失败", "执行失败"),
    SYS_NO_LOGIN("900100101", "没有登录", "没有登录"),
    SYS_NO_PERMISSION("900100102", "没有权限", "没有权限"),

    ;

    private final String code;
    private final String message;
    private final String remark;

    public static ApiErrorCodeEnum getEnum(Integer code) {
        if (null == code) {
            return null;
        }

        ApiErrorCodeEnum[] ecs = ApiErrorCodeEnum.values();
        for (ApiErrorCodeEnum ec : ecs) {
            if (ec.getCode().equals(code)) {
                return ec;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return String.format("ErrorCode:{code=%s, msg=%s} ", code, message);
    }

}
