package com.hfjy.api.dto;

import lombok.Data;

/**
 * 班级数据传输对象
 * @author hsx
 * create at 2019-06-11
 */
@Data
public class ClassDTO {
    /**
     * 班级id
     */
    private Integer id;

    /**
     * 班级名
     */
    private String name;

    /**
     * 年级id
     */
    //private Integer gradeId;
}
