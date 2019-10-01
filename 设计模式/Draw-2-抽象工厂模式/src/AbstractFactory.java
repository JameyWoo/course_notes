import javax.swing.*;

public abstract class AbstractFactory {
    public abstract JButton getButton(String type, int i0, int i1, int i2, int i3, JPanel buttons, MyPanel board, JLabel hit);
    public abstract JLabel getLabel(String name, boolean isCenter, int fontSize, int i0, int i1, int i2, int i3, JPanel buttons);
}
