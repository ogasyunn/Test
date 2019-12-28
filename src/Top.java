import javax.swing.JLabel;
import javax.swing.JOptionPane;
class Top {
    Window wd = new Window();
    public void window() {
        JLabel m = new JLabel();
        JOptionPane.showMessageDialog(m, "start game?");
        wd.window();
    }
}