package com.hushuai.sakura.tools;

import com.alibaba.fastjson.JSONObject;
import com.hushuai.sakura.constant.YouDaoConstants;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shuaihu2
 * @Date: 2019/11/11
 * @Interface: TtsV1
 * @Description:
 */
@Component
public class TtsV1 {

    private static Logger logger = LoggerFactory.getLogger(TtsV1.class);

    @Value("${youdao.YOUDAO_URL}")
    private String YOUDAO_URL;
    @Value("${youdao.APP_KEY}")
    private String APP_KEY;
    @Value("${youdao.APP_SECRET}")
    private String APP_SECRET;

    /**
     * @Description:TODO
     * @params: [url, params, type(baseWord,word,sentence)]
     * @return: void
     * @exception:
     * @methodName: requestForHttp
     * @updateDate: 2019/11/15 15:36
     * @updateAuthor: shuaihu2
     */
    public static Map<String, String> requestForHttp(String url, Map<String, String> params, String type) throws IOException {
        /** 创建HttpClient */
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HashMap<String, String> results = new HashMap<>();
        /** httpPost */
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
        Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> en = it.next();
            String key = en.getKey();
            String value = en.getValue();
            paramsList.add(new BasicNameValuePair(key, value));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(paramsList, "UTF-8"));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try {
            Header[] contentType = httpResponse.getHeaders("Content-Type");
            logger.info("Content-Type:" + contentType[0].getValue());
            if ("audio/mp3".equals(contentType[0].getValue())) {
                //如果响应是wav
                HttpEntity httpEntity = httpResponse.getEntity();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(baos);
                byte[] result = baos.toByteArray();
                EntityUtils.consume(httpEntity);
                if (result.length > 0) {//合成成功
                    String property = System.getProperty("user.home");
                    switch (type) {

                        case "baseWord":
                            property += "/sakura/baseWord";
                            break;
                        case "word":
                            property += "/sakura/word";
                            break;
                        case "sentence":
                            property += "/sakura/sentence";
                            break;
                        default:
                            property += "/sakura";
                            break;
                    }
                    File file1 = new File(property);
                    if (!file1.exists()) {
                        boolean newFile = file1.mkdirs();
                    }
                    String q = params.get("q");
                    String file = property + "/" + q + ".mp3";
                    byte2File(result, file);

                    results.put("success", "true");
                    results.put("path", file);
                    results.put("msg", "获取成功");
                    results.put("errorCode", "200");
                }
            } else {
                /** 响应不是音频流，直接显示结果 */
                HttpEntity httpEntity = httpResponse.getEntity();
                String json = EntityUtils.toString(httpEntity, "UTF-8");
                JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
                EntityUtils.consume(httpEntity);
                results.put("success", "false");
                results.put("path", null);
                results.put("errorCode", jsonObject.getString("errorCode"));
                results.put("msg", YouDaoConstants.getByErrorCode(jsonObject.getString("errorCode")).getMsg());
            }
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                logger.info("## release resouce error ##" + e);
            }
        }
        return results;
    }

    /**
     * 生成加密字段
     */
    public static String getDigest(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * @param result 音频字节流
     * @param file   存储路径
     */
    private static void byte2File(byte[] result, String file) {
        File audioFile = new File(file);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(audioFile);
            fos.write(result);

        } catch (Exception e) {
            logger.info(e.toString());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }


    public Map<String, String> getYuYinParams(String q, String langType, String type) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("langType", langType);
        params.put("appKey", APP_KEY);
        params.put("q", q);
        params.put("salt", String.valueOf(System.currentTimeMillis()));
        params.put("sign", getDigest(APP_KEY + q + String.valueOf(System.currentTimeMillis()) + APP_SECRET));
        Map<String, String> stringStringMap = requestForHttp(YOUDAO_URL, params, type);
        return stringStringMap;
    }
}
