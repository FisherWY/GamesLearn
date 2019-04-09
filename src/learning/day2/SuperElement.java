package learning.day2;

import java.awt.*;

/**
 * @Author Fisher
 * @Date 2019/4/9 9:51
 *
 * package vo
 * 所有model的父类
 *
 **/


public abstract class SuperElement {
    private int x;
    private int y;
    private int w;
    private int h;

    /*
     * jvm给每个类都会默认添加一个无参构造方法
     * 但如果手写一个构造方法之后（无论是有参或者无参） jvm都不会再添加默认构造方法
     * 一般作为父类，若果有其他构造方法，最好加一个无参构造方法，防止继承报错
     */
    public SuperElement() { }

    public SuperElement(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void showElement(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
