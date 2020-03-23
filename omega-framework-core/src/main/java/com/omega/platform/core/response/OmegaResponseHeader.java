package com.omega.platform.core.response;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 3/23/2020
 * @Time 11:37 PM
 */

public class OmegaResponseHeader {

    private String code = "0";
    private String message;


    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public OmegaResponseHeader() {
    }

    public OmegaResponseHeader(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String toString() {
        return "OmegaResponseHeader(code=" + this.getCode() + ", message=" + this.getMessage() + ")";
    }
}
