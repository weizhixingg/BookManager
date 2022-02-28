package com.BookManager.Li.BookManager.utils;
import java.sql.*;
public class DbUtils {

    public static void main(String[] args) {
        String dbUri ="jdbc:mysql://localhost:3306/book_manager?serverTimezone=UTC";
        String sUser = "root";
        String sPd = "111111";

        try{
            Connection conn = DriverManager.getConnection(dbUri, sUser, sPd);
            System.out.println("已连接");
            Statement smt = conn.createStatement();
            String  sql1  = "create table  if not exists book(id int  primary key auto_increment ,name varchar(256) ,author varchar(256) ,price varchar(256);";
            smt.executeUpdate(sql1);
            String sql_i = "insert into book values(1,'钢铁是如何炼成的' ,'保尔','100$';";
            smt.executeUpdate(sql_i);
            String sql_u = "update book set price = '1000$' where name = '钢铁是如何炼成的'";
            String sql_q = "select * from book;";
            ResultSet res = smt.executeQuery(sql_q);
            while (res.next()){
                int id = res.getInt(1);
                String name = res.getNString("name");
                String author = res.getNString("author");
                String price = res.getNString("price");
                System.out.println("id:"+id +"     name:"+name+ "    author:" +author+"    price"+price);

            }
            String  sql2  = "create table  if not exists ticket(id int  primary key auto_increment ,user_id int(11) ,ticket varchar(1024) ,expired_at datetime;";
            smt.executeUpdate(sql2);
            String  sql3  = "create table  if not exists user(id int  primary key auto_increment ,user_id int(11) ,name varchar(256) ,email varchar(256) ,password varchar(256);";
            smt.executeUpdate(sql3);
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }

}
