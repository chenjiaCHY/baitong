package com.ntschy.baitong.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RadarRequest {

    @NotNull(message = "x坐标不能为空")
    private Double x;

    @NotNull(message = "y坐标不能为空")
    private Double y;

    @NotNull(message = "距离不能为空")
    private Double distance;
}
