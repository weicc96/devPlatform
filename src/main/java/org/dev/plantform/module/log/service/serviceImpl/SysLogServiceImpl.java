package org.dev.plantform.module.log.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dev.plantform.module.log.entity.SysLog;
import org.dev.plantform.module.log.mapper.SysLogMapper;
import org.dev.plantform.module.log.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author weichenchen
 * @since 2022-05-03
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
