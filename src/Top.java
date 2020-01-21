import javax.swing.*;

class Top {
    Window wd = new Window();
    public void window() {
        JLabel m = new JLabel();
        JOptionPane.showMessageDialog(m, "start game?");
        wd.window();
    }
}