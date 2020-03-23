package com.omega.platform.core.exception;

import lombok.Data;

/**
*@Description 基础业务异常类
*@Author Allen.Lv
*@Date 3/24/2020
*@Time 12:04 AM
*/
@Data
public class ServiceException extends RuntimeException {
    private String errorKey;
    private Integer code;
    private String errorMessage;

    /**
     * <p>
     * Description: 构造函数
     * </p>
     *
     * @param cause 堆栈
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(String errorKey, Integer code, String errorMessage) {
        super(errorMessage);
        this.errorKey = errorKey;
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(BaseServiceException exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

    /**
     * 支持占位符方式动态变更枚举类中对应占位符的错误提示信息
     *
     * @param exception
     * @param placeHolderArgs
     */
    public ServiceException(BaseServiceException exception, String... placeHolderArgs) {
        super(String.format(exception.getMessage(), placeHolderArgs));

        this.code = exception.getCode();
        this.errorMessage = super.getMessage();
    }

}
