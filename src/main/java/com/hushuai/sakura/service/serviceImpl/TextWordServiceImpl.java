package com.hushuai.sakura.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hushuai.sakura.dto.TextWord;
import com.hushuai.sakura.mapper.TextWordMapper;
import com.hushuai.sakura.service.TextWordService;
@Service
public class TextWordServiceImpl implements TextWordService{

    @Resource
    private TextWordMapper textWordMapper;

    @Override
    public int insert(TextWord record) {
        return textWordMapper.insert(record);
    }

    @Override
    public int insertSelective(TextWord record) {
        return textWordMapper.insertSelective(record);
    }

}
