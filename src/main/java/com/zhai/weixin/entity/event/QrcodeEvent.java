package com.zhai.weixin.entity.event;

/**
 * Created by admin on 2017/11/2.
 */
public class QrcodeEvent extends BaseEvent {
    // 事件KEY值
    private String eventKey;
    // 用于换取二维码图片
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
