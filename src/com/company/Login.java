package com.company;

import jdk.internal.icu.impl.CharacterIteratorWrapper;

import java.sql.*;
import java.util.Scanner;

public class Login extends BasicDetails {
        public static void LoginPage(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking", "root", "12345678");
        Statement statement = connection.createStatement();
        ResultSet resultSet2;
        Scanner in = new Scanner(System.in);
        int count = 0;
        boolean t;
        do {
            System.out.println("Enter Your Account ID");
            String ACC_ID = in.nextLine();
            System.out.println("Enter Your Password");
            String Pass = in.nextLine();
            count++;
            String abc = "select*from user_info where AccountID='" + ACC_ID + "' AND Password='" + Pass + "'";//It checks in the database
            resultSet2 = statement.executeQuery(abc);
            t = !(resultSet2.next());
            if (t) {  //if the input is not found in the database
                System.out.println("Incorrect AccountID or Password\nYou have " + (3 - count) + " chances remained");
                if (count > 2)
                    System.exit(0);
            }
        }
        while (t);
        System.out.println("Logged in Successfully!");
    }catch(ClassNotFoundException e) {
        e.printStackTrace();
    } catch(SQLException e) {
        e.printStackTrace();
    }


}}

