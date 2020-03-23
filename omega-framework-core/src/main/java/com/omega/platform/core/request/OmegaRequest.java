package com.omega.platform.core.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 3/23/2020
 * @Time 7:25 PM
 */
@ApiModel
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OmegaRequest<T> implements Serializable {
    private static final long serialVersionUID = -7268040542410707954L;

    public static final int SUCCESS = 0;

    private OmegaReqHeader header;

    @Valid
    @NotNull(message = "请求参数不能为空")
    private T data;

    private Boolean mockData;
}
