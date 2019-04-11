package learning.day3;

import learning.day1.frame1;
import learning.day2.SuperElement;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Fisher
 * @Date 2019/4/10 11:25
 **/


public class EnemyFire extends SuperElement {

    private ImageIcon img;

    public EnemyFire() {

    }

    public EnemyFire(int x, int y, int w, int h, ImageIcon img) {
        super(x, y, w, h);
        this.img = img;
    }

    // 创建子弹对象
    public static EnemyFire createEnemyFire(int x, int y, String s) {
        ImageIcon imageIcon = new ImageIcon("resources/img/fire/11.png");
        return new EnemyFire(x,y,30,30,imageIcon);
    }

    @Override
    public void showElement(Graphics g) {
        g.drawImage(img.getImage(),getX(),getY(),null);
    }

    @Override
    public void move() {
        if (getY() <= frame1.HEIGHT) {
            setY(getY()+2);
        } else {
            // 超过边界的要销毁
            setVisible(false);
            // 爆炸效果
            this.destroy();
        }
    }

    /**
     * 子弹到达边界之后，发生爆炸效果，同时销毁子弹对象
     */
    @Override
    public void destroy() {

    }
}
