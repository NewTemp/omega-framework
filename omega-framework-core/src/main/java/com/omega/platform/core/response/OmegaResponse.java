package com.omega.platform.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 3/23/2020
 * @Time 11:35 PM
 */
@ApiModel
@Accessors(chain = true)
@Data
public class OmegaResponse<T> {

    private OmegaResponseHeader header;

    private T data;

    /**
     * 操作时间
     */
    private Long currentTime;

    public OmegaResponse(T data) {
        this.data = data;
    }

    public static <T> OmegaResponse<T> ok(T data) {
        return new OmegaResponse(new OmegaResponseHeader(), data);
    }

    public static <T> OmegaResponse<T> create(String code, String message) {
        return (OmegaResponse<T>) create(code, message, (Object) null);
    }

    public static <T> OmegaResponse<T> create(String code, String message, T data) {
        OmegaResponse<T> response = new OmegaResponse();
        response.setHeader(new OmegaResponseHeader(code, message));
        response.setData(data);
        return response;
    }

    public static OmegaResponseBuilder builder() {
        OmegaResponseBuilder omegaResponseBuilder = new OmegaResponseBuilder(new OmegaResponse());
        return omegaResponseBuilder;
    }

    public OmegaResponseHeader getHeader() {
        return this.header;
    }

    public T getData() {
        return this.data;
    }

    public void setHeader(final OmegaResponseHeader header) {
        this.header = header;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public OmegaResponse() {
    }

    public OmegaResponse(final OmegaResponseHeader header, final T data) {
        this.header = header;
        this.data = data;
    }

    public OmegaResponse(final OmegaResponseHeader header, final Long currentTime) {
        this.header = header;
        this.currentTime = currentTime;
    }

    public OmegaResponse(final OmegaResponseHeader header, final T data, final Long currentTime) {
        this.header = header;
        this.data = data;
        this.currentTime = currentTime;
    }

    public String toString() {
        return "OmegaResponse(header=" + this.getHeader() + ", data=" + this.getData() + ")";
    }
}
