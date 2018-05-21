package com.example.hb.test;

import com.example.common.util.CalcUtil;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class insertCombin {

    private String url = "jdbc:mysql://127.0.0.1:3306/lottery";
    private String user = "root";
    private String password = "root";

    @Test
    public void Test() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rt = null;
        List<int[]> list = CalcUtil.calcAllCombination();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            StringBuffer sql = new StringBuffer("INSERT INTO lottery_combination(blue1,blue2,blue3,blue4,blue5,blue6,red) VALUES ");
            conn.setAutoCommit(false);
            Long startTime = System.currentTimeMillis();

            System.out.println("数据大小：" + list.size());

            int num = 0;
            for (int i = 0; i < list.size(); i++) {
                num++;
                int[] x = list.get(i);
                if (i != 0) {
                    sql.append(",");
                }
                sql.append("(" + x[0] + "," + x[1] + "," + x[2] + "," + x[3] + "," + x[4] + "," + x[5] + "," + x[6] + ")");
                if (num == 50000) {
                    pstm = conn.prepareStatement(sql.toString().replace("VALUES ,", "VALUES"));
                    pstm.executeUpdate();
                    conn.commit();
                    sql.setLength(0);
                    sql.append("INSERT INTO lottery_combination(blue1,blue2,blue3,blue4,blue5,blue6,red) VALUES ");
                    num = 0;
                }
            }
            pstm = conn.prepareStatement(sql.toString().replace("VALUES ,", "VALUES"));
            pstm.executeUpdate();
            conn.commit();
            Long endTime = System.currentTimeMillis();
            System.out.println("OK,用时：" + (endTime - startTime) / 1000 + "秒");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
