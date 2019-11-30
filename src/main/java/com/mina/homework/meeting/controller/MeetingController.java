package com.mina.homework.meeting.controller;

import com.mina.homework.meeting.Utils;
import com.mina.homework.meeting.model.Meeting;
import com.mina.homework.meeting.model.MeetingRoom;
import com.mina.homework.meeting.model.User;
import com.mina.homework.meeting.model.ViewObject;
import com.mina.homework.meeting.service.MeetingRoomService;
import com.mina.homework.meeting.service.MeetingService;
import com.mina.homework.meeting.service.UserService;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.tomcat.jni.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.View;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

//预定会议室
@Controller()
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        List<Meeting> listMeeting = meetingService.getAll();
        List<ViewObject> vos = new LinkedList<>();
        for (Meeting meeting: listMeeting) {
            int booker_id = meeting.getBooker_id();
            String user_name = userService.getName(booker_id);
//            User user = userService.getUser(booker_id);
//            vo.set("user", user);
            ViewObject vo = new ViewObject();
            vo.set("meeting", meeting);
            vo.set("user_name", user_name);
            vos.add(vo);
        }
//        List<ViewObject> listMeeting = meetingService.getAll();
//        model.addAttribute("listMeeting",listMeeting);
        model.addAttribute("vos", vos);
        return "mymeetings";

    }

//    @RequestMapping(path = {"/meeting/get_all"}, method = {RequestMethod.GET, RequestMethod.POST})
//    public String getAll(Model model){
//        return "mymeetings";
//    }

// http://hostname:port/do?a=22
    //跳转meeting详情页
    @RequestMapping(path = {"/meeting_details/{meeting_id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String meetingDetails(
            @PathVariable("meeting_id") int meeting_id,
            Model model){

        Meeting meeting = meetingService.getById(meeting_id);
        User user = userService.getById(meeting.getBooker_id());
        List<MeetingRoom> listMeetingRoom = meetingRoomService.getAll();
        ViewObject vo = new ViewObject();
        vo.set("meeting", meeting);
        vo.set("user", user);
        vo.set("listMeetingRoom", listMeetingRoom);
        model.addAttribute("vos", vo);
        return "meetingdetails";
    }

    @RequestMapping(path = {"/do_change_meeting/{meeting_id}"}, method = {RequestMethod.POST})
    public String do_change_meeting(
            @PathVariable("meeting_id") int meeting_id,
            @RequestParam("scale") int scale,
            @RequestParam("theme") String theme,
            @RequestParam("start_time") String start_time,
            @RequestParam("end_time") String end_time,
            @RequestParam("room_id") int room_id,
        Model model){
        System.out.println("room_id:"+room_id);
        ViewObject vo = meetingService.change(meeting_id,scale,theme,start_time,end_time,room_id);
        model.addAttribute("vos",vo);
        return  "redirect:/meeting/index";
    }

    @Autowired
    MeetingRoomService meetingRoomService;

    //跳转到添加meeting页面
    @RequestMapping(path = {"/book_meeting"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String bookMeeting(Model model){
        List<MeetingRoom> listMeetingRoom = meetingRoomService.getAll();
        ViewObject vo = new ViewObject();
        vo.set("listMeetingRoom",listMeetingRoom);
        model.addAttribute("vo",vo);
        return "bookmeeting";
    }

    // 具体添加meeting信息
    @RequestMapping(path = {"/do_book_meeting"}, method = {RequestMethod.POST})
    public String doBookMeeting(
            @RequestParam("scale") int scale,
            @RequestParam("theme") String theme,
            @RequestParam("start_time") String start_time,
            @RequestParam("end_time") String end_time,
            @RequestParam("room_id") int room_id,
            Model model) {
        int booker_id = 1; // mina
        meetingService.insert(scale,theme,start_time,end_time,booker_id,room_id);
        return "redirect:/meeting/index";
    }

    //具体删除meeting记录
    @RequestMapping(path = {"/do_delete_meeting/{meeting_id}"}, method = {RequestMethod.GET})
    public String doDeleteMeeting(@PathVariable("meeting_id") int meeting_id, Model mode){
        Meeting to_delete = meetingService.deleteById(meeting_id);

        return "redirect:/meeting/index";
    }

}