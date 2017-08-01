package zad2;

import javax.swing.*;
import java.awt.*;

public class MyIcon implements Icon {

    private Color color;
    private int w = 30;

    protected MyIcon(Color c) {
        color = c;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Color ovalColor = g.getColor();
        g.setColor(color);
        w = ((JComponent) c).getHeight();
        int p = w / 4, d = w / 3;
        g.fillOval(x + p, y + p, d, d);
        g.setColor(ovalColor);
    }

    public int getIconWidth() {
        return w;
    }

    public int getIconHeight() {
        return w;
    }
}
