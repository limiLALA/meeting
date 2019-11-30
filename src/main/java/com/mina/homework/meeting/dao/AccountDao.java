package com.mina.homework.meeting.dao;

import com.mina.homework.meeting.model.Account;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountDao {

    public int insert(Account account) {

        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO account(account,password) VALUES (?,?)";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, account.getAccount());
            ps.setString(2, account.getPassword());
            return ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -2;
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
    }

    public int reg(Account account) {
        return this.insert(account);
    }

    public boolean login(Account account) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM account WHERE account=? AND password=?";
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, account.getAccount());
            ps.setString(2, account.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return false;
    }
}

