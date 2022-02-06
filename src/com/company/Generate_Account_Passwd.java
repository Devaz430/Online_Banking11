package com.company;
import java.sql.*;
import java.util.Random;
public class Generate_Account_Passwd {
    public static String DisplayAccount() {
        String str = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking", "root", "12345678");
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            do {
                String AlphabeticalString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        + "abcdefghijklmnopqrstuvxyz"
                        + "@#!%&";


                StringBuilder sb = new StringBuilder(8);

                for (int i = 0; i < 8; i++) {

                    int index
                            = (int) (AlphabeticalString.length() * Math.random());
                    sb.append(AlphabeticalString.charAt(index));
                }
                str = new String(sb.toString());
                String abc = "select*from user_info where AccountID='" + str + "' ";//It checks in the database
                resultSet = statement.executeQuery(abc);
                //System.out.println("The Random Account: "+str);
            } while (resultSet.next());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }


    public static int DisplayPasswd(){
        Random rand = new Random();

        int passwd = rand.nextInt(10000);
        //System.out.println("Random Password: "+passwd);
        return passwd;
    }


}

