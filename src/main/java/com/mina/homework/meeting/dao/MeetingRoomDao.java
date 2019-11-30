package com.mina.homework.meeting.dao;

import com.mina.homework.meeting.model.MeetingRoom;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class MeetingRoomDao {
    public List<MeetingRoom> getAll(){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM meeting_room";
        ResultSet rs = null;
        List<MeetingRoom> ret = new LinkedList<>();
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                MeetingRoom meetingRoom = new MeetingRoom(rs.getString("rno"), rs.getInt("capacity"), rs.getInt("status"));
                meetingRoom.setId(rs.getInt("id"));
                ret.add(meetingRoom);
            }
            return ret;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return ret;
    }

    public MeetingRoom getById(int id){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM meeting_room WHERE id=?";
        ResultSet rs = null;
        MeetingRoom ret = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                ret = new MeetingRoom(rs.getString("rno"), rs.getInt("capacity"), rs.getInt("status"));
                ret.setId(rs.getInt("id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return ret;
    }
    public MeetingRoom add(MeetingRoom meetingRoom) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO meeting_room(rno,capacity,status) VALUES (?,?,?)";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, meetingRoom.getRno());
            ps.setInt(2,meetingRoom.getCapacity());
            ps.setInt(3,meetingRoom.getStatus());
            int row_affected = ps.executeUpdate();
            if (row_affected<=0){
                //fail
                return meetingRoom;
            }else{
                return meetingRoom;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return meetingRoom;
    }

    public MeetingRoom delete(int id) {
        MeetingRoom meetingRoom = getById(id);
        if (meetingRoom == null)
            return null;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM meeting_room WHERE id=?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,meetingRoom.getId());
            int row_affected = ps.executeUpdate();
            if (row_affected<=0){
                //fail
                return meetingRoom;
            }else{
                return meetingRoom;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return meetingRoom;
    }

    public MeetingRoom change(int id, String rno, int capacity, int status) {
        MeetingRoom meetingRoom = null;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE meeting_room SET rno=?,capacity=?,status=? WHERE id=?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rno);
            ps.setInt(2,capacity);
            ps.setInt(3,status);
            ps.setInt(4,id);
            int row_affected = ps.executeUpdate();
            if (row_affected<=0){
                //fail
                return meetingRoom;
            }else{
                meetingRoom = new MeetingRoom(rno,capacity,status);
                meetingRoom.setId(id);
                return meetingRoom;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return meetingRoom;
    }
}
