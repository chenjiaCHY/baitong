package com.ntschy.baitong.entity.vo;

import com.ntschy.baitong.entity.Action;
import lombok.Data;

import java.util.List;

@Data
public class RoleInfoVO {

    private Integer rowNumber;

    private String roleId;

    private String roleName;

    private String createTime;

    private Integer inUseCount;

    private List<Action> actionList;
}
