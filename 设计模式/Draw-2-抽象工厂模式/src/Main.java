import javax.swing.*;

/**
 * ! 抽象工厂模式改造之前的简单工厂模式代码
 * 之前的简单工厂就是生成按钮
 * 现在抽象工厂多了, 那我就可以生成按钮 + 标签 了
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Main.java!");
        Draw draw = new Draw();
        draw.run();
    }
}