package learning.day2;

import learning.day1.frame1;

import javax.swing.*;
import java.awt.*;

import static java.lang.StrictMath.abs;

/**
 * @Author Fisher
 * @Date 2019/4/9 15:31
 *
 * package vo
 **/

public class Player extends SuperElement{

    // 血量
    private int hp;
    // 蓝量
    private int mp;
    // 技能点
    private int sp;
    // 分数
    private int score;
    // 贴图
    private ImageIcon imageIcon;

    // 移动方向，分为上下、左右两组
    private MyEnum UDMove;
    private MyEnum LRMove;

    public Player(int x, int y, int w, int h, ImageIcon imageIcon) {
        super(x, y, w, h);
        this.imageIcon = imageIcon;
        setHp(0);
        setMp(0);
        setSp(0);
        setScore(0);

        // 初始为静止状态
        UDMove = MyEnum.stop;
        LRMove = MyEnum.stop;
    }

    // 自定义player创建方法
    public static Player createPlayer(String s) {
        int x = 150;
        int y = 150;
        int w = 50;
        int h = 50;
        String url = "resources/img/play/13.png";
        return new Player(x,y,w,h,new ImageIcon(url));
    }

    // player移动方法
    public synchronized void move() {
        // 上下边界判定
        // 上下移动
        switch (UDMove) {
            case top:
                if (getY()<0) {
                    setY(0);
                } else {
                    setY(getY()-1);
                }
                break;
            case down:
                if (getY()+getH()>frame1.HEIGHT) {
                    setY(frame1.HEIGHT-getH());
                } else {
                    setY(getY()+1);
                }
                break;
            case stop:
                break;
            default:
                break;
        }

        // 左右边界判定
        // 左右移动
        switch (LRMove) {
            case left:
                if (getX()<0) {
                    setX(0);
                } else {
                    setX(getX()-1);
                }
                break;
            case right:
                if (getX()+getW()>frame1.WIDTH) {
                    setX(frame1.WIDTH-getW());
                } else {
                    setX(getX()+1);
                }
                break;
            case stop:
                break;
            default:
                break;
        }
    }

    @Override
    public void showElement(Graphics g) {
        move();
        g.drawImage(imageIcon.getImage(), getX(), getY(), getW(), getH(), null);
    }

    // Auto Generate
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public MyEnum getUDMove() {
        return UDMove;
    }

    public void setUDMove(MyEnum UDMove) {
        this.UDMove = UDMove;
    }

    public MyEnum getLRMove() {
        return LRMove;
    }

    public void setLRMove(MyEnum LRMove) {
        this.LRMove = LRMove;
    }
}
