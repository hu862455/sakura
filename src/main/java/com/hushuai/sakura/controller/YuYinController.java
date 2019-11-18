package com.hushuai.sakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shuaihu2
 * @Date: 2019/11/12
 * @Interface: YuYincontroller
 * @Description:
 */
@Controller
@RequestMapping(value = "/conversion")
public class YuYinController {

    @RequestMapping()
    public void getYuYin(HttpServletRequest request, HttpServletResponse response, String text, String type) throws IOException {


        response.setHeader("Content-type", "text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");//解决乱码
        response.setContentType("text/html;charset=UTF-8");//解决乱码
        String sentences = request.getParameter("text");
        try {
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }
}
