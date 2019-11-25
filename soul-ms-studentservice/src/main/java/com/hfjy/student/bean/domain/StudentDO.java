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
 * 骇客马拉松—学生基础表
 * </p>
 *
 * @author hsx
 * @since 2019-06-11
 */
@Data
@TableName("hackathon_student")
public class StudentDO{

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 性别，1男，2女
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 班级id
     */
    @TableField("classId")
    private Integer classId;

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
