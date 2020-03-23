package sample;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        this.init();
    }

    private void init() {
        this.setDefaultCloseOperation(3);
        this.canvas = new DrawingPanel(this);
        this.controlPanel = new ControlPanel(this);
        this.configPanel = new ConfigPanel(this);
        this.add(this.controlPanel, "North");
        this.add(this.canvas, "Center");
        this.add(this.configPanel, "South");
        this.pack();
    }
}
