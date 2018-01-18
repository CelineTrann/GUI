package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 84674tra on 16/01/2018.
 */
public class Choose extends JFrame{

    final int F_WIDTH   =  300;
    final int F_HEIGHT  =  150;

    LinearVolume linearVolume = new LinearVolume();
    AreaFunction areaFunction = new AreaFunction();

    public Choose(){

        super("Choose");

        setSize(F_WIDTH,F_HEIGHT);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Here is our heading
        JLabel heading = new JLabel("Calculating Area and Volume");
        heading.setFont( new Font("Arial", Font.BOLD, 14));

        // Here is our prompt
        JLabel choose = new JLabel("What do you want to calculate");

        String areaOption[] = {"Volume", "Linear Area", "Quadratic Area", "Sine Area", "Cosine Area"};
        JComboBox comboBox = new JComboBox(areaOption);

        JButton show = new JButton("Choose!");

        setLayout(new FlowLayout());

        // Add components to the JFrame
        add(heading);
        add(choose);
        add(comboBox);
        add(show);


        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();

                switch (selected){
                    case "Volume":
                        linearVolume.setVisible(true);
                        dispose();
                        break;

                    case "Linear Area":
                        areaFunction.Area("Linear");
                        areaFunction.setVisible(true);
                        dispose();
                        break;

                    case "Quadratic Area":
                        break;

                    case "Sine Area":
                        break;

                    case "Cosine Area":
                        break;
                }

               dispose();
            }
        });



    }





}
