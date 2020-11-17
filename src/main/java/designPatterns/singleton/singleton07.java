package designPatterns.singleton;

/**
 *lazy loading
 * 懒汉式
 * 静态内部类方式，jvm解决线程安全问题
 * 加载外部类时不回家在内部类，可以实现懒加载
 */
public class singleton07 {


    private static class  singleton07Holder{
        private final static singleton07 INSTANCE = new singleton07();
    }

    private singleton07(){
    };

    public static singleton07 getInstance(){
        return  singleton07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(singleton07.getInstance().hashCode())
            ).start();


        }












    }











    {

    }





}
