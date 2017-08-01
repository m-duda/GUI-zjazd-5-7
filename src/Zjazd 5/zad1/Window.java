package zad1;

import javax.swing.*;

public class Window extends JFrame{

    public Window (){
        setTitle("Zadanie 1");;
        add(new WindowArea(500, 400));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
