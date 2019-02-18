package com.mozhengfly.count.demo.business.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mozhengfly123
 * @since 2019-02-18
 */
@TableName("tj")
public class J extends Model<J> {

    private static final long serialVersionUID = 1L;

    private String id;
    private Integer cs;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "J{" +
        ", id=" + id +
        ", cs=" + cs +
        "}";
    }
}
