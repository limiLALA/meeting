package com.mina.homework.meeting.controller;

import com.mina.homework.meeting.model.Meeting;
import com.mina.homework.meeting.model.MeetingRoom;
import com.mina.homework.meeting.model.ViewObject;
import com.mina.homework.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller()
@RequestMapping("/meeting_room")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @RequestMapping(path = {"/get_all"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getAll(Model model){
        List<MeetingRoom> listMeetingRoom = meetingRoomService.getAll();
        model.addAttribute("listMeetingRoom",listMeetingRoom);
        return "meetingrooms";
    }

    //跳转到添加meetingroom页面
    @RequestMapping(path = {"/add_meetingroom"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String addMeetingRoom(Model model){
        return "addmeetingroom";
    }

    // 具体添加meetingroom信息
    @RequestMapping(path = {"/do_add_meetingroom"}, method = {RequestMethod.POST})
    public String doAddMeetingRoom(
            @RequestParam("rno") String rno,
            @RequestParam("capacity") int capacity,
            @RequestParam("status") int status,
            Model model){
        MeetingRoom meetingRoom = meetingRoomService.add(rno,capacity,status);
//        ViewObject vo = new ViewObject();
//        vo.set("meetingRoom", meetingRoom);
//        model.addAttribute("vo",vo);
//        return "redirect:http://"+Utils.getHostName()+"meeting/index";
        return "redirect:/meeting_room/get_all";
    }

    // 删除meetingroom
    @RequestMapping(path = {"/do_delete_meetingroom/{id}"}, method = {RequestMethod.GET})
    public String doDeleteMeetingRoom(
            @PathVariable("id") int id,
            Model model){
        MeetingRoom meetingRoom = meetingRoomService.delete(id);
//        ViewObject vo = new ViewObject();
//        vo.set("meetingRoom", meetingRoom);
//        model.addAttribute("vo",vo);
//        return "redirect:http://"+Utils.getHostName()+"meeting/index";
        return "redirect:/meeting_room/get_all";
    }

    // 跳转到id的详情页
    @RequestMapping(path={"/details/{id}"}, method = {RequestMethod.GET})
    public String details(@PathVariable("id") int id,Model model){
        MeetingRoom meetingRoom = meetingRoomService.getById(id);
        ViewObject vo = new ViewObject();
        vo.set("meetingRoom",meetingRoom);
        model.addAttribute("vo",vo);
        return "roomdetails";
    }

    // 修改meetingroom的信息
    @RequestMapping(path = {"/do_change_meetingroom/{id}"}, method = {RequestMethod.POST})
    public String doChangeMeetingRoom(
            @PathVariable("id") int id,
            @RequestParam("rno") String rno,
            @RequestParam("capacity") int capacity,
            @RequestParam("status") int status){
        MeetingRoom meetingRoom = meetingRoomService.change(id,rno,capacity,status);
        return "redirect:/meeting_room/get_all";
    }
}