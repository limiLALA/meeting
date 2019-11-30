package com.mina.homework.meeting.dao;

import com.mina.homework.meeting.model.Meeting;
import com.mina.homework.meeting.model.MeetingRoom;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

//预定会议室
@Component
public class MeetingDao {

    public Meeting insert(Meeting meeting){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO meeting_info(scale,theme,start_time,end_time,booker_id,room_id) VALUES (?,?,?,?,?,?)";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, meeting.getScale());
            ps.setString(2,meeting.getTheme());
            ps.setString(3,meeting.getStart_time());
            ps.setString(4, meeting.getEnd_time());
            ps.setInt(5,meeting.getBooker_id());
            ps.setInt(6,meeting.getRoom_id());
            int row_affected = ps.executeUpdate();
            if (row_affected<=0){
                //fail
                return meeting;
            }else{
                return meeting;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return meeting;
    }
//
//    public Meeting getOne(Meeting meeting){
//        Connection con = null;
//        PreparedStatement ps = null;
//        String sql = "SELECT * FROM meeting_info";
//        ResultSet rs = null;
//        List<Meeting> ret = new LinkedList<>();
//        try {
//            con = DBUtils.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()){
//                Meeting meeting
//                ret.add(new Meeting(
//                        rs.getInt("room_id"),
//                        rs.getInt("booker_id"),
//                        rs.getString("theme"),
//                        rs.getInt("scale"),
//                        rs.getString("book_time"),
//                        rs.getString("start_time"),
//                        rs.getString("end_time")
//                ));
//
//            }
//            return ret;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtils.close(ps);
//            DBUtils.close(con);
//        }
//        return ret;
//    }

    public Meeting getById(int meeting_id){
        return getMeetingById(meeting_id);
    }

    public Meeting getMeetingById(int id){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM meeting_info where id = ?";
        ResultSet rs = null;
        Meeting ret = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){

                Meeting meeting = new Meeting(
                        rs.getInt("room_id"),
                        rs.getInt("booker_id"),
                        rs.getString("theme"),
                        rs.getInt("scale"),
                        rs.getString("book_time"),
                        rs.getString("start_time"),
                        rs.getString("end_time")
                );
                meeting.setId(rs.getInt("id"));
                return meeting;

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

    public List<Meeting> getAll(){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM meeting_info";
        ResultSet rs = null;
        List<Meeting> ret = new LinkedList<>();
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Meeting meeting = new Meeting(
                        rs.getInt("room_id"),
                        rs.getInt("booker_id"),
                        rs.getString("theme"),
                        rs.getInt("scale"),
                        rs.getString("book_time"),
                        rs.getString("start_time"),
                        rs.getString("end_time")
                );
                meeting.setId(rs.getInt("id"));
                ret.add(meeting);

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

    public Meeting change(Meeting meeting) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE meeting_info set scale=?, theme=?, start_time=?, end_time=?, room_id=? WHERE id=?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, meeting.getScale());
            ps.setString(2,meeting.getTheme());
            ps.setString(3,meeting.getStart_time());
            ps.setString(4, meeting.getEnd_time());
            ps.setInt(5,meeting.getRoom_id());
            ps.setInt(6, meeting.getId());

            int row_affected = ps.executeUpdate();
            if (row_affected<=0){
                //fail
                return meeting;
            }else{
                return meeting;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return meeting;
    }

    public Meeting deleteById(int meeting_id) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "Delete from meeting_info where id = ?";
        Meeting to_delete = getMeetingById(meeting_id);
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, meeting_id);
            int row_affected = ps.executeUpdate();
            if (row_affected<=0){
                //fail
                System.out.println("MeetingDao.deleteById(): fail");
            }else{
                System.out.println("MeetingDao.deleteById(): success");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return to_delete;
    }
}
