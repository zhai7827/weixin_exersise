package com.zhai.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   
		//System.out.println("=======> my SecurityInterceptor :afterCompletion() ");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// 在业务处理器处理请求执行完成后,生成视图之前执行的动作。 ModelAndView里可以再放一些公用的东西
		//System.out.println("=======> my SecurityInterceptor :postHandle() ");
	}
	
	 /**  
     * 在业务处理器处理请求之前被调用  
     * 如果返回false  
  	 *    从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     * 如果返回true  
     *    执行下一个拦截器,直到所有的拦截器都执行完毕  
     *    再执行被拦截的Controller  
     *    然后进入拦截器链,  
     *    从最后一个拦截器往回执行所有的postHandle()  
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()  
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		String fullPath = request.getRequestURI();
        //String queryString = request.getQueryString();
        //String contextPath = request.getContextPath();
        //String controllerPath = fullPath.replace(contextPath, "");
        if (fullPath.equals("/")) { //请求主页话在controller中拦截
        	return true;
		} else {
			return true;
		}
	}

}
