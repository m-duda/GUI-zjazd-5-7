package zad3;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    public Window(){
        setTitle("Zadanie 3");

        JTextArea text = new JTextArea();
            text.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
            text.setForeground(Color.YELLOW);
            text.setBackground(Color.BLUE);

        JScrollPane scrollPane = new JScrollPane(text);
            scrollPane.setPreferredSize(new Dimension(500,300));
            scrollPane.setVisible(true);

        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
  }
}
