package com.example.hb.test;

import com.example.common.util.CalcUtil;
import org.junit.Test;

import java.sql.*;
import java.util.List;


public class insertCombinThread extends Thread{

    static String url = "jdbc:mysql://127.0.0.1:3306/lottery";
    static String user = "root";
    static String password = "root";
    static String name = "com.mysql.jdbc.Driver";

    static List<int[]> list = CalcUtil.calcAllCombination();

    int start = 0;

    @Override
    public void run() {

        Connection conn = null;
        PreparedStatement  pst = null;
        try{
            Class.forName(name);
            conn = DriverManager.getConnection(url,user,password);
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 开始时间
        Long startTime = System.currentTimeMillis();
        System.out.println("开始了");
        try{
            String prefix = "INSERT INTO lottery_combination(blue1,blue2,blue3,blue4,blue5,blue6,red) VALUES ";
            StringBuffer suffix = new StringBuffer();
             pst =  conn.prepareStatement("");
            int num = 0;
            for (int j = 0; j < start; j++) {
                num++;
                int[] x = list.get(j);
                // 构建SQL后缀
                suffix.append("(" + x[0] + "," + x[1] + "," + x[2] + "," + x[3] + "," + x[4] + "," + x[5] + "," + x[6] + "),");
                if (num == 100000) {
                    String sql = prefix + suffix.substring(0, suffix.length() - 1);
                    pst.addBatch(sql);
                    pst.executeBatch();
                    conn.commit();
                    suffix = new StringBuffer();
                    num = 0;
                }
            }
            if(suffix.length()!=0) {
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                pst.addBatch(sql);
                pst.executeBatch();
                conn.commit();
                suffix = new StringBuffer();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if (pst != null) {
                try {
                    pst.close();
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
        Long endTime = System.currentTimeMillis();
        System.out.println("OK,用时：" + (endTime - startTime) / 1000 + "秒");

    }

    @Test
    public void test(){

        insertCombinThread i1 = new insertCombinThread();
        i1.start = 4500000;
        i1.start();
        insertCombinThread i2 = new insertCombinThread();
        i2.start = 4500000;
        i2.start();
        insertCombinThread i3 = new insertCombinThread();
        i3.start = 4500000;
        i3.start();
        insertCombinThread i4 = new insertCombinThread();
        i4.start = 4221088;
        i4.start();
        while(true){

        }
    }

}
