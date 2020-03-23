package sample;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    public JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        this.init();
    }

    private void init() {
        JLabel sidesLabel = new JLabel("Number Of Sides:");
        this.sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        this.sidesField.setValue(6);
        String[] colors = new String[]{"Random", "Black"};
        this.colorCombo = new JComboBox(colors);
        this.add(sidesLabel);
        this.add(this.sidesField);
        this.add(this.colorCombo);
    }

    private void jComboBox1MousePressed(MouseEvent evt) {
        String comanda = (String)this.colorCombo.getSelectedItem();
    }
}
