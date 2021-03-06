package com.ntschy.baitong.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ModifyRoleRequest {

    private String roleId;

    private String roleName;

    private List<String> actionList;

    @NotNull(message = "操作类型不能为空")
    private Integer operateType; // 1：新增 2：修改 3：删除
}
