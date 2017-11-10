package com.zhai.weixin.entity.send;

/**
 * Created by admin on 2017/11/2.
 */
public class TextMessage extends BaseSendMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
