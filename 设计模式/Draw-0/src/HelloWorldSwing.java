import javax.swing.*;
import java.awt.*;


public class HelloWorldSwing {
    private static void createAndShowGUI() {
//        new BallGame().launchFrame();
//        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("hua 板");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 100, 300);
        frame.add(panel);

        panel.setLayout(null);


//        JLabel label = new JLabel("Hello World");
//        frame.getContentPane().add(label);
//        frame.setVisible(true);
//        frame.pack();


        JButton jvxin = new JButton("矩形");
        jvxin.setBounds(10, 60, 80, 25);
        panel.add(jvxin);

        JButton xian = new JButton("直线");
        xian.setBounds(10, 100, 80, 25);
        panel.add(xian);

        JButton yuan = new JButton("圆");
        yuan.setBounds(10, 140, 80, 25);
        panel.add(yuan);



        JPanel panel_2 = new MyPanel();
        panel_2.setBounds(100, 10, 100, 500);
        panel_2.setBackground(Color.white);
        frame.add(panel_2);

        frame.setVisible(true); // 要显示的东西在这个东西之前
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}