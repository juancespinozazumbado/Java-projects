package exportacion.swin;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelRedondo extends JPanel {

    public PanelRedondo() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D graficos = (Graphics2D) grphcs.create();
        graficos.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graficos.setColor(getBackground());
        graficos.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        graficos.dispose();
        super.paint(grphcs);
    }
}