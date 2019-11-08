package com.hushuai.sakura.controller;

import com.alibaba.fastjson.JSON;
import com.hushuai.sakura.dto.BaseWord;
import com.hushuai.sakura.service.BaseWordService;
import com.hushuai.sakura.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shuaihu2
 * @Date: 2019/11/1
 * @Interface: BaseWordController
 * @Description:
 */
@Controller
@RequestMapping("/baseWord")
public class BaseWordController {

    @Autowired
    private BaseWordService baseWordService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name","hushuai");
        return "/index";

    }
    /**
     * @Description:TODO
     * @params: [type]
     * @return: java.lang.String
     * @exception:
     * @methodName: getAllByType
     * @updateDate: 2019/11/1 15:59
     * @updateAuthor: shuaihu2
     */
    @ResponseBody
    @RequestMapping(value = "/getAllByType", method = RequestMethod.GET)
    public String getAllByType(String type) {
        List<BaseWord> baseWords = baseWordService.selectAllByType(type);
        return JSON.toJSONString(new Result(baseWords));
    }

    /**
     * @Description: 根据行查询
     * @params: [rowName]
     * @return: java.lang.String
     * @exception:
     * @methodName: getAllByRowName
     * @updateDate: 2019/11/1 15:59
     * @updateAuthor: shuaihu2
     */
    @RequestMapping(value = "/getAllByRowName", method = RequestMethod.GET)
    @ResponseBody
    public String getAllByRowName(String rowName) {
        List<BaseWord> baseWords = baseWordService.selectAllByRowName(rowName);
        return JSON.toJSONString(new Result(baseWords));
    }

    /**
     * @Description: 根据段查询
     * @params: [colName]
     * @return: java.lang.String
     * @exception:
     * @methodName: getAllByColName
     * @updateDate: 2019/11/1 16:00
     * @updateAuthor: shuaihu2
     */
    @RequestMapping(value = "/getAllByColName", method = RequestMethod.GET)
    @ResponseBody
    public String getAllByColName(String colName) {
        List<BaseWord> baseWords = baseWordService.selectAllByColName(colName);
        return JSON.toJSONString(new Result(baseWords));
    }

    /**
     * @Description: 根据平假名查询
     * @params: [ping]
     * @return: java.lang.String
     * @exception:
     * @methodName: getByPing
     * @updateDate: 2019/11/1 16:00
     * @updateAuthor: shuaihu2
     */
    @RequestMapping(value = "/getByPing", method = RequestMethod.GET)
    @ResponseBody
    public String getByPing(String ping) {
        BaseWord baseWords = baseWordService.selectFirstByPing(ping);
        return JSON.toJSONString(new Result(baseWords));
    }

    /**
     * @Description: 根据片假名查询
     * @params: [pian]
     * @return: java.lang.String
     * @exception:
     * @methodName: getByPian
     * @updateDate: 2019/11/1 16:00
     * @updateAuthor: shuaihu2
     */
    @RequestMapping(value = "/getByPian", method = RequestMethod.GET)
    @ResponseBody
    public String getByPian(String pian) {
        BaseWord baseWords = baseWordService.selectFirstByPian(pian);
        return JSON.toJSONString(new Result(baseWords));
    }

    /**
     * @Description: 根据罗马音查询
     * @params: [roma]
     * @return: java.lang.String
     * @exception:
     * @methodName: getByRoma
     * @updateDate: 2019/11/1 16:00
     * @updateAuthor: shuaihu2
     */
    @RequestMapping(value = "/getByRoma", method = RequestMethod.GET)
    @ResponseBody
    public String getByRoma(String roma) {
        BaseWord baseWords = baseWordService.selectFirstByRoma(roma);
        return JSON.toJSONString(new Result(baseWords));
    }

    /**
     * @Description: 随机取一个baseword
     * @params: []
     * @return: java.lang.String
     * @exception:
     * @methodName: randomBaseWord
     * @updateDate: 2019/11/1 16:15
     * @updateAuthor: shuaihu2
     */
    @RequestMapping(value = "/randomBaseWord", method = RequestMethod.GET)
    @ResponseBody
    public String randomBaseWord() {
        BaseWord baseWords = baseWordService.selectByRandom();
        return JSON.toJSONString(new Result(baseWords));
    }

    @RequestMapping(value = "/randomBaseWords", method = RequestMethod.GET)
    @ResponseBody
    public String randomBaseWords(Integer length) {
        List<BaseWord> baseWords = baseWordService.selectByRandoms(length);
        return JSON.toJSONString(new Result(baseWords));
    }

    @RequestMapping(value = "/randomBaseWordsByType", method = RequestMethod.GET)
    @ResponseBody
    public String  randomBaseWordsByType(Integer length, String type){
        List<BaseWord> baseWords = baseWordService.selectRandByType(type, length);
        return JSON.toJSONString(new Result(baseWords));
    }
}
