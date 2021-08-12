package com.Evan;


import sun.security.util.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class LoginPage extends JFrame implements ActionListener {
    JLabel Greet = new JLabel();
    JLabel UserName = new JLabel();
    JLabel PassWord = new JLabel();
    JLabel Error = new JLabel();

    JTextField UN = new JTextField();
    JPasswordField PW = new JPasswordField();

    JButton Login = new JButton();
    JButton OpenNew = new JButton();
    JButton Back = new JButton();
    LoginPage()
    {
        this.setTitle("LogIn OR SignUp");
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //Greet--------------------//
        Greet.setText("Assalamu Walaikum WarahMatullah");
        Greet.setFont(new Font("",Font.BOLD,18));
        Greet.setBounds(100,30,500,40);
        this.add(Greet);

        //UserName LABEL-----------//
        UserName.setText("Username");
        UserName.setBounds(100,150,100,40);
        this.add(UserName);

        //PassWord LABEL ---------//
        PassWord.setText("Password");
        PassWord.setBounds(100,200,100,40);
        this.add(PassWord);

        //Error----------------------
        Error.setBounds(50,400,300,20);
        Error.setText("Wrong Name or Password");
        this.add(Error);
        Error.setVisible(false);


        //Username TEXTFIELD-------//
        UN.setBounds(220,155,200,30);
        this.add(UN);

        //PASSWORD FIELD-----------//
        PW.setBounds(220,205,200,30);
        this.add(PW);

        //Login Button---------//
        Login.setBounds(100,300,70,25);
        Login.setText("Login");
        Login.addActionListener(this);
        this.add(Login);

        //OpenNew Account Button-----------//
        OpenNew.setBounds(200,300,75,25);
        OpenNew.setText("SignUp");
        OpenNew.addActionListener(this);
        this.add(OpenNew);

        //OpenNew Account Button-----------//
        Back.setBounds(300,300,75,25);
        Back.setText("Back");
        Back.addActionListener(this);
        this.add(Back);

    }

    @Override
    public void actionPerformed(ActionEvent Pressed) {
        if(Pressed.getSource() == OpenNew)
        {
            new OpenAccount();
            this.dispose();
        }
        else if(Pressed.getSource() == Back)
        {
            new Muslim();
            this.dispose();
        }
        else if(Pressed.getSource() == Login)
        {
            try {
                File Read = new File("E:/JavaIntelligi/LogIn1/info.txt");
                Scanner input = new Scanner(Read);
                Vector<String> First = new Vector();
                Vector<String> Last = new Vector();
                Vector<String> User = new Vector();
                Vector<String> Pass = new Vector();
                Vector<String> Conf = new Vector();
                while(input.hasNext())
                {
                    String take = input.next();
                    String take2 = input.next();
                    String take3 = input.next();
                    String take4 = input.next();
                    String take5 = input.next();
                    First.addElement(take);
                    Last.addElement(take2);
                    User.addElement(take3);
                    Pass.addElement(take4);
                    Conf.addElement(take5);
                }
                for(int i=0; i<First.size(); i++)
                {
                    String x = PW.getText();
                    String f = Pass.get(i); // Vector_name.get(index) --> is the way to access index in vector in java
                    String y = UN.getText();
                    String z = User.get(i);
                    if((x.compareTo(f) == 0) && (y.compareTo(z) == 0))
                    {
                        System.out.println("Welcome");
                        FileWriter ForProfileView = new FileWriter("Profile.txt");
                        ForProfileView.write(""+First.get(i)+" "+Last.get(i)+" "+User.get(i));
                        ForProfileView.close();
                        new Profile();
                        this.dispose();
                        break;
                    }
                    if(i == First.size() - 1)
                    {
                        Error.setVisible(true);
                    }

                    /*System.out.println(PW.getPassword());
                    System.out.println(x);
                    System.out.println(y);*/
                }
            } catch (FileNotFoundException e) {
                Error.setVisible(true);
            } catch (IOException e) {

            }


        }

    }
}

