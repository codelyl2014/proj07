package com.hfjy.api.dto;

import lombok.Data;

/**
 * 年级数据传输对象
 * @author hsx
 * create at 2019-06-11
 */
@Data
public class GradeDTO {

    /**
     * 自增id
     */
    private Integer id;

    /**
     * 年级名称，一年级、二年级、三年级...
     */
    private String name;
}
