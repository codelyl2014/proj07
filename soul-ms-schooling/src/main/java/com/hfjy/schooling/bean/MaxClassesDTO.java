package com.hfjy.schooling.bean;

import lombok.Data;

import java.util.List;

/**
 * 男生最多和女生最多的班级信息
 * @author hsx
 * create at 2019-06-11
 */
@Data
public class MaxClassesDTO {
    /**
     * 年级名次
     */
    private String gradeName;
    /**
     * 男生人数
     */
    private int male;
    /**
     * 男生最多的班级信息列表
     */
    private List<ClassInfo> maleClasses;
    /**
     * 女生人数
     */
    private int female;
    /**
     * 女生最多的班级信息列表
     */
    private List<ClassInfo> femaleClasses;
}
