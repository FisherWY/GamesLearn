package learning.day2;

import java.awt.*;

/**
 * @Author Fisher
 * @Date 2019/4/9 10:42
 **/


public class Moon extends SuperElement {

    // 是否移动类型
    private Boolean isMoving;
    private Color color;

    public Moon(Color color, boolean isMoving, int x, int y, int w, int h) {
        super(x, y, w, h);
        setColor(color);
        setMoving(isMoving);
    }

    @Override
    public void showElement(Graphics g) {
        // 如果是移动中，则位置发生变化
        if (isMoving) {
            setX((getX()+1)%800);
        }
        // 边框
//        g.drawOval(getX(), getY(), getW(), getH());
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getW(), getH());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getMoving() {
        return isMoving;
    }

    public void setMoving(Boolean moving) {
        isMoving = moving;
    }
}
