package com.mozhengfly.count.demo.business.dao;

import com.mozhengfly.count.demo.business.entity.J;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mozhengfly123
 * @since 2019-02-18
 */
@Mapper
public interface JDao extends BaseMapper<J> {

}
