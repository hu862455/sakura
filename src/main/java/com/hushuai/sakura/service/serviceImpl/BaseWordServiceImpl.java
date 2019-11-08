package com.hushuai.sakura.service.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hushuai.sakura.dto.BaseWord;
import com.hushuai.sakura.mapper.BaseWordMapper;
import com.hushuai.sakura.service.BaseWordService;

/**
 * @Class_name: BaseWordServiceImpl
 * @Exception:
 * @Describe: BaseWordServiceImpl
 * @Author: shuaihu2
 * @Creat_date: 2019/11/1 14:24
 **/
@Service
public class BaseWordServiceImpl implements BaseWordService {

    @Resource
    private BaseWordMapper baseWordMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return baseWordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BaseWord record) {
        return baseWordMapper.insert(record);
    }

    @Override
    public int insertSelective(BaseWord record) {
        return baseWordMapper.insertSelective(record);
    }

    @Override
    public BaseWord selectByPrimaryKey(Integer id) {
        return baseWordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseWord record) {
        return baseWordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseWord record) {
        return baseWordMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<BaseWord> selectAllByType(String type){
		 return baseWordMapper.selectAllByType(type);
	}

	@Override
	public List<BaseWord> selectAllByColName(String colName){
		 return baseWordMapper.selectAllByColName(colName);
	}

	@Override
	public List<BaseWord> selectAllByRowName(String rowName){
		 return baseWordMapper.selectAllByRowName(rowName);
	}

	@Override
	public BaseWord selectFirstByPian(String pian){
		 return baseWordMapper.selectFirstByPian(pian);
	}

	@Override
	public BaseWord selectFirstByPing(String ping){
		 return baseWordMapper.selectFirstByPing(ping);
	}

	@Override
	public BaseWord selectFirstByRoma(String roma){
		 return baseWordMapper.selectFirstByRoma(roma);
	}

    @Override
    public BaseWord selectByRandom() {
        // 1.查询所有数据个数(因为id是按照自增排列的,所以随机去一个1-最大id就好)
        Integer count = this.count();
        // 2.取随机数
        int id = (int) (1 + Math.random() * (count - 1 + 1));
        // 3.查询对应实体
        BaseWord randowWord = selectByPrimaryKey(id);
        return randowWord;
    }

	@Override
	public Integer count(){
		 return baseWordMapper.count();
	}

    @Override
    public List<BaseWord> selectByRandoms(Integer length) {
        List<BaseWord> baseWords = new ArrayList<>();
        BaseWord baseWord = new BaseWord();
        for (int i = 1; i < length; i++) {
            baseWord = this.selectByRandom();
            baseWords.add(baseWord);
        }
        return baseWords;
    }

	@Override
	public List<BaseWord> selectRandByType(String type, Integer wordCount){
		 return baseWordMapper.selectRandByType(type, wordCount);
	}





}



