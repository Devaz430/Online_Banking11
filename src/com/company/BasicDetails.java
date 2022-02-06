package com.company;
import EmailVerify.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BasicDetails extends Generate_Account_Passwd {
    public static String Details() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking", "root", "12345678");
           Statement statement = connection.createStatement();

           Scanner input = new Scanner(System.in);
           ValidateEmail obj = new ValidateEmail();//imported package
           String Fname;

           do {   //stops receiving null values for Fname

               System.out.println("Your First Name:");
               Fname = input.nextLine();
               if(Fname.isEmpty())
                   System.out.println("Null value is not allowed!");
               if(Fname.length()>20) {  //20 is the given size in database
                   throw new TooManyInput("Maximum is 20 characters");
               }
           }
           while (Fname.isEmpty());
           String FNAME = new String(Fname);

           String Lname;
           do {     //stops receiving null values for Lname
               System.out.println("Your Last Name: ");
               Lname = input.nextLine();
               if(Lname.isEmpty())
                   System.out.println("Null value is not allowed!");
               if(Lname.length()>20) {   //20 is the given size in database
                   throw new TooManyInput("Maximum is 20 characters");
               }
           }
           while (Lname.isEmpty());
           String LNAME = new String(Lname);

           String email = new String(obj.cl());//email verification
           System.out.println("Your Account ID: " + DisplayAccount());
           System.out.println("\nSave your account Id and Password to login!!!!");
           String s = new String(DisplayAccount());
           System.out.println("Your Password: " + DisplayPasswd());
           int p = DisplayPasswd();

           System.out.println("Your Phone number: ");
           String phoneno = input.next();

           System.out.println("Your Street Number: ");
           String streetno = input.next();
           statement.executeUpdate("insert into USER_INFO value('" + FNAME + "','" + LNAME + "','" + email + "','" + s + "','" + p + "','" + phoneno + "','" + streetno + "')");
           System.out.println("You have registered successfully!!");
       }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (TooManyInput e) {
           System.out.println("Error! "+e.getMessage());
       }

        return null;
    }


}


