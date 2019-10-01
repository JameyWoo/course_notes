
/**
 * 生成左侧按钮的简单工厂类. 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonFactory {
    public JButton createButton(String type, int i0, int i1, int i2, int i3, JPanel buttons, MyPanel board, JLabel hit) {
        JButton button = null;
        button = new JButton(type);
        button.setBounds(i0, i1, i2, i3);
        buttons.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("当前的模式: " + type);
                board.choice = type;
                if (type == "清空") {
                    board.repaint();
                }
                hit.setText("当前模式: " + board.choice);  // 动态地更新模式提示
            }
        });
        return button;
    }
}