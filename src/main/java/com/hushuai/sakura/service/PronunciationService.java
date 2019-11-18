package com.hushuai.sakura.service;

import com.hushuai.sakura.dto.Pronunciation;
public interface PronunciationService{


    int deleteByPrimaryKey(Integer id);

    int insert(Pronunciation record);

    int insertSelective(Pronunciation record);

    Pronunciation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pronunciation record);

    int updateByPrimaryKey(Pronunciation record);

    String getMP3Path(String q);
}
