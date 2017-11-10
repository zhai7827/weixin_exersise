package com.zhai.weixin.entity.message;

/**
 * Created by admin on 2017/11/2.
 */
public class VideoMessage {
    /**
     * <xml>
     <ToUserName><![CDATA[toUser]]></ToUserName>
     <FromUserName><![CDATA[fromUser]]></FromUserName>
     <CreateTime>1357290913</CreateTime>
     <MsgType><![CDATA[video]]></MsgType>
     <MediaId><![CDATA[media_id]]></MediaId>
     <ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
     <MsgId>1234567890123456</MsgId>
     </xml>
     */
    // 视频消息媒体ID
    private String MediaId;
    // 视频消息缩略图的媒体ID
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
