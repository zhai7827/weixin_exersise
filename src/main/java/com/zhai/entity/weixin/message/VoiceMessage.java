package com.zhai.entity.weixin.message;

/**
 * Created by admin on 2017/11/2.
 */
public class VoiceMessage {
    /**
     * <xml>
     <ToUserName><![CDATA[toUser]]></ToUserName>
     <FromUserName><![CDATA[fromUser]]></FromUserName>
     <CreateTime>1357290913</CreateTime>
     <MsgType><![CDATA[voice]]></MsgType>
     <MediaId><![CDATA[media_id]]></MediaId>
     <Format><![CDATA[Format]]></Format>
     <Recognition><![CDATA[腾讯微信团队]]></Recognition>
     <MsgId>1234567890123456</MsgId>
     </xml>
     */
    // 媒体ID
    private String mediaId;
    // 语音格式
    private String format;
    // 语音识别结果，UTF8编码
    private String recognition;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
