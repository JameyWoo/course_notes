import javax.swing.*;
import java.awt.*;

public class FactoryProducer {
    public static AbstractFactory getFactory(String type) {
        if (type.equals("ButtonFactory")) {
            return new ButtonFactory();
        } else if (type.equals("LabelFactory")) {
            return new LabelFactory();
        } else {
            /**
             * 如果有其他工厂
             */
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}