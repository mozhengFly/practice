package com.mozhengfly.count.demo.business.service;

import com.mozhengfly.count.demo.business.entity.J;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mozhengfly123
 * @since 2019-02-18
 */
public interface IJService extends IService<J> {
    String addCount();
}
