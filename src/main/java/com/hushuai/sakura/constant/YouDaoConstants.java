package com.hushuai.sakura.constant;

public enum YouDaoConstants {
    SUCCESS("200","成功"),
    FAILURE0("101","缺少必填的参数"),
    FAILURE1("102","不支持的语言类型"),
    FAILURE2("103","翻译文本过长"),
    FAILURE3("104","不支持的API类型"),
    FAILURE4("105","不支持的签名类型"),
    FAILURE5("106","不支持的响应类型"),
    FAILURE6("107","不支持的传输加密类型"),
    FAILURE7("108","应用ID无效，注册账号，登录后台创建应用和实例并完成绑定，可获得应用ID和应用密钥等信息"),
    FAILURE8("110","无相关服务的有效实例"),
    FAILURE9("111","开发者账号无效"),
    FAILURE10("113","q不能为空"),
    FAILURE11("201","解密失败，可能为DES,BASE64,URLDecode的错误"),
    FAILURE12("202","签名检验失败"),
    FAILURE13("203","访问IP地址不在可访问IP列表"),
    FAILURE14("301","辞典查询失败"),
    FAILURE15("302","翻译查询失败"),
    FAILURE16("303","服务端的其它异常"),
    FAILURE17("401","账户已经欠费停"),
    FAILURE18("411","访问频率受限,请稍后访问"),
    FAILURE19("412","长请求过于频繁，请稍后访问"),
    FAILURE20("1412","超过最大识别字节数"),
    FAILURE21(null,"未知"),
    UNKNOWN("-1000","未知错误");

    private String errorCode;
    private String msg;

    YouDaoConstants(String errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static YouDaoConstants getByErrorCode(String errorCode) {
        for (YouDaoConstants youDaoConstant : values()) {
            if (youDaoConstant.getErrorCode() == errorCode) {
                return youDaoConstant;
            }
        }
        return null;
    }

}
