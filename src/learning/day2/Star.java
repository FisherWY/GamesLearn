package learning.day2;

import java.awt.*;

/**
 * @Author Fisher
 * @Date 2019/4/9 9:53
 *
 * package model
 *
 **/


public class Star extends SuperElement {

    private String name;
    private Color color;
    // 更新星星颜色时间间隔
    private int refreshCount;

    public Star(int x, int y, int w, int h) {
        // super只能写在构造函数有效代码行的第一行
        super(x, y, w, h);
        setName("*");
        setColor(new Color(255, 255, 255));
        setRefreshCount(0);
    }

    @Override
    public void showElement(Graphics g) {
        setRefreshCount(getRefreshCount()+2);
        updateColor();
        g.setColor(getColor());
        g.drawString(getName(), getX(), getY());
    }

    @Override
    public void move() {

    }

    @Override
    public void destroy() {

    }

    public void updateColor() {
        // 到了更新颜色时间，更新颜色
        if (getRefreshCount() > MyJPanel1.FPS) {
            int r = (int)(Math.random()*256);
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);
            this.color = new Color(r, g, b);
            setRefreshCount(0);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(int refreshCount) {
        this.refreshCount = refreshCount;
    }
}
