package com.hfjy.schooling.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 班级信息
 * @author hsx
 * create at 2019-06-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfo {
    /**
     * 班级id
     */
    private int classId;
    /**
     * 班级名称
     */
    private String className;
}
