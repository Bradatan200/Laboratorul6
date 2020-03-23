package sample;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("load");
    JButton RestBtn = new JButton("Rest");
    JButton ExitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        this.init();
    }

    private void init() {
        this.setLayout(new GridLayout(1, 4));
        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, "North");
        buttonPanel.add(this.saveBtn);
        buttonPanel.add(this.loadBtn);
        buttonPanel.add(this.RestBtn);
        buttonPanel.add(this.ExitBtn);
        this.saveBtn.addActionListener(this::save);
        this.RestBtn.addActionListener(this::reset);
        this.loadBtn.addActionListener(this::load);
        this.ExitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(this.frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException var3) {
            System.err.println(var3);
        }

    }

    private void load(ActionEvent e) {
        try {
            ImageIO.read(new File("d:/test.png"));
        } catch (IOException var3) {
            System.err.println(var3);
        }

    }

    private void reset(ActionEvent e) {
        this.frame.setVisible(false);
        (new MainFrame()).setVisible(true);
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }
}
