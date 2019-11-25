package com.hfjy.student.service;

import com.hfjy.api.dto.ClassDTO;
import com.hfjy.api.dto.GradeDTO;
import com.hfjy.api.dto.StudentDTO;

import java.util.List;

/**
 * 数据查询服务
 * @author hsx
 * create at 2019-06-11
 */
public interface IStudentService {
    /**
     * 根据年级id获取年级信息
     * @param id 年级id
     * @return
     */
    GradeDTO getGradeById(int id);

    /**
     * 根据年级id获取班级信息列表
     * @param gradeId 年级id
     * @return
     */
    List<ClassDTO> getClassesByGrade(int gradeId);

    /**
     * 根据班级id获取学生信息列表
     * @param classId 班级id
     * @return
     */
    List<StudentDTO> getStudentsByClass(int classId);
}
