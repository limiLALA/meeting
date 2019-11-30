package com.mina.homework.meeting.service;

import com.mina.homework.meeting.dao.MeetingDao;
import com.mina.homework.meeting.dao.MeetingRoomDao;
import com.mina.homework.meeting.model.Meeting;
import com.mina.homework.meeting.model.MeetingRoom;
import com.mina.homework.meeting.model.ViewObject;
import org.apache.coyote.http11.upgrade.AprServletInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

//预定会议室
@Service
public class MeetingService {

    @Autowired
    MeetingDao meetingDao;

    public List<Meeting> getAll() {
        return meetingDao.getAll();
    }

//    public List<ViewObject> getAll1() {
//        List<Meeting> listMeeting = meetingDao.getAll();
//        List<ViewObject> ret = new LinkedList<>();
//        for (Meeting meeting : listMeeting) {
//            int booker_id = meeting.getBooker_id();
//
//            String booker_name = userService.getName(booker_id);
//            String book_time = meeting.getBook_time();
//            String theme = meeting.getTheme();
//            String start_time = meeting.getStart_time();
//            String end_time = meeting.getEnd_time();
//            int id = meeting.getId();
//
//            ViewObject vo = new ViewObject();
//            vo.set("id", id);
//            vo.set("booker_name", booker_name);
//            vo.set("book_time", book_time);
//            vo.set("theme", theme);
//            vo.set("start_time", start_time);
//            vo.set("end_time", end_time);
//            ret.add(vo);
//        }
//
//        return ret;
//    }


    public Meeting insert(int scale,
                          String theme,
                          String start_time,
                          String end_time,
                          int booker_id,
                          int room_id) {
        Meeting meeting = new Meeting();
        meeting.setScale(scale);
        meeting.setStart_time(start_time);
        meeting.setEnd_time(end_time);
        meeting.setTheme(theme);
        meeting.setBooker_id(booker_id);
        meeting.setRoom_id(room_id);

        return meetingDao.insert(meeting);
    }


    public ViewObject change(int meeting_id, int scale, String theme, String start_time, String end_time) {
        Meeting meeting = new Meeting();
        meeting.setId(meeting_id);
        meeting.setScale(scale);
        meeting.setStart_time(start_time);
        meeting.setEnd_time(end_time);
        meeting.setTheme(theme);

        meeting = meetingDao.change(meeting);
        ViewObject vo = new ViewObject();
        vo.set("meeting", meeting);
        return vo;
    }

    public Meeting getMeetingById() {
        return null;
    }

    public Meeting getById(int meeting_id) {
        return this.meetingDao.getMeetingById(meeting_id);
    }

    public Meeting deleteById(int meeting_id) {
        return this.meetingDao.deleteById(meeting_id);
    }
}
