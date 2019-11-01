package com.hushuai.sakura.dto;

import lombok.Data;
/**
 * @Class_name: BaseWord
 * @Exception:
 * @Describe: 基础音
 * @Author: shuaihu2
 * @Creat_date: 2019/11/1 14:22
 **/
@Data
public class BaseWord {
    private Integer id;

    /**
     * 罗马音
     */
    private String roma;

    /**
     * 平假名
     */
    private String ping;

    /**
     * 片假名
     */
    private String pian;

    /**
     * 行名
     */
    private String rowName;

    /**
     * 段名
     */
    private String colName;

    /**
     * 清音:0 浊音1 半浊音2 拗音3 拨音9
     */
    private String type;
}