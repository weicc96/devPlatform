package org.dev.plantform.module.user.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.ApiOperation;
import org.dev.plantform.module.user.entity.SysUser;
import org.dev.plantform.module.user.entity.SysUserRole;
import org.dev.plantform.module.user.service.SysUserRoleService;
import org.dev.plantform.module.user.service.SysUserService;
import org.dev.plantform.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weichenchen
 * @since 2022-05-03
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "新增或者更新")
    @Transactional
//    @SaCheckPermission("user.update")
    public Response saveOrUpdate(@RequestBody SysUser param) {

        if (param.getDeptId() == null) {
            return Response.error("500", "请选择部门");
        }

        if (param.getUserId() == null) {
            // 只有超级管理员才能创建用户
//            if (StpUtil.getLoginIdAsLong() != 1L) {
//                return Response.error("403", "只有超级管理员才能创建用户!");
//            }
            String password = param.getPassword();
            param.setPassword(SecureUtil.sha256(password));
            param.setCreateTime(new Date());
            sysUserService.save(param);
            if (StrUtil.isNotBlank(param.getRoleIds().toString())) {
                this.saveUserRole(param.getUserId(), Arrays.asList(param.getRoleIds().toString().split(",")));
            }
        } else {
            sysUserService.saveOrUpdate(param);
            if (StrUtil.isNotBlank(param.getRoleIds().toString())) {
                this.saveUserRole(param.getUserId(), Arrays.asList(param.getRoleIds().toString().split(",")));
            }
        }
        return Response.ok(sysUserService.saveOrUpdate(param));
    }

    /**
     * 赋予用户角色
     * @param userId
     * @param roleIds
     * @return
     */
    public boolean saveUserRole(Long userId, List<String> roleIds) {
        sysUserRoleService.remove(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, userId));
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        roleIds.forEach(roleId -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(Long.valueOf(roleId));
            sysUserRole.setUserId(userId);
            sysUserRoles.add(sysUserRole);
        });
        return sysUserRoleService.saveBatch(sysUserRoles);
    }
}
