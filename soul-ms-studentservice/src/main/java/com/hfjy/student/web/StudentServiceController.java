package com.hfjy.student.web;

import com.hfjy.api.IStudentServiceClient;
import com.hfjy.api.dto.ClassDTO;
import com.hfjy.api.dto.GradeDTO;
import com.hfjy.api.dto.StudentDTO;
import com.hfjy.student.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据服务
 * @author hsx
 * create at 2019-06-11
 */
@Slf4j
@RestController
public class StudentServiceController implements IStudentServiceClient {
    @Autowired
    private IStudentService studentService;
    @Override
    public GradeDTO getGradeById(@PathVariable int id) {
        log.info("--查询年级:{}的信息",id);
        return studentService.getGradeById(id);
    }

    @Override
    public List<ClassDTO> getClassesByGrade(int gradeId) {
        log.info("--查询年级:{}下的班级列表",gradeId);
        return studentService.getClassesByGrade(gradeId);
    }

    @Override
    public List<StudentDTO> getStudentsByClass(int classId) {
        log.info("--查询班级:{}下的学生列表",classId);
        return studentService.getStudentsByClass(classId);
    }
}
