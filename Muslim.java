package com.Evan;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Muslim extends JFrame implements ActionListener {

    JButton Submit = new JButton();
    JTextField Input = new JTextField();
    JLabel Salam = new JLabel();
    JLabel Error = new JLabel();
    Muslim()
    {
        this.setTitle("MuslimBook");
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //Label----------------Work//
        Salam.setText("MuslimBook");
        Salam.setFont(new Font("Agency Fb", Font.BOLD, 20));
        Salam.setBounds(190,50,200,50);
        this.add(Salam);

        //TextField------------Work//
        Input.setFont(new Font("Agency Fb", Font.BOLD, 20));
        Input.setBounds(130,200,200,50);
        this.add(Input);

        //Button---------------Work//
        Submit.setText("OK");
        Submit.setFocusable(false);
        Submit.setFont(new Font("Agency FB",Font.BOLD,15));
        Submit.setBounds(185,270,80,30);
        Submit.addActionListener(this);
        this.add(Submit);

        //Error Message //
        Error.setText("Wrong, Please try again");
        Error.setBounds(150,300,400,50);
        Error.setFont(new Font("",Font.BOLD, 15));
        this.add(Error);
        Error.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == Submit) {
            String Key = Input.getText(); // TO check it we need to take a String variable then
            if(Key.equals("Islam"))
            {
                this.dispose();
                new LoginPage();
            }
            else{
                Input.setText("");
                Error.setVisible(true);
            }
        }
    }
}
