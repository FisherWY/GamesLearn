package learning.day2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * @Author Fisher
 * @Date 2019/4/9 16:00
 *
 * package manager
 **/


/**
 * 键盘按键键位代码：
 *      上 -> 38
 *      下 -> 40
 *      左 -> 37
 *      右 -> 39
 */

public class GameListener implements KeyListener {

    // 主角对象List
    private List<?> list;

    // 键盘按下
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("keyPressed: " + e.getKeyCode());
        list = ElementManager.getElementManager().getElementList("Player");
        Player player = (Player)list.get(0);

        // 上下移动(解决相反的两个方向键同时按不停止)
        switch (e.getKeyCode()) {
            case 38:
                if (player.getUDMove() == MyEnum.down) {
                    player.setUDMove(MyEnum.stop);
                } else {
                    player.setUDMove(MyEnum.top);
                }
                break;
            case 40:
                if (player.getUDMove() == MyEnum.top) {
                    player.setUDMove(MyEnum.stop);
                } else {
                    player.setUDMove(MyEnum.down);
                }
                break;
            case 37:
                player.setLRMove(MyEnum.left);
                break;
            case 39:
                player.setLRMove(MyEnum.right);
                break;
            default:
                break;
        }
    }

    // 键盘松开
    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("keyReleased: " + e.getKeyCode());
        list = ElementManager.getElementManager().getElementList("Player");
        Player player = (Player)list.get(0);
        // 同时按住2个键，松开一个键之后不停顿的解决方法
        switch (e.getKeyCode()) {
            case 38:
                if (player.getUDMove() == MyEnum.top)
                    player.setUDMove(MyEnum.stop);
                break;
            case 40:
                if (player.getUDMove() == MyEnum.down)
                    player.setUDMove(MyEnum.stop);
                break;
            case 37:
                if (player.getLRMove() == MyEnum.left)
                    player.setLRMove(MyEnum.stop);
                break;
            case 39:
                if (player.getLRMove() == MyEnum.right)
                    player.setLRMove(MyEnum.stop);
                break;
            default:
                break;
        }
    }

    // 键盘字母区输入
    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("keyTyped: " + e.getKeyCode());
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
