import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {

    static int width = 3;     //set width

    static int heighet = 4;     //set heighet

    static JButton[] b;

    public void window() {
        
        Window frame = new Window();

        frame.setVisible(true);
    }

    Window() {

        setBounds(100, 50, 700, 600);

        int size = width * heighet;

        b = new JButton[size];

        JPanel p1 = new JPanel();

        JPanel p2 = new JPanel();

        JPanel p3 = new JPanel();

        JPanel p4 = new JPanel();

        JPanel p5 = new JPanel();

        //BevelBorder border2 = new BevelBorder(BevelBorder.RAISED);

        p1.setBackground(Color.LIGHT_GRAY);

        p1.setPreferredSize(new Dimension(0, 50));

        p2.setBackground(Color.BLUE);

        p2.setLayout(new GridLayout(heighet, width, 0, 0));

        p3.setBackground(Color.LIGHT_GRAY);

        p3.setPreferredSize(new Dimension(100, 0));

        p4.setBackground(Color.LIGHT_GRAY);

        p4.setPreferredSize(new Dimension(100, 0));

        p5.setBackground(Color.LIGHT_GRAY);

        p5.setPreferredSize(new Dimension(0, 50));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentpane = getContentPane();

        contentpane.add(p1, BorderLayout.NORTH);

        contentpane.add(p2, BorderLayout.CENTER);

        contentpane.add(p3, BorderLayout.WEST);

        contentpane.add(p4, BorderLayout.EAST);

        contentpane.add(p5, BorderLayout.SOUTH);

        for (int k = 0; k < size; k ++) {

            String i = Integer.toString(k + 1);

            b[k] = new JButton(i);

            b[k].addActionListener(this);

            p2.add(b[k]);
        }

        b[0].setBackground(Color.RED);
    }

    int plasedX = 1;
    int plasedY = 1;

    int counter = 1;

    String table[][] = new String[heighet][width];

    public void actionPerformed(ActionEvent e) {

        //Judger jg = new Judger();

        JLabel l = new JLabel();

        int num = Integer.parseInt(e.getActionCommand());

        int X = (num - 1) % width + 1;

        int Y = (num - 1) / width + 1;

        int label = (Y - 1) * width + X;

        int labeled = (plasedY - 1) * width + plasedX;

        System.out.println(X + ":" + Y);

        System.out.println("label : " + e.getActionCommand());
        
        System.out.println(counter);

        table[plasedY - 1][plasedX - 1] = "X";

        if (table[Y - 1][X - 1] == null && Math.abs(plasedX - X) + Math.abs(plasedY - Y) == 3 && Math.abs(plasedX - X) * Math.abs(plasedY - Y) != 0) {

            b[labeled - 1].setBackground(Color.RED);
            b[label - 1].setBackground(Color.YELLOW);

            plasedX = X;
            plasedY = Y;

            counter ++;
        }
        else {

            JOptionPane.showMessageDialog(l, "cannot put here");

        }

        int a1[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int a2[] = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int k = 0; ; k ++) {
            int judge1 = plasedX + a1[k];
            int judge2 = plasedY + a2[k];
            if (judge1 >=1 && judge1 <= width && judge2 >=1 && judge2 <= heighet) {
                if (table[judge2 - 1][judge1 - 1] != null) {
                    if (counter == width * heighet) {
                        JOptionPane.showMessageDialog(l, "you cleared!!");
                        System.exit(0);
                    }
                }
                else {
                    return;
                }
            }
            if (k == 7) {
                JOptionPane.showMessageDialog(l, "you cannot put anywhere");
                System.exit(0);
            }
        }
    }
}