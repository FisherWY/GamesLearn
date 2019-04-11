package learning.day2;

import learning.day1.frame1;
import learning.day3.Enemy;
import learning.day4.ElementFactory;

import java.util.*;
import java.util.List;

/**
 * @Author Fisher
 * @Date 2019/4/9 9:15
 **/

/*
 * package manager
 * 元素管理器
 *
 * 使用Java设计模式 -> 单例模式 -> 全局只有一个实例
 *
 */
public class ElementManager {

    // 集合 NPC元素、场景元素......
    private Map<String, List<SuperElement>> map;

    // 单例：需要一个全局唯一的引用
    private static ElementManager elementManager;

    // 构造方法私有化，只有在本类中可以实例化对象
    private ElementManager() {
        init();
    }

    // 受保护的init函数
    protected void init() {
        this.map = new HashMap<>();

        // 星星List
        List<SuperElement> list = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<100; i++) {
            list.add(new Star(random.nextInt(frame1.WIDTH),random.nextInt(frame1.HEIGHT),0,0));
        }
//
//        // 月亮List
//        List<SuperElement> list1 = new ArrayList<>();
//        list1.add(new Moon(new Color(255,255,255),false,200,200,100,100));
//        list1.add(new Moon(new Color(0,0,0),true,50,200,100,100));
//
        /* 把List放进map中
         * hashCode()中，Object根据集合散列进行
         */
        map.put("Star", list);
//        map.put("Moon", list1);

        // Player List
        List<SuperElement> list2 = new ArrayList<>();
        list2.add(ElementFactory.elementFactory("Player"));
        map.put("Player", list2);

        // Enemy List
        List<SuperElement> list4 = new ArrayList<>();
        list4.add(ElementFactory.elementFactory("Enemy"));
        map.put("Enemy", list4);

        // Enemy子弹List
        List<SuperElement> list5 = new ArrayList<>();
        map.put("EnemyFire", list5);

        // Player子弹List
        List<SuperElement> list3 = new ArrayList<>();
        map.put("PlayerFire", list3);
    }

    // static语句块，类加载的时候执行，只执行一次
    static {
        if (elementManager == null) {
            elementManager = new ElementManager();
        }
    }

    // 根据key获取List，得到一个List集合
    public List<SuperElement> getElementList(String key) {
        return map.get(key);
    }

    // Auto Generate
    public Map<String, List<SuperElement>> getMap() {
        return map;
    }

    // 为防止出现线程安全问题，对该方法加锁
    public static ElementManager getElementManager() {
//        用static语句块代替
//        if (elementManager == null) {
//            elementManager = new ElementManager();
//        }
        return elementManager;
    }
}
