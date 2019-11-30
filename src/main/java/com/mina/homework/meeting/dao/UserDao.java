package com.mina.homework.meeting.dao;

import com.mina.homework.meeting.model.Account;
import com.mina.homework.meeting.model.Meeting;
import com.mina.homework.meeting.model.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserDao {

//    public int insert(User user) {
//
//        Connection con = null;
//        PreparedStatement ps = null;
//        String sql = "INSERT INTO account(account,password) VALUES (?,?)";
//        try {
//            con = DBUtils.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, account.getAccount());
//            ps.setString(2, account.getPassword());
//            return ps.executeUpdate();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return -1;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return -2;
//        } finally {
//            DBUtils.close(ps);
//            DBUtils.close(con);
//        }
//    }
    public User getUserById(User user){
        Connection con = null;
        PreparedStatement ps = null;


        String sql = "SELECT * FROM user WHERE id=?";
        ResultSet rs = null;
        User ret = new User();
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                ret.setName(rs.getString("name"));
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

}

