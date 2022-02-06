package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class FirstPage extends Login {
    static Scanner input = new Scanner(System.in);
    public static void FirstPageDisplay() throws SQLException {
        System.out.println("1.Create Account\n2.Login\n3.Change Password");
        int ch=input.nextInt();
        switch (ch) {
            case 1 -> Details();
            case 2 -> LoginPage();
            case 3 -> change();
            default -> {
                System.out.println("Incorrect choice");
                System.exit(0);
            }
        }
    }
}
