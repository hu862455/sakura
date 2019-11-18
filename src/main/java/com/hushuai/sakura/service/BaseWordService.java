package com.hushuai.sakura.service;
import java.util.List;

import com.hushuai.sakura.dto.BaseWord;
/**
 * @Class_name: BaseWordService
 * @Exception:
 * @Describe: BaseWordService
 * @Author: shuaihu2
 * @Creat_date: 2019/11/1 14:23
 **/
public interface BaseWordService {


    int deleteByPrimaryKey(Integer id);

    int insert(BaseWord record);

    int insertSelective(BaseWord record);

    BaseWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseWord record);

    int updateByPrimaryKey(BaseWord record);



	List<BaseWord> selectAllByType(String type);



	List<BaseWord> selectAllByColName(String colName);



	List<BaseWord> selectAllByRowName(String rowName);



	BaseWord selectFirstByPian(String pian);



	BaseWord selectFirstByPing(String ping);



	BaseWord selectFirstByRoma(String roma);


    BaseWord selectByRandom();

	Integer count();

    List<BaseWord> selectByRandoms(Integer length);



    List<BaseWord> selectRandByType(String type, Integer wordCount);

    String getMP3Path(String q);
}



