package com.hushuai.sakura.mapper;
import org.apache.ibatis.annotations.Param;

import com.hushuai.sakura.dto.Pronunciation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PronunciationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pronunciation record);

    int insertSelective(Pronunciation record);

    Pronunciation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pronunciation record);

    int updateByPrimaryKey(Pronunciation record);

    Pronunciation selectFirstByText(@Param("text")String text);

}