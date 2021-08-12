package com.Evan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Profile extends JFrame implements ActionListener {

    //Declaration of All JLabel--------------------------
    JLabel FirstName = new JLabel();
    JLabel LastName = new JLabel();
    JLabel UserName = new JLabel();
    JLabel PassWord = new JLabel();
    JLabel ConfirmPassword = new JLabel();
    JLabel ErrorOfSamePassWord = new JLabel();

    //Declaration of All JLABEL FROM FILES----------------------
    JLabel FN = new JLabel();
    JLabel LN = new JLabel();
    JLabel UN = new JLabel();
    JLabel PW = new JLabel();
    JLabel CP = new JLabel();
    JLabel Welcome = new JLabel();

    JButton Confirm = new JButton();
    JButton Back = new JButton();


    Profile() throws FileNotFoundException {
        //FRAME
        this.setTitle("Open MuslimBook Account");
        this.setSize(500, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //========LABELS=============================================//
        Welcome.setText("Welcome");
        Welcome.setBounds(50,50,100,30);
        this.add(Welcome);

        //FirstName---------------------------------------
        FirstName.setBounds(50, 100, 100, 30);
        FirstName.setText("First Name");
        this.add(FirstName);

        //LastName----------------------------------------
        LastName.setBounds(50, 150, 100, 30);
        LastName.setText("Last Name");
        this.add(LastName);

        //UserName----------------------------------------
        UserName.setBounds(50, 200, 100, 30);
        UserName.setText("UserName");
        this.add(UserName);


        //============LABELFINISHED=================DESIGN==================//

        //Read From File;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        File Show = new File("E:/JavaIntelligi/LogIn1/Profile.txt");
        Scanner input = new Scanner(Show);
        while (input.hasNext())
        {
            String First_Name = input.next();
            String Last_Name = input.next();
            String User_Name = input.next();
            FN.setText(First_Name);
            LN.setText(Last_Name);
            UN.setText(User_Name);
        }
        //============TXTFIELD START==============DESIGN======================//
        FN.setBounds(150, 100, 200, 30);
        this.add(FN);

        LN.setBounds(150, 150, 200, 30);
        this.add(LN);

        UN.setBounds(150, 200, 200, 30);
        this.add(UN);

        //===============TXTFIELD DONE ===================================//

        //============BUTTON=============================================//
        /*Confirm.setText("Confirm");
        Confirm.setBounds(100, 700, 80, 40);
        Confirm.addActionListener(this);
        this.add(Confirm);*/

        Back.setText("Back");
        Back.setBounds(250, 700, 80, 40);
        Back.addActionListener(this);
        this.add(Back);
        //==============Button Design End===============================//
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == Back)
        {
            new LoginPage();
            this.dispose();
        }
    }
}