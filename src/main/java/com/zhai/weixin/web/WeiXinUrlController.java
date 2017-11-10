package com.zhai.weixin.web;

import com.zhai.weixin.utils.CoreServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/9/27.
 */
@Controller
@RequestMapping(value="/weixin_wechat")
public class WeiXinUrlController {
    @RequestMapping(value="/wys")
    public  void weixinNotice(HttpServletRequest request, HttpServletResponse response){
        try {
            boolean b = CoreServlet.messageReceive(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value="/test")
    public  @ResponseBody Object test(HttpServletRequest request, HttpServletResponse response){
        return "就是试试";
    }
}
