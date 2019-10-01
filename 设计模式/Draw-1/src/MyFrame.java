import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {

    public void paint(Graphics g)
    {
        //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.RED);//设置画图的颜色
        g.drawLine(300, 100, 200, 400);
//        g2d.fill3DRect(x, y, 100, 100, true);//填充一个矩形
    }
}