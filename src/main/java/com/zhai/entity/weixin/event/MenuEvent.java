package com.zhai.entity.weixin.event;

/**
 * Created by admin on 2017/11/2.
 * 点击view类型（跳转到URL）的菜单按钮时，微信服务器不会推送自定义菜单事件。
 */
public class MenuEvent {
    // 事件KEY值，与自定义菜单接口中KEY值对应
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        eventKey = eventKey;
    }
}
