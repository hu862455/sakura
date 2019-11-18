package com.hushuai.sakura.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hushuai.sakura.mapper.PronunciationMapper;
import com.hushuai.sakura.dto.Pronunciation;
import com.hushuai.sakura.service.PronunciationService;
@Service
public class PronunciationServiceImpl implements PronunciationService{

    @Resource
    private PronunciationMapper pronunciationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pronunciationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Pronunciation record) {
        return pronunciationMapper.insert(record);
    }

    @Override
    public int insertSelective(Pronunciation record) {
        return pronunciationMapper.insertSelective(record);
    }

    @Override
    public Pronunciation selectByPrimaryKey(Integer id) {
        return pronunciationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Pronunciation record) {
        return pronunciationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pronunciation record) {
        return pronunciationMapper.updateByPrimaryKey(record);
    }

    @Override
    public String getMP3Path(String q) {
        Pronunciation pronunciation = pronunciationMapper.selectFirstByText(q);
        if(pronunciation == null){
            return null;
        }
        return pronunciation.getPronunciationPath();
    }

}
