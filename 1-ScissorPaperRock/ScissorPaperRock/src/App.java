import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                GUI myGui = new GUI();
                myGui.setVisible(true);
            }
        });
    }
}
