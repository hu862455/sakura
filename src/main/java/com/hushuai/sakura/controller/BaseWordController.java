package com.hushuai.sakura.controller;

import com.alibaba.fastjson.JSON;
import com.hushuai.sakura.dto.BaseWord;
import com.hushuai.sakura.dto.Pronunciation;
import com.hushuai.sakura.service.BaseWordService;
import com.hushuai.sakura.service.PronunciationService;
import com.hushuai.sakura.tools.TtsV1;
import com.hushuai.sakura.vo.Result;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

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
    private TtsV1 ttsV1;
    @Autowired
    private BaseWordService baseWordService;
    @Autowired
    private PronunciationService pronunciationService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "hushuai");
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

    /**
     * @Description: 根据type随机获取baseWords
     * @params: [length, type]
     * @return: java.lang.String
     * @exception:
     * @methodName: randomBaseWordsByType
     * @updateDate: 2019/11/8 20:44
     * @updateAuthor: shuaihu2
     */
    @RequestMapping(value = "/randomBaseWordsByType", method = RequestMethod.GET)
    @ResponseBody
    public String randomBaseWordsByType(Integer length, String type) {
        List<BaseWord> baseWords = baseWordService.selectRandByType(type, length);
        return JSON.toJSONString(new Result(baseWords));
    }

    @RequestMapping(value = "/getPronunciation")
    @ResponseBody
    public String getPronunciation(HttpServletRequest request, HttpServletResponse response, String q, String type) throws IOException {
        String path = pronunciationService.getMP3Path(q);
        String Mp3Path;
        if (path == null) {
            // 1.数据库中没有对应音频文件
            // 2.访问接口获取对应音频文件并存储
            Map<String, String> yuYinParams = ttsV1.getYuYinParams(q, "ja", "baseWord");
            if("true".equals(yuYinParams.get("success"))){
                // 转储成功
                Mp3Path = yuYinParams.get("path");
                Pronunciation newPronunciation = new Pronunciation();
                newPronunciation.setPronunciationPath(Mp3Path);
                newPronunciation.setPronunciationType("baseWord");
                newPronunciation.setText(q);
                pronunciationService.insert(newPronunciation);
            }else{
                // 失败返回
                return JSON.toJSONString(new Result(Integer.valueOf(yuYinParams.get("errorCode")),yuYinParams.get("msg")));
            }
        }else{
            // 数据库中有对应音频文件
            Mp3Path = path;
            File file = new File(Mp3Path);
            // 如果音频原始文件不存在
            if (!file.exists()) throw new RuntimeException("音频文件不存在 --> 404");
            String range = request.getHeader("Range");
            String[] rs = range.split("\\=");
            range = rs[1].split("\\-")[0];
            int start = Integer.parseInt(range);
            long length = file.length();
            if (start > 0)
            {
                response.setStatus(HttpStatus.SC_PARTIAL_CONTENT);
            }
            response.addHeader("Accept-Ranges", "bytes");
            response.addHeader("Content-Length", length + "");
            response.addHeader("Content-Range", "bytes " + start + "-" + (length - 1) + "/" + length);
            response.addHeader("Content-Type", "audio/mpeg;charset=UTF-8");

            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            fis.skip(start);
            FileCopyUtils.copy(fis, os);

        }




//        Map<String, String> yuYinParams = ttsV1.getYuYinParams("おやすみ", "ja", "baseWord");
//        return JSON.toJSONString(yuYinParams);
        return null;
    }
}
