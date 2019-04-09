package learning.day1;

import learning.day2.GameListener;
import learning.day2.MyJPanel1;

/**
 * @Author: Fisher
 * @Date: 2019-04-08 16:11
 */

public class GameStart {

    // 游戏启动唯一入口
    public static void main(String[] args) {

        try {
            // 游戏资源加载

            // 窗体加载
            frame1 frame1 = new frame1();
            // 画板加载
            MyJPanel1 jPanel1 = new MyJPanel1();
            frame1.setjPanel(jPanel1);
            frame1.addJPanel();

            // 监听加载
            GameListener listener = new GameListener();
            frame1.setKeyListener(listener);
            frame1.addListener();

            // 游戏启动
            frame1.start();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
