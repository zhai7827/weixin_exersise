package com.zhai.weixin.entity.message;

/**
 * Created by admin on 2017/11/2.
 */
public class ImageMessage {
    /**
     * <xml>
     <ToUserName><![CDATA[toUser]]></ToUserName>
     <FromUserName><![CDATA[fromUser]]></FromUserName>
     <CreateTime>1348831860</CreateTime>
     <MsgType><![CDATA[image]]></MsgType>
     <PicUrl><![CDATA[this is a url]]></PicUrl>
     <MsgId>1234567890123456</MsgId>
     </xml>
     */
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
