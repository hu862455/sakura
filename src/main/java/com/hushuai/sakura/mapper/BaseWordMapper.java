package com.hushuai.sakura.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.hushuai.sakura.dto.BaseWord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Class_name: BaseWordMapper
 * @Exception: 
 * @Describe: BaseWordMapper
 * @Author: shuaihu2
 * @Creat_date: 2019/11/1 14:22
 **/
@Mapper
public interface BaseWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseWord record);

    int insertSelective(BaseWord record);

    BaseWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseWord record);

    int updateByPrimaryKey(BaseWord record);

    /**
     * 根据类型查询所有的baseword
     * @param type
     * @return
     */
    List<BaseWord> selectAllByType(@Param("type")String type);

    /**
     * 根据段来查询所有的baseword
     * @param colName
     * @return
     */
    List<BaseWord> selectAllByColName(@Param("colName")String colName);

    /**
     * 根据行来查询所有的baseword
     * @param rowName
     * @return
     */
    List<BaseWord> selectAllByRowName(@Param("rowName")String rowName);

    /**
     * 根据片假名查询baseword实体
     * @param pian
     * @return
     */
	BaseWord selectFirstByPian(@Param("pian")String pian);

    /**
     * 根据平假名查询baseword实体
     * @param ping
     * @return
     */
    BaseWord selectFirstByPing(@Param("ping")String ping);

    /**
     * 根据罗马音查询baseword实体
     * @param roma
     * @return
     */
    BaseWord selectFirstByRoma(@Param("roma")String roma);

    /**
     * 获取表中总个数
     * @return
     */
    Integer count();

    List<BaseWord> selectRandByType(@Param("type")String type,@Param("wordCount")Integer wordCount);






}