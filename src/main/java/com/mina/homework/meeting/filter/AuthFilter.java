//package com.mina.homework.meeting.filter;
//
//
//import javax.servlet.ServletRequest;
//
///**
// * 权限验证过滤器
// */
//
//public class AuthFilter implements Filter {
//
//    @Override
//    public void destroy() {
//        // 顾名思义，在销毁时使用
//    }
//
//    @Override
//    public void doFilter(ServletRequest arg0, ServletResponse arg1,
//                         FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest)arg0;
//        HttpServletResponse response = (HttpServletResponse)arg1;
//        if(needLogin(request)) {
//            // 需要登录则跳转到登录Controller
//            response.sendRedirect("login");
//            return;
//        }
//        chain.doFilter(arg0, arg1);
//    }
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        // 初始化操作
//    }
//
//    /**
//     * 判断是否需要登录
//     * @param request
//     * @return
//     */
//    private boolean needLogin(HttpServletRequest request) {
//        //进行是否需要登录的判断操作
//        return false;
//    }
//
//}