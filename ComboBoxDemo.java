//Written By Brian Pedigo Sep 2014
package comboboxdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ComboBoxDemo {

    //creating Global Variable could cast these as static
    JComboBox month;
    JComboBox day;
    JComboBox year;
    JLabel jlab;
    JButton calculate;

    String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Agu", "Sep", "Oct", "Nov", "Dec"};
    String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String years[] = {"2010", "2011", "2012", "2013", "2014", "2015"};
    int intmonth, intday, intyear;
    String item4;

    Calendar cal = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();

    ComboBoxDemo() {

        //Creating New JFrame
        JFrame jfrm = new JFrame("Day Calculator");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220, 240);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding 3 JCombo, 1 Lable, 1 Button
        month = new JComboBox(months);
        day = new JComboBox(days);
        year = new JComboBox(years);
        jlab = new JLabel();
        calculate = new JButton("Calculate");

        month.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                intmonth = month.getSelectedIndex();
            }
        });

        day.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                item4 = (String) day.getSelectedItem();
                intday = Integer.parseInt(item4);
            }
        });

        year.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                intyear = year.getSelectedIndex();
                intyear += 2010;
            }
        });

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //cal2.set(year,month,days);
                cal2.set(intyear, intmonth, intday);

                int dbetween = daysBetween(cal.getTime(), cal2.getTime());
                jlab.setText("The number of days ago is " + dbetween);

            }
        });

        month.setSelectedIndex(0);
        day.setSelectedIndex(0);
        year.setSelectedIndex(0);
        jfrm.add(month);
        jfrm.add(day);
        jfrm.add(year);
        jfrm.add(calculate);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    static int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxDemo();
            }
        });
    }

}
