package com.mina.homework.meeting.service;

import com.mina.homework.meeting.dao.MeetingDao;
import com.mina.homework.meeting.dao.UserDao;
import com.mina.homework.meeting.model.Meeting;
import com.mina.homework.meeting.model.MeetingRoom;
import com.mina.homework.meeting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//用户信息
@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public String getName(int id){
        User user = new User();
        user.setId(id);
        user = userDao.getUserById(user);
        return user.getName();

    }

    public User getById(int id){
        return null;
    }
}
