package com.mina.homework.meeting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {

        return "hello";
    }

    @RequestMapping("/get_list")
    public List<String> getList(){
        List<String> ret = new LinkedList<>();
        ret.add("asd");
        ret.add("mina");
        return ret;
    }

    @RequestMapping("/get_map")
    public HashMap<String, String> getMap(){
        HashMap<String, String> ret = new HashMap<>();
        ret.put("mina", "baka");

        return ret;
    }
}