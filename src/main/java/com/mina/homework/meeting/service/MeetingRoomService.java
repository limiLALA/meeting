package com.mina.homework.meeting.service;

import com.mina.homework.meeting.dao.MeetingRoomDao;
import com.mina.homework.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomDao meetingRoomDao;

    public List<MeetingRoom> getAll(){
        return meetingRoomDao.getAll();
    }

    public MeetingRoom getById(int id){
        return meetingRoomDao.getById(id);
    }

    public MeetingRoom add(String rno, int capacity, int status) {
        MeetingRoom meetingRoom = new MeetingRoom(rno,capacity,status);
        meetingRoom = meetingRoomDao.add(meetingRoom);
        return meetingRoom;
    }

    public MeetingRoom delete(int id) {
        MeetingRoom meetingRoom = meetingRoomDao.delete(id);
        return meetingRoom;
    }

    public MeetingRoom change(int id, String rno, int capacity, int status) {
        MeetingRoom meetingRoom = meetingRoomDao.change(id,rno,capacity,status);
        return meetingRoom;
    }
}
