package zad2;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(String select){
        JFrame frame = new JFrame("Zadanie 4");

        switch (select) {
            case "A":
                frame.setLayout(new BorderLayout());
                break;
            case "B":
                frame.setLayout(new FlowLayout());
                break;
            case "C":
                frame.setLayout(new FlowLayout(FlowLayout.LEFT));
                break;
            case "D":
                frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
                break;
            case "E":
                frame.setLayout(new GridLayout(1,0));
                break;
            case "F":
                frame.setLayout(new GridLayout(0,1));
                break;
            case "G":
                frame.setLayout(new GridLayout(3,2));
                break;
        }

        JButton button1 = new JButton("Przycisk 1");
        JButton button2 = new JButton("P2");
        JButton button3 = new JButton("Większy przycisk numer 3");
        JButton button4 = new JButton("Przycisk 4");
        JButton button5 = new JButton("P5");

        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.WEST);
        frame.add(button3, BorderLayout.CENTER);
        frame.add(button4, BorderLayout.EAST);
        frame.add(button5, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
  }
}
