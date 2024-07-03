import com.gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO: point to start new program
        EventQueue.invokeLater(() -> {
            try {
                new MainFrame();
            }
            catch(IOException e) {
                JOptionPane.showMessageDialog(null, "Application error!\n" + e.getMessage());
            }
        });
    }
}
