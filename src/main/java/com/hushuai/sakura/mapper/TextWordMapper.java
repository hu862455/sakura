package com.hushuai.sakura.mapper;

import com.hushuai.sakura.dto.TextWord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TextWordMapper {
    int insert(TextWord record);

    int insertSelective(TextWord record);
}