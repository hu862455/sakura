package com.hushuai.sakura.dto;

import lombok.Data;

@Data
public class Pronunciation {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 基本词:baseWord,单词:word,句子:sentence
    */
    private String pronunciationType;

    /**
    * 音频文件路径
    */
    private String pronunciationPath;

    /**
    * 发音文字
    */
    private String text;
}