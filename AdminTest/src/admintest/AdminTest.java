
package admintest;

import javax.swing.SwingUtilities;
import view.MainWindow;


public class AdminTest {

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
    
}
