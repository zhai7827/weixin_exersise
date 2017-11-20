package com.zhai.utils.weixin;


import com.zhai.service.impl.CoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by admin on 2017/11/2.
 */
public class CoreServlet extends HttpServlet {
    private static final long serialVersionUID = 4440739483644821986L;

    /**
     * 请求校验（确认请求来自微信服务器）
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 微信加密签名　
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
             // 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
            }
        out.close();
        out = null;
        }



    /**
     * 　   * 请求校验与处理
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 接收参数：微信加密签名、 时间戳、随机数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        PrintWriter out = response.getWriter();
        // 请求校验
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            // 调用核心服务类接收处理请求
            String respXml = CoreService.processRequest("");
            out.print(respXml);
        }
        out.close();
        out = null;
    }

    public static boolean messageReceive(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, Exception {
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        OutputStream os = response.getOutputStream();
        boolean fromWeiXIn = false;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        br.close();
        isr.close();
        is.close();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println(signature + "timestamp=" + timestamp + "nonce=" + nonce + "echostr=" + echostr + "==" + sb.toString());
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            fromWeiXIn = true;
            if (echostr == null) {
                //这个是交互过程
                    String respXml = CoreService.processRequest(sb.toString());
                    System.out.println("respXml=" + respXml);
                    os.write(respXml.getBytes("UTF-8"));
                } else {
                //这个是首次接入的时候 的验证 需要将echostr 原样返回
                     os.write(echostr.getBytes());
            }
        }
        os.flush();
        os.close();
        return fromWeiXIn;
    }
}
