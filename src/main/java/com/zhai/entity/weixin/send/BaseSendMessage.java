package com.zhai.entity.weixin.send;

/**
 * Created by admin on 2017/11/2.
 */
public class BaseSendMessage {
    // 接收方账号（收到的OpenID）
    private String toUserName;
    // 开发者微信号
    private String fromUserName;
    // 消息创建时间 （整型）
    private long createTime;
    // 消息类型（text/music/news）
    private String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
