import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Draw {
    public static void run() {
        System.out.println("running");

        // 设置画板
        JFrame frame = new JFrame("姬小野的画板");
        frame.setResizable(false);
        frame.setSize(990, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置右侧画板
        MyPanel board = new MyPanel();
        board.setBounds(130, 10, 800, 600);
        board.setBackground(Color.white);
        board.addMouseListener(board);
        frame.add(board);

        // 设置左侧一系列按钮的panel
        JPanel buttons = new JPanel();
        buttons.setBounds(10, 10, 100, 230);
//        buttons.setBackground(Color.white); // 设置背景颜色.
        frame.add(buttons);
        setButtons(buttons, board);

        // 设置左下方信息栏
        JPanel info = new JPanel();
        info.setBounds(10, 300, 100, 200);
//        info.setBackground(Color.red);
        frame.add(info);
        setInfo(info);

        frame.setVisible(true);
    }

    private static void setButtons(JPanel buttons, MyPanel board) {
        buttons.setLayout(null); // ! 不设置这个会导致按钮形状不一样

        JLabel choices = new JLabel("绘图选项", JLabel.CENTER);
        choices.setFont(new Font("Dialog", 1, 18));
        choices.setBounds(10, 20, 80, 25);
        buttons.add(choices);

        JButton jvxin = new JButton("矩形");
        jvxin.setBounds(10, 60, 80, 25);
        buttons.add(jvxin);
        jvxin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("矩形");
                board.choice = "矩形";
//                board.display();
            }
        });

        JButton xian = new JButton("直线");
        xian.setBounds(10, 100, 80, 25);
        buttons.add(xian);
        xian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("直线");
                board.choice = "直线";
//                board.display();
            }
        });

        JButton yuan = new JButton("圆");
        yuan.setBounds(10, 140, 80, 25);
        buttons.add(yuan);
        yuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("圆");
                board.choice = "圆";
//                board.display();
            }
        });

        JButton clear = new JButton("清空");
        clear.setBounds(10, 180, 80, 25);
        buttons.add(clear);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("清空");
                board.choice = "清空";
                board.repaint();
            }
        });
    }

    private static void setInfo(JPanel info) {
        info.setLayout(null); // ! 不设置这个会导致按钮形状不一样

        JLabel some = new JLabel("说明", JLabel.CENTER);
        some.setFont(new Font("Dialog", 1, 18));
        some.setBounds(10, 250, 80, 25);
        info.add(some);

        JLabel text = new JLabel("<html>这是一个简单的画板小程序, 作者是吴嘉豪. 如有雷同, 算我抄你...</html>", JLabel.CENTER);
//        text.setFont(new java.awt.Font("Dialog", 1, 15));
        text.setBounds(10, 270, 80, 100);
        info.add(text);
    }
}