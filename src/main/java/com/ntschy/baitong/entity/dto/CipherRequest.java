package com.ntschy.baitong.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CipherRequest {

    @NotBlank(message = "appId不能为空")
    private String appId;

    @NotBlank(message = "appKey不能为空")
    private String appKey;

    @NotBlank(message = "randomSeries不能为空")
    private String randomSeries;

    @NotBlank(message = "timestamp不能为空")
    private String timestamp;
}
