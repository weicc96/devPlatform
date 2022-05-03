package org.dev.plantform.module.menu.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统菜单权限资源表
 * </p>
 *
 * @author weichenchen
 * @since 2022-05-03
 */
@Getter
@Setter
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "系统菜单权限资源表")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单id")
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    @ApiModelProperty("父ID")
    @TableField("pid")
    private Long pid;

    @ApiModelProperty("名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("链接")
    @TableField("href")
    private String href;

    @ApiModelProperty("菜单排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("备注信息")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("是否禁用")
    @TableField("is_disabled")
    @TableLogic
    private Boolean isDisabled;

    @ApiModelProperty("创建人")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("更新人")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;


}
