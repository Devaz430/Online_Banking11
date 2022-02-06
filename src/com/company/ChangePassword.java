package com.company;

import java.sql.*;
import java.util.Scanner;

public class ChangePassword {
    public static void change() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking", "root", "12345678");
            Statement statement = connection.createStatement();
            ResultSet resultSet3,resultSet4;
            Scanner inp = new Scanner(System.in);
            int count = 0;
            boolean s;
            String ACC;
            String abc;
            do {
                System.out.println("Enter Your Account ID");
                ACC = inp.nextLine();
                System.out.println("Enter Your Password");
                String Passw = inp.nextLine();
                count++;
                abc = new StringBuilder().append("select*from user_info where AccountID='").append(ACC).append("' AND Password='").append(Passw).append("'").toString();
                resultSet3 = statement.executeQuery(abc);
                s = !(resultSet3.next());
                if (s) {  //if the input is not found in the database
                    System.out.println("Incorrect AccountID or Password\nYou have " + (3 - count) + " chances remained");
                    if (count > 2)
                        System.exit(0);
                }
            }
            while (s);
            System.out.println("Logged in Successfully!");
            int cnt = 0;
            String Pass1, Pass2;
            do {
                System.out.println("Enter the new password");
                Pass1 = inp.nextLine();

                System.out.println("Re-enter the new password");
                Pass2 = inp.nextLine();

                cnt++;
                if (!Pass1.equals(Pass2)) {
                    System.out.println("You have inserted different Password");
                    if (cnt > 2) {
                        System.out.println("Too many trial!");
                        System.exit(0);
                    }
                }
            }
            while (!Pass1.equals(Pass2));
            abc = new StringBuilder().append("select*from user_info where Password='").append(Pass1).append("'").toString();
            resultSet4 = statement.executeQuery(abc);
            if(resultSet4.next())
            {
                System.out.println("New Password and old password are the same!");
                System.exit(0);
            }
            statement.executeUpdate(new StringBuilder().append("update user_info set Password='").append(Pass1).append("'where AccountID='").append(ACC).append("' ").toString());//it updates the Password
            System.out.println("Password changed successfully!!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

