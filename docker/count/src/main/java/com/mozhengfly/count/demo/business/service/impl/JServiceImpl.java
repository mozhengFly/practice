package com.mozhengfly.count.demo.business.service.impl;

import com.mozhengfly.count.demo.business.entity.J;
import com.mozhengfly.count.demo.business.dao.JDao;
import com.mozhengfly.count.demo.business.service.IJService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mozhengfly123
 * @since 2019-02-18
 */
@Service
public class JServiceImpl extends ServiceImpl<JDao, J> implements IJService {

    @Override
    public String addCount() {
        J res = baseMapper.selectById(12);
        int count = res.getCs();
        res.setCs(count + 1);
        baseMapper.updateAllColumnById(res);
        return String.valueOf(count + 1);
    }
}
