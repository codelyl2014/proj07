package com.hfjy.student.dao;

import com.hfjy.student.bean.domain.ClassDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 骇客马拉松—班级基础表 Mapper 接口
 * </p>
 *
 * @author hsx
 * @since 2019-06-11
 */
public interface ClassDao extends BaseMapper<ClassDO> {
    /**
     * 查询指定年级下的班级列表
     * @param gradeId
     * @return
     */
    List<ClassDO> getClassesByGrade(int gradeId);
}
