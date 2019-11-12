package com.hushuai.sakura.service;

import com.hushuai.sakura.dto.TextWord;
public interface TextWordService{


    int insert(TextWord record);

    int insertSelective(TextWord record);

}
