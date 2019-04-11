package learning.day4;

/**
 * @Author Fisher
 * @Date 2019/4/11 9:59
 **/

import learning.day2.Player;
import learning.day2.SuperElement;
import learning.day3.ElementLoader;
import learning.day3.Enemy;

import java.util.List;
import java.util.Map;

/**
 * 工厂：
 * 根据参数不同，自动读取资源，填充vo对象，储存到元素管理器
 * 工厂的作用：将比较负责的构造方式进行封装
 */
public class ElementFactory {

    public static SuperElement elementFactory(String name) {
        Map<String, String> map = ElementLoader.getElementLoader().readPro("Player");
        switch (name) {
            case "Player":
                return Player.createPlayer(null);
            case "Enemy":
                return Enemy.createEnemy(null);
            default:
                break;
        }
        return Player.createPlayer(null);
    }

    public static void main(String args[]) {
        ElementFactory.elementFactory("Img");
    }
}
