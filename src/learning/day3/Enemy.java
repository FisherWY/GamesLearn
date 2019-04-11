package learning.day3;

/**
 * @Author Fisher
 * @Date 2019/4/10 10:56
 **/

import learning.day1.frame1;
import learning.day2.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * package vo
 * 敌机类
 */
public class Enemy extends SuperElement {

    // 血量
    private int hp;
    // 贴图
    private ImageIcon imageIcon;

    // 攻击状态
    private boolean pk;

    // 移动方向，分为上下、左右两组
    private MyEnum UDMove;
    private MyEnum LRMove;
    private int UDMoveType;
    private int LRMoveType;
    private Random random;

    private int refreshCount;


    public Enemy(int x, int y, int w, int h, ImageIcon img) {
        super(x, y, w, h);
        setHp(0);
        this.imageIcon = img;
        setPk(false);
        setRandom(new Random());
        setRefreshCount(0);
        this.setVisible(true);
    }

    public static Enemy createEnemy(String s) {
        int x = new Random().nextInt(frame1.WIDTH);
        int y = 50;
        int w = 50;
        int h = 50;
        String url = "resources/img/play/7.png";
        return new Enemy(x,y,w,h,new ImageIcon(url));
    }

    /**
     * 敌机自动移动
     */
    @Override
    public void move() {
        if (getY() < frame1.HEIGHT) {
            setY(getY()+1);
        } else {
            setVisible(false);
        }
    }

    // player开火方法
    public void addFire() {
        if (refreshCount >= MyJPanel1.FPS) {
            setPk(true);
        }
        setRefreshCount(getRefreshCount()+1);
        // 如果player不在开火状态，则直接退出
        if (!isPk()) {
            return;
        }
        List<SuperElement> list = ElementManager.getElementManager().getElementList("EnemyFire");
        // 如果ElementManager中没有PlayerFire，则新建一个
        if (list == null) {
            list = new ArrayList<>();
        }
        // 添加子弹
        list.add(EnemyFire.createEnemyFire(getX(),getY(),null));
//        ElementManager.getElementManager().getMap().put("EnemyFire",list);

        // 每一次按键只能放一颗子弹
        setPk(false);
        setRefreshCount(0);
    }

    @Override
    public void destroy() {
        this.setVisible(false);
    }

    @Override
    public void update() {
        super.update();
        this.addFire();
    }

    @Override
    public void showElement(Graphics g) {
        setRefreshCount(getRefreshCount()+2);
        g.drawImage(getImageIcon().getImage(),getX(),getY(),null);
    }

    // Auto Generate
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
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

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(int refreshCount) {
        this.refreshCount = refreshCount;
    }
}
