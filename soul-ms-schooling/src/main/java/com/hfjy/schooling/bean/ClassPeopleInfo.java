package com.hfjy.schooling.bean;

import com.hfjy.api.dto.ClassDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 班级人数信息
 * @author hsx
 * create at 2019-06-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassPeopleInfo {
    /**
     * 班级信息
     */
    private ClassDTO classInfo;
    /**
     * 男生人数
     */
    private Integer maleNum;
    /**
     * 女生人数
     */
    private Integer femaleNum;
}
