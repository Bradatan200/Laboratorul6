package sample;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    static final int W = 800;
    static final int H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.createOffscreenImage();
        this.init();
    }

    private void createOffscreenImage() {
        this.image = new BufferedImage(800, 600, 2);
        this.graphics = this.image.createGraphics();
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, 800, 600);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(245);
        int sides = (Integer)this.frame.configPanel.sidesField.getValue();
        Color color = new Color(30, 26, 225);
        this.graphics.setColor(color);
        this.graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    public void update(Graphics g) {
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.image, 0, 0, this);
    }
}
