import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.lang.Math;

import java.awt.*;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
    public String choice;
    private int x1, y1, x2, y2;

    static MyPanel nPanel;
    public static void main(String args[]){

        JFrame nFrame=new JFrame("Drawing program");
        nPanel=new MyPanel();
        nFrame.add(nPanel);
        nFrame.setBounds(100,100,800,800);
        nFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nFrame.setVisible(true);
        nPanel.addMouseListener(nPanel);

    }

    public  void mousePressed(MouseEvent e) {
        x1=e.getX();
        y1=e.getY();
        Graphics g=getGraphics();
//        g.drawLine(0,0,x,y);

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Graphics g=getGraphics();
        Graphics2D g2=(Graphics2D)g;
        Stroke stroke=new BasicStroke(3.0f);//设置线宽为3.0
        g2.setStroke(stroke);

        if (choice == "直线") {
            g.drawLine(x1, y1, x2, y2);
        } else if (choice == "矩形") {
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            }
            if (y1 > y2) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            x2 -= x1;
            y2 -= y1;
            g.drawRect(x1, y1, x2, y2);
        } else if (choice == "圆") {
            x2 -= x1;
            y2 -= y1;
            g.drawOval(x1, y1, x2, y2);
        } else if (choice == "清空") {

        }
        x1 = y1 = x2 = y2 = 0;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
    }

}

//
//class MyPanel extends JPanel
//{
//    private int x = 200;
//    private int y = 200;
//    public String choice;
//
//    public void display()
//    {
//        x ++;
//        y ++;
//        System.out.println("Hello World!");
//        //重绘JPanel
//        this.repaint();
//    }
//
//    /**
//     * repaint方法会调用paint方法，并自动获得Graphics对像
//     * 然后可以用该对像进行2D画图
//     * 注：该方法是重写了JPanel的paint方法
//     */
//    public void paint(Graphics g)
//    {
//        //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
//        super.paint(g);
//        Graphics2D g2d = (Graphics2D)g;
//
//        g2d.setColor(Color.RED);//设置画图的颜色
//
////        g2d.fill3DRect(x, y, 100, 100, true);//填充一个矩形
//
//        if (choice == "直线") {
//            g.drawLine(300, 100, 200, 400);
//        } else if (choice == "圆") {
//            g.drawOval(0, 20, 400, 400);
//        } else if (choice == "矩形") {
//            g.drawRect(0, 0, 400, 400);
//        }
//    }
//}