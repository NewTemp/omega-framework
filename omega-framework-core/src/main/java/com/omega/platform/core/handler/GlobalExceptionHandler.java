package com.omega.platform.core.handler;

import com.omega.platform.core.exception.ServiceException;
import com.omega.platform.core.exception.enums.ApiErrorCodeEnum;
import com.omega.platform.core.response.OmegaResponse;
import com.omega.platform.core.response.OmegaResponseHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @Description 全局异常拦截
 * @Author Allen.Lv
 * @Date 3/24/2020
 * @Time 12:16 AM
 */
@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 处理所有不可知的异常
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public OmegaResponse exception(Exception e) {
        log.error("系统异常信息 ex={}", e.getMessage(), e);
        return new OmegaResponse<>(e);
    }

    /**
     * 运行时异常
     *
     * @param runtimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public OmegaResponse runtimeExceptionHandler(RuntimeException runtimeException) {
        log.error("系统异常信息 ex={}", runtimeException.getLocalizedMessage(), runtimeException);
        return new OmegaResponse<>(runtimeException);
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public OmegaResponse handleServiceException(ServiceException e) {
        //业务异常记录为info级别，不记录为error级别
        log.info("业务异常信息 ex={}", e.getMessage(), e);
        return new OmegaResponse(new OmegaResponseHeader(ApiErrorCodeEnum.SYS_FAILED.getCode(), ApiErrorCodeEnum.SYS_FAILED.getMessage()), System.currentTimeMillis());
    }

}
