package com.hushuai.sakura.vo;

import com.hushuai.sakura.constant.HttpConstant;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shuaihu2
 * @Date: 2019/11/1
 * @Interface: Result
 * @Description: 返回实体类
 */
public class Result {
    /** code码 */
    private int code;
    /** 消息 */
    private String message;
    /** List */
    private List<?> list;
    /** 对象 */
    private Object obj;

    private Result() {
    }

    public Result(List<?> list) {
        this.code = HttpConstant.SUCCESS_CODE;
        this.message = HttpConstant.SUCCESS_MSG;
        this.list = list;
    }

    public Result(Object obj) {
        this.code = HttpConstant.SUCCESS_CODE;
        this.message = HttpConstant.SUCCESS_MSG;
        this.obj = obj;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, List<?> list, Object obj) {
        this.code = code;
        this.message = message;
        this.list = list;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
