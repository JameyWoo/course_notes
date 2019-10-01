import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
    /**
     * 画板类, 监听鼠标并画图
     */
    public String choice = "暂无";
    private int x1, y1, x2, y2;
    static MyPanel nPanel;

    public void mousePressed(MouseEvent e) {
        // 起始位置
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        // 终止位置
        x2 = e.getX();
        y2 = e.getY();
        Graphics g = getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        Stroke stroke = new BasicStroke(3.0f);// 设置线宽为3.0
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