package com.company;

import java.util.Scanner;

public class FirstPage extends Login {
    static Scanner input = new Scanner(System.in);
    public static void FirstPageDisplay()
    {
        System.out.println("1.Create Account\n2.Login");
        int ch=input.nextInt();
        switch(ch)
        {
            case 1:
               Details();
               break;
            case 2:
                LoginPage();
                break;
            default:
            {
                System.out.println("Incorrect choice");
                System.exit(0);
            }
        }
    }
}
