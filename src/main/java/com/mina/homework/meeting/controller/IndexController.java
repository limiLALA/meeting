package com.mina.homework.meeting.controller;

import com.mina.homework.meeting.Utils;
import com.mina.homework.meeting.model.ViewObject;
import com.mina.homework.meeting.service.LoginService;
import com.mina.homework.meeting.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
//@RequestMapping("/")
public class IndexController {



    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        model.addAttribute("name",new String("mina"));
        model.addAttribute("is_login", true);
        return "meetingrooms";
    }
//    @Autowired
//    RegisterService registerService;
//
//    @PostMapping("/doreg")
//    public String doReg(@RequestParam("account") String account, @RequestParam("password") String password) {
//
//        if (registerService.reg(account, password) >= 0) {
//            return "success";
//        }
//        return "failed";
//    }
//
//    @Autowired
//    LoginService loginService;
//
//    @RequestMapping("/dologin")
//    public int doLogin(
//            @RequestParam("account") String account,
//            @RequestParam("password") String password,
//            HttpServletResponse response,
//            HttpServletRequest request) {
//
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null){
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("token")){
//                    String token = cookie.getValue();
//                    if(Utils.tokens.getOrDefault(token, false)==true){
//                        // 登陆过，而且还生效
//                        return 0;
//                    }
//                    // 未登陆过，或者登陆状态失效了
//                }
//            }
//        }
//
//
//
//        if (loginService.login(account, password)) {
//            // 生成token
//            String token = Utils.getRandomString(10);
//
//            // 写到服务器
//            Utils.tokens.put(token, true);
//
//            // 写到客户端（浏览器）
//            Cookie cookie = new Cookie("token", token);
//            response.addCookie(cookie);
//
//            return 0;
//        }
//
//        //滚去登录
//        return -1;
//    }
//
//    @GetMapping("/index")
//    public String index(HttpServletRequest request, HttpServletResponse response){
//        return "/dologin";
//    }

}
