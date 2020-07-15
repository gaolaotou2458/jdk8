package com.higer.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {

    public void test1() {

    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame("My JFrame");
        JButton jButton = new JButton("My Button");
        /* 旧版本jdk
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 被调用了");
            }
        });
       */
        jButton.addActionListener(event -> System.out.println("Button 被调用了"));
        jframe.add(jButton);
        jframe.pack();
        ;
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
