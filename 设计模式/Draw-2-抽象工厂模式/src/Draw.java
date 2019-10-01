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

        // 抽象工厂
        FactoryProducer factoryProducer = new FactoryProducer();

        AbstractFactory labelFactory = factoryProducer.getFactory("LabelFactory");
        JLabel choices = labelFactory.getLabel("绘图选项", true, 18, 30, 20, 80, 25, buttons);
        // 模式提示
        JLabel hit = labelFactory.getLabel("当前模式: " + board.choice, false, 16, 10, 240, 150, 25, buttons);

        // button工厂
        AbstractFactory buttonFactory = factoryProducer.getFactory("ButtonFactory");
        JButton jvxin = buttonFactory.getButton("矩形", 30, 60, 80, 25, buttons, board, hit);
        JButton xian = buttonFactory.getButton("直线", 30, 100, 80, 25, buttons, board, hit);
        JButton yuan = buttonFactory.getButton("圆", 30, 140, 80, 25, buttons, board, hit);
        JButton clear = buttonFactory.getButton("清空", 30, 180, 80, 25, buttons, board, hit);
    }

    private static void setInfo(JPanel info, MyPanel board) {
        /**
         * 左侧说明信息栏的实现.
         */
        info.setLayout(null); // ! 不设置这个会导致label不显示

        // 抽象工厂
        FactoryProducer factoryProducer = new FactoryProducer();
        AbstractFactory labelFactory = factoryProducer.getFactory("LabelFactory");

        JLabel some = labelFactory.getLabel("说明", true, 18, 10, 350, 140, 25, info);

        // 加上<html> 使得可以自动换行
        JLabel text = labelFactory.getLabel("<html>这是一个简单的画板小程序, 作者是吴嘉豪. 如有雷同, 算我抄你...</html>",
                true, 15, 10, 390, 140, 100, info);
    }
}