package com.hfjy.student.bean.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;
/**
 * <p>
 * 骇客马拉松—班级基础表
 * </p>
 *
 * @author hsx
 * @since 2019-06-11
 */
@Data
@TableName("hackathon_class")
public class ClassDO{

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 班级名
     */
    @TableField("name")
    private String name;

    /**
     * 年级
     */
    @TableField("gradeId")
    private Integer gradeId;

    /**
     * 是否删除 1：已删除； 0未删除；
     */
    @TableField("isDel")
    @TableLogic
    private Integer isDel;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private Date updateTime;

}
