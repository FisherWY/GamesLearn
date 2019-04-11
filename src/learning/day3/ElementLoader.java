package learning.day3;

/**
 * @Author Fisher
 * @Date 2019/4/10 15:54
 **/

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 资源加载器
 * 从配置文件中读取资源并加载
 */
public class ElementLoader {

    private Map<String, String> map;

    // 读取配置文件
    private Properties pro;

    private static ElementLoader loader;

    private ElementLoader() {
        this.map = new HashMap<>();
        this.pro = new Properties();

    }

    /**
     * 由于Loader不是经常使用，所以可以对该对象加锁
     * @return
     */
    public static synchronized ElementLoader getElementLoader() {
        if (loader == null) {
            loader = new ElementLoader();
        }
        return loader;
    }

    /**
     * 读取图片
     */
//    public void readImgPro() {
//        InputStream in = ElementLoader.class.getClassLoader().getResourceAsStream("pro/Player.properties");
//        try {
//            pro.load(in);
//            Set<?> set = pro.keySet();
//            for (Object o:set) {
//                String value = pro.getProperty(o.toString());
//                map.put(o.toString(), value);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 跟据配置文件读取不同配置文件
     *
     */
    public Map readPro(String key) {
        InputStream in = ElementLoader.class.getClassLoader().getResourceAsStream("pro/"+key+".properties");
        try {
            pro.load(in);
            Set<?> set = pro.keySet();
            for (Object o:set) {
                String value = pro.getProperty(o.toString());
                map.put(o.toString(), value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String args[]) {
        getElementLoader().readPro("Player");
    }

    // 根据key获取配置信息
    public String getConfig(String key) {
        return map.get(key);
    }

    public Map<String, String> getMap() {
        return map;
    }
}
