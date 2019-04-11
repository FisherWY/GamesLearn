package learning.day3;

/**
 * @Author Fisher
 * @Date 2019/4/10 9:41
 **/

import learning.day2.SuperElement;

import javax.swing.*;
import java.awt.*;

/**
 * 飞机炮弹
 */
public class PlayerFire extends SuperElement {

    private ImageIcon img;

    public PlayerFire() {

    }

    public PlayerFire(int x, int y, int w, int h, ImageIcon img) {
        super(x, y, w, h);
        this.img = img;
    }

    // 创建子弹对象
    public static PlayerFire createPlayerFire(int x, int y, String s) {
        ImageIcon imageIcon = new ImageIcon("resources/img/fire/10.png");
        return new PlayerFire(x,y,30,30,imageIcon);
    }

    @Override
    public void showElement(Graphics g) {
        g.drawImage(img.getImage(),getX(),getY(),null);
    }

    @Override
    public void move() {
        if (getY()>=0) {
            setY(getY()-1);
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
