package designPatterns.singleton;

/**
 *lazy loading
 * 懒汉式
 * 双重检查 + 禁烧同步代码块 解决了线程不安全问题和效率下降问题，
 */
public class singleton06 {
    public static designPatterns.singleton.singleton06 INSTANCE;

    private singleton06(){

    };

    public static designPatterns.singleton.singleton06 getInstance(){
        if(INSTANCE == null){
            synchronized(designPatterns.singleton.singleton06.class) {
//                双重检查
                if(INSTANCE == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE =  new designPatterns.singleton.singleton06();
                }

            }

        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(designPatterns.singleton.singleton06.getInstance().hashCode())
            ).start();

        }
    }



}
