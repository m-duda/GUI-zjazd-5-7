/**
 *
 *  @author Duda Michał S14228
 *
 */

package zad2;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    String litera;
    System.out.println("Wybierz literę aby wybrać odpowiedni układ rozkładu przycisków \n" +
            "A - BorderLayout\n"+
            "B - FlowLayout\n"+
            "C - FlowLayout z wyrównaniem do lewej\n"+
            "D - FlowLayout z wyrównaniem do prawej\n"+
            "E - GridLayout jako jeden wiersz\n"+
            "F - GridLayout jako jedna kolumna\n"+
            "G - GridLayout jako tablica (3, 2)");

    Scanner sc = new Scanner(System.in);
    litera=sc.nextLine();
    if (litera.matches("[A-G]")) {
      Window okno = new Window(litera);
    }
    else {
      System.out.print("Podano niewłaściwą literę");
    }
  }
}
