package org.dev.plantform.module.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author weichenchen
 * @since 2022-05-03
 */
@Getter
@Setter
@TableName("sys_log")
@ApiModel(value = "SysLog对象", description = "日志")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("ip地址")
    @TableField("ip")
    private String ip;

    @ApiModelProperty("请求城市")
    @TableField("city")
    private String city;

    @ApiModelProperty("浏览器或者app信息")
    @TableField("client")
    private String client;

    @ApiModelProperty("请求uri")
    @TableField("uri")
    private String uri;

    @ApiModelProperty("请求方法")
    @TableField("method")
    private String method;

    @ApiModelProperty("请求")
    @TableField("request")
    private String request;

    @ApiModelProperty("响应")
    @TableField("response")
    private String response;

    @ApiModelProperty("状态")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("耗时ms")
    @TableField("cost")
    private Integer cost;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;


}
