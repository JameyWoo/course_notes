import javax.swing.*;
import java.awt.*;

public class LabelFactory extends AbstractFactory{
    @Override
    public JButton getButton(String type, int i0, int i1, int i2, int i3, JPanel buttons, MyPanel board, JLabel hit) {
        /**
         * 留空, label工厂不生成button
         */
        return null;
    }

    @Override
    public JLabel getLabel(String name, boolean isCenter, int fontSize, int i0, int i1, int i2, int i3, JPanel buttons) {
        System.out.println("生成一个 " + name + " label");
        JLabel label = null;
        if (isCenter) {
            label = new JLabel(name, JLabel.CENTER);
        } else {
            label = new JLabel(name);
        }
        label.setFont(new Font("Dialog", 1, fontSize));
        label.setBounds(i0, i1, i2, i3);
        buttons.add(label);
        return label;
    }
}
