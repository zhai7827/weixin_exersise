package com.zhai.weixin.entity.message;

/**
 * Created by admin on 2017/11/1.
 * 微信请求消息基类
 */
public class BaseMessage {
    //开发者微信号（公众号的原始id）
    private String toUserName;
    //发送方账号（用户唯一的openId）
    private String fromUserName;
    //创建时间
    private long createTime;
    //消息类型
    private String megType;
    //消息id
    private long msgId;

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

    public String getMegType() {
        return megType;
    }

    public void setMegType(String megType) {
        this.megType = megType;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
