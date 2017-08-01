package zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private Color [] colors = {Color.LIGHT_GRAY, Color.CYAN,Color.ORANGE, Color.YELLOW, Color.GREEN, Color.MAGENTA};
    private int i=0;
    private  Color kolor=null;

    public GUI(){
        JFrame frame = new JFrame("Zadanie 1");
        frame.setPreferredSize(new Dimension(400,150));

        // czy przycisk ma mieć nazwę
        JButton button1 = new JButton("Kliknij aby zimienić kolor tła przycisku");

        // czy przycisk ma byc na całą stronę
        frame.add(button1);

        button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            button1.setBackground(getColors());
        }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Color getColors() {
        kolor = colors[i];
        i++;
        if (i == colors.length) {
            i = 0;
        }
        return kolor;
    }
}
