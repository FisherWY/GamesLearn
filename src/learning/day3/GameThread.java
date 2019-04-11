package learning.day3;

/**
 * @Author Fisher
 * @Date 2019/4/10 8:46
 *
 *
 * package thread
 **/

import learning.day2.ElementManager;
import learning.day2.MyJPanel1;
import learning.day2.SuperElement;
import learning.day3.Enemy;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 在Java中只能是单继承，多实现。
 * 我们通过内部类的方式，弥补单继承的缺陷
 *
 *
 * 游戏线程 -> 死循环，但会有状态变量控制
 */
public class GameThread extends Thread {

    // 定时器
    private int time;

    @Override
    public void run() {
        // 游戏整体进度
        while (true) {
            // 1. 加载地图，人物
            loadElement();
            // 2. 显示人物、地图
            time = 0;   //开始记录时间
            runGame();
            // 3. 结束本地图
            overGame();

            // 线程休眠
            try {
                sleep(MyJPanel1.REFRESHRATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadElement() {

    }

    private void runGame() {
        // 游戏进行中的死循环
        while (true) {
            // player的移动
//            List<SuperElement> player = ElementManager.getElementManager().getElementList("Player");
//            for (SuperElement x:player) {
//                x.move();
//                x.update();
//            }

            // 游戏中所有元素的更新
            Map<String, List<SuperElement>> map = ElementManager.getElementManager().getMap();
            Set<String> set = map.keySet();
            for (String key:set) {
                List<SuperElement> elements = map.get(key);
                // 循环倒着写，防止删除元素时出现画面卡顿
                for (int i=elements.size()-1; i>=0; i--) {
                    elements.get(i).update();
                    // 如果对象不可见，则销毁对象
                    if (!elements.get(i).isVisible()) {
                        elements.remove(i);
                    }
                }
            }

            // 游戏流程控制 -> 敌机出现的控制
            if ( time >= MyJPanel1.FPS) {
                time = 0;
                this.EnemyControl();
            }

            // player处于死亡状态时，结束游戏


            try {
                sleep(MyJPanel1.REFRESHRATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
        }

    }

    // 游戏流程控制
    public void EnemyControl() {
        List<SuperElement> list = ElementManager.getElementManager().getElementList("Enemy");
        list.add(Enemy.createEnemy(null));
    }

    private void overGame() {

    }
}
