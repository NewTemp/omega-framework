package com.omega.platform.core.response;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 3/23/2020
 * @Time 11:40 PM
 */
public class OmegaResponseBuilder {
    private OmegaResponse omegaResponse;

    public OmegaResponseBuilder(OmegaResponse omegaResponse) {
        this.omegaResponse = omegaResponse;
    }

    public OmegaResponseBuilder withCode(String code) {
        if (this.omegaResponse.getHeader() == null) {
            this.omegaResponse.setHeader(new OmegaResponseHeader("", ""));
        }

        this.omegaResponse.getHeader().setCode(code);
        return this;
    }

    public OmegaResponseBuilder withMessage(String message) {
        if (this.omegaResponse.getHeader() == null) {
            this.omegaResponse.setHeader(new OmegaResponseHeader("", ""));
        }

        this.omegaResponse.getHeader().setMessage(message);
        return this;
    }

    public OmegaResponseBuilder withData(Object data) {
        this.omegaResponse.setData(data);
        return this;
    }

    public OmegaResponse build() {
        return this.omegaResponse;
    }
}
