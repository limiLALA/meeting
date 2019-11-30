package com.mina.homework.meeting.service;

import com.mina.homework.meeting.dao.MeetingDao;
import com.mina.homework.meeting.model.Meeting;
import com.mina.homework.meeting.model.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//预定会议室
@Service
public class MeetingService {

    @Autowired
    MeetingDao meetingDao;

    public List<Meeting> getAll() {
        return meetingDao.getAll();
    }

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

    public Meeting getById(int meeting_id) {
        return this.meetingDao.getMeetingById(meeting_id);
    }

    public Meeting deleteById(int meeting_id) {
        return this.meetingDao.deleteById(meeting_id);
    }
}
