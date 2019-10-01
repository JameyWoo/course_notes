import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Draw {
    public static void run() {
        System.out.println("running...");

        // 设置程序主界面
        JFrame frame = new JFrame("姬小野的画板");
        frame.setResizable(false); // 禁止缩放
        frame.setSize(1200, 800);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置右侧画板
        MyPanel board = new MyPanel();
        board.setBounds(160, 20, 1000, 700);
        board.setBackground(Color.white);
        board.addMouseListener(board);
        frame.add(board);

        // 设置左侧一系列按钮的panel
        JPanel buttons = new JPanel();
        buttons.setBounds(10, 20, 140, 300);
        buttons.setBackground(Color.WHITE); // 设置背景颜色.
        frame.add(buttons);
        setButtons(buttons, board);

        // 设置左下方信息栏
        JPanel info = new JPanel();
        info.setBounds(10, 500, 140, 200);
        frame.add(info);
        setInfo(info, board);

        frame.setVisible(true);
    }

    private static void setButtons(JPanel buttons, MyPanel board) {
        /**
         * 左侧系列按钮的实现, 使用了工厂模式
         */
        buttons.setLayout(null); // ! 不设置这个会导致按钮形状不一样

        JLabel choices = new JLabel("绘图选项", JLabel.CENTER);
        choices.setFont(new Font("Dialog", 1, 18));
        choices.setBounds(30, 20, 80, 25);
        buttons.add(choices);

        // 模式提示
        JLabel hit = new JLabel("当前模式: " + board.choice);
        hit.setFont(new Font("Dialog", 1, 16));
        hit.setBounds(10, 240, 150, 25);
        buttons.add(hit);

        // ! 简单工厂模式, 生成不同功能但非常相似的按钮
        ButtonFactory bFactory = new ButtonFactory();
        JButton jvxin = bFactory.createButton("矩形", 30, 60, 80, 25, buttons, board, hit);
        JButton xian = bFactory.createButton("直线", 30, 100, 80, 25, buttons, board, hit);
        JButton yuan = bFactory.createButton("圆", 30, 140, 80, 25, buttons, board, hit);
        JButton clear = bFactory.createButton("清空", 30, 180, 80, 25, buttons, board, hit);
    }

    private static void setInfo(JPanel info, MyPanel board) {
        /**
         * 左侧说明信息栏的实现.
         */
        info.setLayout(null); // ! 不设置这个会导致label不显示

        JLabel some = new JLabel("说明", JLabel.CENTER);
        some.setFont(new Font("Dialog", 1, 18));
        some.setBounds(10, 350, 140, 25);
        info.add(some);

        // 加上<html> 使得可以自动换行
        JLabel text = new JLabel("<html>这是一个简单的画板小程序, 作者是吴嘉豪. 如有雷同, 算我抄你...</html>", JLabel.CENTER);
        text.setFont(new java.awt.Font("Dialog", 1, 15));
        text.setBounds(10, 390, 140, 100);
        info.add(text);
    }
}