import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfilePanel extends JPanel {

    private final String image_path;
    BufferedImage profileImage;

    public ProfilePanel(String image_path) {
        this.image_path = image_path;
        initComponent();
    }

    private void initComponent() {
        try {
            this.profileImage = Scalr.resize(
                    ImageIO.read(new File(image_path)),
                    Scalr.Method.ULTRA_QUALITY,
                    150, 150
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(profileImage, 0, 0, this);
    }

}