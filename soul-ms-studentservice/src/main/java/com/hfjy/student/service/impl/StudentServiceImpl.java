package com.hfjy.student.service.impl;

import com.hfjy.api.dto.ClassDTO;
import com.hfjy.api.dto.GradeDTO;
import com.hfjy.api.dto.StudentDTO;
import com.hfjy.student.bean.domain.ClassDO;
import com.hfjy.student.bean.domain.GradeDO;
import com.hfjy.student.bean.domain.StudentDO;
import com.hfjy.student.dao.ClassDao;
import com.hfjy.student.dao.GradeDao;
import com.hfjy.student.dao.StudentDao;
import com.hfjy.student.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数据查询服务实现
 * @author hsx
 * create at 2019-06-11
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private ClassDao classDao;
    @Autowired
    private GradeDao gradeDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public GradeDTO getGradeById(int id) {
        GradeDO  gradeDO = gradeDao.selectById(id);
        GradeDTO gradeDTO = new GradeDTO();
        if(gradeDO != null){
            BeanUtils.copyProperties(gradeDO,gradeDTO);
        }
        return gradeDTO;
    }

    @Override
    public List<ClassDTO> getClassesByGrade(int gradeId) {
        List<ClassDO> classDOList = classDao.getClassesByGrade(gradeId);
        if(CollectionUtils.isEmpty(classDOList)){
            return Collections.emptyList();
        }
        List<ClassDTO> classDTOList = new ArrayList<>(classDOList.size());
        classDOList.stream().forEach(classDO -> {ClassDTO classDTO=new ClassDTO();
            BeanUtils.copyProperties(classDO,classDTO);
            classDTOList.add(classDTO);
        });
        return classDTOList;
    }

    @Override
    public List<StudentDTO> getStudentsByClass(int classId) {
        List<StudentDO> studentDOList = studentDao.getStudentsByClass(classId);
        if(CollectionUtils.isEmpty(studentDOList)){
            return Collections.emptyList();
        }
        List<StudentDTO> studentDTOList = new ArrayList<>(studentDOList.size());
        studentDOList.stream().forEach(studentDO -> {StudentDTO studentDTO = new StudentDTO();
            BeanUtils.copyProperties(studentDO,studentDTO);
            studentDTOList.add(studentDTO);
        });
        return studentDTOList;
    }
}
