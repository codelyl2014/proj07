package com.hfjy.api.dto;

import lombok.Data;

/**
 * @author hsx
 * create at 2019-06-11
 */
@Data
public class StudentDTO {

    /**
     * 学生id
     */
    private Integer id;

    /**
     * 学生姓名
     */
    //private String name;

    /**
     * 学生性别，1男，2女
     */
    private Integer gender;

    /**
     * 所在城市
     */
    //private String city;

    /**
     * 班级id
     */
    //private Integer classId;
}
