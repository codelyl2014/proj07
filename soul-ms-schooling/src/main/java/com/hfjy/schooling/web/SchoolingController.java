package com.hfjy.schooling.web;

import com.hfjy.schooling.bean.MaxClassesDTO;
import com.hfjy.schooling.service.SchoolingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授课业务处理器
 * @author hsx
 * create at 2019-06-11
 */
@Slf4j
@RestController
public class SchoolingController {

    @Autowired
    private SchoolingService schoolingService;

    @GetMapping("/maxClasses/{gradeId}")
    public MaxClassesDTO getMaxClassesByGradle(@PathVariable int gradeId){
        long begin=System.currentTimeMillis();
        MaxClassesDTO maxClassesDTO = schoolingService.getMaxClassesByGradle(gradeId);
        log.info("--本次请求年级:{}的男女学生最多的班级信息耗时:{}",gradeId,System.currentTimeMillis()-begin);
        return maxClassesDTO;
    }

}
