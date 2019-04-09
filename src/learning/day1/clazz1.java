package learning.day1;

/*

    游戏软件:
    1. 良好的交互功能
    2. 漂亮的ui设计
    3. 良好的扩展与更新功能

    需要的具体功能:
    1. 鼠标，键盘，手柄.....
    2. 友好的用户提示
    3. 窗体操作，内部的图片显示
    4. 尽量的将游戏中的对象以容易修改的方式进行初始化，同时让对象中的资源能灵活搭配，降低代码之间的耦合度

    MVC设计模式：
    M 数据模型
    V 视图 -> 用户看见的
    C 控制 -> 用户操作

 */

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Author: Fisher
 * @Date: 2019-04-08 09:55
 */

public class clazz1 {

    public static void main(String args[]) {
//        System.out.println("--------test1_1:");
//        test1_1();
//
//        System.out.println("--------test1_2:");
//        test1_2();

        System.out.println("--------test2_1:");
        test2_1();
    }

    // 1. 集合嵌套使用
    /*
     * List: 有序，数据可重复
     *   实现类
     *   ArrayList   数组，遍历查询快
     *   LinkedList  链表，添加删除快
     *
     * Set: 无序，数据不可重复
     *   HashSet hash散列
     *
     * Map: key - value
     *   HashMap
     *   LinkedHashMap
     * 项目资源管理器，对于对象的存储会使用，对于资源（图片资源）会用到
     *
     * template <> 泛型：编译期的语法现象
     * 默认都是Object类型
     *
     * 合金弹头人物分上下半身，每个左右都有多个图片
     *  key            value
     *  "topLeft"      照片集合List(一系列动作)
     *
     * */

    // Map中Value为Object的使用
    public static void test1_1() {
        Map<String, Object> map = new HashMap<>();
        map.put("key01", "value01");

        Object o = map.get("key01");
        System.out.println(o);
    }

    // Map中Value为List对象的使用
    public static void test1_2() {
        Map<String, List<String> > map = new HashMap<>();

        // 数据的构造
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // 数据的存取
        map.put("list", list);
//        List<String> list1 = map.get("list");
        // 通过keySet()，Set对象接收获得map中的所有key
        Set<String> set1 = map.keySet();

        // 对于List中的内容使用for循环输出
//        for (String x:list1) {
//            System.out.println(x);
//        }

        // 实现了Iterator接口，所以可以用forEach
        for (String x:set1) {
            System.out.println(x);
        }

        // 使用Iterator方法
        Iterator<String> iterator = set1.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println("Iterator: " + s);
            List<String> list2 = map.get(s);
            for (String x:list2) {
                System.out.println("key: " + s + "    value:" + x);
            }
        }
    }



    // 2. 资源加载管理
    /*
     * 配置文件： xml      properties
     * 资源加载器 -> 加载配置文件 -> 依据配置文件加载图片，音乐
     */

    public static void test2_1() {
        // 通过类路径读取配置文件 -> 类加载器
        // 获取类的反射 -> 获取的是类自己本身的对象
        try {
            // 通过路径+名称获取class，多用于外部jar包导入
            Class<?> class1 = Class.forName("learning.day1.clazz1");
            // 通过类名.class获取，多用于内部工程中的引用
//            Class<?> class2 = clazz1.class;
            // 通过实例化class对象获取
//            Class<?> class3 = new clazz1().getClass();
            System.out.println(class1.getName());

            // 通过classLoader获取properties文件，通过inputStream接收，后面参数跟全路径
            InputStream in = clazz1.class.getClassLoader().getResourceAsStream("pro/day1clazz1.properties");
            // 实例化properties对象
            Properties properties = new Properties();
            // 加载配置文件
            properties.load(in);
            // 读取配置
            System.out.println(properties.getProperty("boss"));

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Load properties failed");
            e.printStackTrace();
        }
    }
}
