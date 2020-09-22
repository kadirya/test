package designPatterns.singleton;

/**
 *饿汉式
 * 类加载到内存后就实例化一个单例，jvm保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点就是，不管是否用，类装载时就完成实例化
 */
public class singleton01 {
    public static final singleton01 INSTANCE = new singleton01();

    private singleton01(){

    };

    public static singleton01 getInstance(){
        return  INSTANCE;
    }

    public static void main(String[] args) {
        singleton01 s1 = singleton01.getInstance();
        singleton01 s2 = singleton01.getInstance();
        System.out.println(s1 == s2);
    }

}
