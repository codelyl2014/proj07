package com.hfjy.student.bean.domain;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
/**
 * <p>
 * 骇客马拉松—年级基础表
 * </p>
 *
 * @author hsx
 * @since 2019-06-11
 */
@Data
@TableName("hackathon_grade")
public class GradeDO{

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 年级名称，一年级、二年级、三年级...
     */
    @TableField("name")
    private String name;

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
