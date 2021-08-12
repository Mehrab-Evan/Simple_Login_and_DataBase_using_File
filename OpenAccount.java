package com.Evan;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class OpenAccount extends JFrame implements ActionListener {

    //Declaration of All JLabel--------------------------
    JLabel FirstName = new JLabel();
    JLabel LastName = new JLabel();
    JLabel UserName = new JLabel();
    JLabel PassWord = new JLabel();
    JLabel ConfirmPassword = new JLabel();
    JLabel ErrorOfSamePassWord = new JLabel();

    //Declaration of All TextFields----------------------
    JTextField FN = new JTextField();
    JTextField LN = new JTextField();
    JTextField UN = new JTextField();
    JPasswordField PW = new JPasswordField();
    JPasswordField CP = new JPasswordField();

    JButton Confirm = new JButton();
    JButton Back = new JButton();


    OpenAccount()
    {
        //FRAME
        this.setTitle("Open MuslimBook Account");
        this.setSize(500,900);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //========LABELS=============================================//
        //FirstName---------------------------------------
        FirstName.setBounds(50,100,100,30);
        FirstName.setText("First Name");
        this.add(FirstName);

        //LastName----------------------------------------
        LastName.setBounds(50, 150,100,30);
        LastName.setText("Last Name");
        this.add(LastName);

        //UserName----------------------------------------
        UserName.setBounds(50,200,100,30);
        UserName.setText("UserName");
        this.add(UserName);

        //Password---------------------------------------
        PassWord.setBounds(50,250,100,30);
        PassWord.setText("Password");
        this.add(PassWord);

        //ConfirmPassword--------------------------------
        ConfirmPassword.setBounds(50,300,100,30);
        ConfirmPassword.setText("Confirm");
        this.add(ConfirmPassword);

        //Error--------------------------------------------
        ErrorOfSamePassWord.setBounds(50,400,500,300);
        ErrorOfSamePassWord.setText("Password Must be same");
        this.add(ErrorOfSamePassWord);
        ErrorOfSamePassWord.setVisible(false);

        //============LABELFINISHED=================DESIGN==================//

        //============TXTFIELD START==============DESIGN======================//
        FN.setBounds(150,100,200,30);
        this.add(FN);

        LN.setBounds(150,150,200,30);
        this.add(LN);

        UN.setBounds(150,200,200,30);
        this.add(UN);

        PW.setBounds(150,250,200,30);
        this.add(PW);

        CP.setBounds(150,300,200,30);
        this.add(CP);
        //===============TXTFIELD DONE ===================================//

        //============BUTTON=============================================//
        Confirm.setText("Confirm");
        Confirm.setBounds(100,700,80,40);
        Confirm.addActionListener(this);
        this.add(Confirm);

        Back.setText("Back");
        Back.setBounds(250,700,80,40);
        Back.addActionListener(this);
        this.add(Back);
        //==============Button Design End===============================//
    }

    @Override
    public void actionPerformed(ActionEvent Pressed) {
        String FName = FN.getText();
        String LName = LN.getText();
        String UName = UN.getText();
        String PWord = PW.getText();
        String CPass = CP.getText();

        if(Pressed.getSource() == Back)
        {
            new LoginPage();
            this.dispose();
        }
        else if(Pressed.getSource() == Confirm)
        {
            try {
                FileWriter DB = new FileWriter("Info.txt",true);
                if(PWord.compareTo(CPass) != 0)
                {
                    new OpenAccount2();
                    this.dispose();
                }
                else
                {
                    DB.append(""+FName+" "+LName+" "+UName+" "+PWord+" "+CPass+"\n");
                    DB.close();
                    new LoginPage();
                    this.dispose();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
