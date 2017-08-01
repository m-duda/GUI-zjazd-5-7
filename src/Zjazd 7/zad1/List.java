package zad1;

import javax.swing.*;


public class List extends JFrame {

  private int minTemp=-70;
  private int maxTemp=60;

  public List() {

    ListModel lm = new AbstractListModel<String>() {

      public int getSize() {
        return maxTemp-minTemp+1;
      }

      public String getElementAt(int index) {
        double temp = (index+minTemp)*9/5+32;
        int tmpF = (int)temp;
        return  (index-70)+" stopni C = "+tmpF+" stopni F";
      }


    };

    JList list = new JList(lm);
    add(new JScrollPane(list));
    setSize(300, 500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}
