package learing.day1;

/**
 * @Author: Fisher
 * @Date: 2019-04-08 16:11
 */

public class GameStart {

    // 游戏启动唯一入口
    public static void main(String[] args) {
        // 游戏资源加载

        // 窗体加载

        // 监听加载

        // 游戏启动
        try {
            frame1 frame1 = new frame1();
            frame1.start();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
