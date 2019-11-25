package com.hfjy.schooling.service;

import com.hfjy.api.IStudentServiceClient;
import com.hfjy.api.dto.ClassDTO;
import com.hfjy.api.dto.GradeDTO;
import com.hfjy.api.dto.StudentDTO;
import com.hfjy.schooling.bean.ClassInfo;
import com.hfjy.schooling.bean.ClassPeopleInfo;
import com.hfjy.schooling.bean.MaxClassesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 授课服务
 * @author hsx
 * create at 2019-06-11
 */
@Service
public class SchoolingService {
    @Autowired
    private IStudentServiceClient studentServiceClient;
    /**
     * 根据年级id获取年级下男女人数最多的班级信息
     * @param gradeId
     * @return
     */
    public MaxClassesDTO getMaxClassesByGradle(int gradeId){
        MaxClassesDTO maxClassesDTO = new MaxClassesDTO();
        //获取年级信息
        GradeDTO gradeDTO = studentServiceClient.getGradeById(gradeId);
        if(gradeDTO==null){
            return maxClassesDTO;
        }
        maxClassesDTO.setGradeName(gradeDTO.getName());
        //获取年级下的班级信息列表
        List<ClassDTO> classDTOList = studentServiceClient.getClassesByGrade(gradeId);
        if(CollectionUtils.isEmpty(classDTOList)){
            return maxClassesDTO;
        }
        //获取各个班级下的学生信息列表,统计那个班级的男女生人数最多
        List<ClassPeopleInfo> classPeopleNums = new Vector<>(classDTOList.size());
        classDTOList.parallelStream().forEach(classDTO -> {
          List<StudentDTO> studentDTOList = studentServiceClient.getStudentsByClass(classDTO.getId());
          int maleNum=0;
          int femaleNum=0;
          for(StudentDTO studentDTO:studentDTOList){
              if(studentDTO.getGender()==1){
                  maleNum++;
              }else if(studentDTO.getGender()==2){
                  femaleNum++;
              }
          }
            classPeopleNums.add(new ClassPeopleInfo(classDTO,maleNum,femaleNum));
        });
        if(CollectionUtils.isEmpty(classPeopleNums)){
            return maxClassesDTO;
        }
        Collections.sort(classPeopleNums, (o1,o2)-> o2.getMaleNum()-o1.getMaleNum());
        int maxMaleNum = classPeopleNums.get(0).getMaleNum();
        maxClassesDTO.setMale(maxMaleNum);
        maxClassesDTO.setMaleClasses(new ArrayList<>());
        for(ClassPeopleInfo classPeopleInfo:classPeopleNums){
            if(maxMaleNum>classPeopleInfo.getMaleNum()){
                break;
            }
            maxClassesDTO.getMaleClasses().add(new ClassInfo(classPeopleInfo.getClassInfo().getId(),classPeopleInfo.getClassInfo().getName()));
        }
        Collections.sort(classPeopleNums, (o1,o2)-> o2.getFemaleNum()-o1.getFemaleNum());
        int maxFemaleNum = classPeopleNums.get(0).getFemaleNum();
        maxClassesDTO.setFemale(maxFemaleNum);
        maxClassesDTO.setFemaleClasses(new ArrayList<>());
        for(ClassPeopleInfo classPeopleInfo:classPeopleNums){
            if(maxFemaleNum>classPeopleInfo.getFemaleNum()){
                break;
            }
            maxClassesDTO.getFemaleClasses().add(new ClassInfo(classPeopleInfo.getClassInfo().getId(),classPeopleInfo.getClassInfo().getName()));
        }
        return maxClassesDTO;
    }
}
