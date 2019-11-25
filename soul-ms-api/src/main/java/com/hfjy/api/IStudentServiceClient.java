package com.hfjy.api;

import com.hfjy.api.dto.ClassDTO;
import com.hfjy.api.dto.GradeDTO;
import com.hfjy.api.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 学生服务客户端
 * @author hsx
 * create at 2019-06-11
 */
@FeignClient(name="service")
public interface IStudentServiceClient {

    /**
     * 根据年级id获取年级信息
     * @param id 年级id
     * @return
     */
    @GetMapping("/grade/{id}")
    GradeDTO getGradeById(@PathVariable int id);

    /**
     * 根据年级id获取班级信息列表
     * @param gradeId 年级id
     * @return
     */
    @GetMapping("/grade/classes")
    List<ClassDTO> getClassesByGrade(@RequestParam int gradeId);

    /**
     * 根据班级id获取学生信息列表
     * @param classId 班级id
     * @return
     */
    @GetMapping("/class/students")
    List<StudentDTO> getStudentsByClass(@RequestParam int classId);

}
