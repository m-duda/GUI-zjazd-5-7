package zad2;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {

    private String pathFile=".";
    private String pathTitle = "bez tytułu";
    private String textArea;
    private Color [] colors = {Color.BLUE,Color.YELLOW, Color.ORANGE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN};
    private String [] colorsName = {"Blue", "Yellow", "Orange", "Red", "White", "Black", "Green"};
    private String [] adresyNazwa = {"Praca","Szkoła","Dom"};
    private String [] adresyTekst = {"adres pracy","adres szkoły","adres domowy"};
    private char [] adresyMnemo = {'p','s','d'};
    private String [] adresyAccel = {"control shift P","control shift S","control shift D"};

    public GUI(){
        JFrame frame = new JFrame("Prosty edytor - "+pathTitle);
        JTextArea text = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(text);
//===== Menu File ============================================================================
        JMenu fileMenu = new JMenu("File");
        JMenuItem miOpen = menuItemMetoda("Open", 'o', "control O" );
        fileMenu.add(miOpen);
        JMenuItem miSave = menuItemMetoda("Save", 's', "control S" );
        fileMenu.add(miSave);
        JMenuItem miSaveAs = menuItemMetoda("Save as ...", 'a', "control A" );
        fileMenu.add(miSaveAs);
        JSeparator separator = new JSeparator(0);
        separator.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        separator.setForeground(Color.red);
        separator.setPreferredSize(new Dimension(fileMenu.getWidth(),5));
        fileMenu.add(separator);
        JMenuItem miExit = menuItemMetoda("Exit", 'x', "control X");
        fileMenu.add(miExit);
//===== Menu Edit =======================================================
        JMenu editMenu = new JMenu("Edit");
        JMenu editAdresyMenu = new JMenu("Adresy");
        editAdresyMenu.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        editMenu.add(editAdresyMenu);
        for (int i=0; i<adresyNazwa.length; i++) {
            int j=i;
            JMenuItem adresy =menuItemMetoda(adresyNazwa[i], adresyMnemo[i], adresyAccel[i]);
            adresy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.insert(adresyTekst[j], text.getCaretPosition());
                }
            });
            editAdresyMenu.add(adresy);
        }
//===== Menu Opcje ===========================================================
        JMenu optionsMenu = new JMenu("Options");
        JMenu optionForegroundMenu = new JMenu("Foreground");
        for (int i=0; i<colors.length; i++){
            int j = i;
            JMenuItem miColor = new JMenuItem(colorsName[j], new MyIcon(colors[i]));
            miColor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setForeground(colors[j]);
                }
            });
            miColor.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            optionForegroundMenu.add(miColor);
        }
        optionForegroundMenu.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        optionsMenu.add(optionForegroundMenu);

        JMenu optionBackgroundMenu = new JMenu("Background");
        for (int i=0; i<colors.length; i++){
            int j = i;
            JMenuItem miColor = new JMenuItem(colorsName[j], new MyIcon(colors[i]));
            miColor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setBackground(colors[j]);
                }
            });
            miColor.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            optionBackgroundMenu.add(miColor);
        }
        optionBackgroundMenu.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        optionsMenu.add(optionBackgroundMenu);

        JMenu optionFontMenu = new JMenu("Font size");
        for (int i=4; i<13; i++){
            int j=2*i;
            JMenuItem miFont = new JMenuItem(j+" pts");
            miFont.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setFont(new Font("Dialog", 0,j));
                }
            });
            miFont.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            optionFontMenu.add(miFont);
        }
        optionFontMenu.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        optionsMenu.add(optionFontMenu);
//===== Belka menu =================================================
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(optionsMenu);
        frame.setJMenuBar(menuBar);
//===== Frame ========================================================
        scrollPane.setPreferredSize(new Dimension(500,300));
        scrollPane.setVisible(true);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//===== action listenery dla menu File =============================
        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea = text.getText();
                readfile();
                text.setText(textArea);
                frame.setTitle("Prosty edytor - "+pathTitle);
            }
        });

        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(text);
            }
        });

        miSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAs(text);
                frame.setTitle("Prosty edytor - "+pathTitle);
            }
        });

        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
   }

    private JMenuItem menuItemMetoda(String title, int mnemo, String accelerator) {
        JMenuItem menuItem = new JMenuItem(title, null);
        menuItem.setMnemonic(mnemo);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator));
        menuItem.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        return menuItem;
    }

    private void readfile(){
        JFileChooser fileChooser = new JFileChooser(pathFile);
        fileChooser.setFileFilter(new FileNameExtensionFilter("TEXT","txt"));
        fileChooser.showOpenDialog(new JFrame());
        fileChooser.setDialogTitle("Open");

        if (fileChooser.getSelectedFile().exists()) {
            pathTitle = fileChooser.getSelectedFile().toString();
            pathFile=fileChooser.getCurrentDirectory().toString();

            FileReader fileReader = null;
            try {
                fileReader = new FileReader(fileChooser.getSelectedFile());
                BufferedReader br = new BufferedReader(fileReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();

                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    textArea = sb.toString();
                    br.close();
                } catch (IOException e) {}
            } catch (FileNotFoundException e) {
                System.out.println("Brak pliku");
            }
        }
    }

    private void save(JTextArea text){
        File file = new File(pathTitle);
        if (file.exists()) {
            try {
                FileWriter fw = new FileWriter(pathTitle);
                text.write(fw);
                fw.close();
            } catch (IOException e1) {}
        }
        else {
            saveAs(text);
        }
    }

    private void saveAs(JTextArea text){
        JFileChooser fileChooser = new JFileChooser(pathFile);
        fileChooser.setDialogTitle("Save As");
        fileChooser.showSaveDialog(new JFrame());
        try {
            pathTitle = fileChooser.getSelectedFile().toString();
            pathFile = fileChooser.getCurrentDirectory().toString();
            FileWriter fw = new FileWriter(fileChooser.getSelectedFile());
            text.write(fw);
            fw.close();
        } catch (IOException e1) {}
    }
}
