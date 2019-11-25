package com.hfjy.student.dao;

import com.hfjy.student.bean.domain.StudentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 骇客马拉松—学生基础表 Mapper 接口
 * </p>
 *
 * @author hsx
 * @since 2019-06-11
 */
public interface StudentDao extends BaseMapper<StudentDO> {
    /**
     * 根据班级id获取学生列表
     * @param classId
     * @return
     */
    List<StudentDO> getStudentsByClass(int classId);
}
