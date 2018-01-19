package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 84674tra on 16/01/2018.
 */
public class Choose extends JFrame{

    //initiate variable to set JFrame size
    final int WIDTH   =  300;
    final int HEIGHT  =  200;

    //-----------------------------------------------------------------------------------------------
    //create objects for LinearVolume class and AreaFunction class
    LinearVolume linearVolume = new LinearVolume();
    AreaFunction areaFunction = new AreaFunction();

    //-----------------------------------------------------------------------------------------------
    //initiate Choose JFrame
    public Choose(){

        super("Choose");

        //set size and close operation of frame
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        //-------------------------------------------------------------------
        //set heading of Jframe
        JLabel heading = new JLabel("Calculating Area and Volume");
        heading.setFont( new Font("Arial", Font.BOLD, 14));

        //initiate prompt for JFrame
        JLabel choose = new JLabel("What do you want to calculate");

        //-------------------------------------------------------------------
        //create options for comboBox
        //initiate comboBox
        String areaOption[] = {"Volume", "Linear Area", "Quadratic Area", "Sine Area", "Cosine Area"};
        JComboBox comboBox = new JComboBox(areaOption);

        //initiate comboBox for degrees and radians
        String angleOptions[] = {"N/A", "Radians    ", "Degrees"};
        JComboBox angleBox = new JComboBox(angleOptions);

        //create choose button
        JButton show = new JButton("Choose!");

        //-------------------------------------------------------------------
        //set JFrame layout ot Flow Layout
        setLayout(new FlowLayout());

        // Add components to the JFrame
        add(heading);
        add(choose);
        add(comboBox);
        add(angleBox);
        add(show);

        //-------------------------------------------------------------------
        //initiate actionListener when show button is clicked
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //get what user selected in comboBox
                String selected = (String) comboBox.getSelectedItem();

                //show new Jframe depending on user option in comboBox
                //dispose current JFrame
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
                        areaFunction.Area("Quadratic");
                        areaFunction.setVisible(true);
                        dispose();
                        break;

                    case "Sine Area":
                        //get what user selected in angleBox
                        String sinAngle = (String) angleBox.getSelectedItem();

                        //call for areaFunction Jframe to appear
                        areaFunction.setAngle(sinAngle);
                        areaFunction.Area("Sine");
                        areaFunction.setVisible(true);

                        //get rid of current JFrame
                        dispose();
                        break;

                    case "Cosine Area":
                        //get what user selected in angleBox
                        String cosAngle = (String) angleBox.getSelectedItem();

                        //call for areaFunction Jframe to appear
                        areaFunction.setAngle(cosAngle);
                        areaFunction.Area("Cosine");
                        areaFunction.setVisible(true);

                        //get rid of current JFrame
                        dispose();
                        break;

                }//close switch statement
            }//close actionPerformed method
        });//close actionListener

    }//close choose JFrame
}//close Choose class
