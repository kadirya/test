package designPatterns.singleton;

/**
 *lazy loading
 * 懒汉式
 * 虽然打单了按需初始化的目的，但带来了线程不安全问题
 */
public class singleton05 {
    public static singleton05 INSTANCE;

    private singleton05(){

    };

    public static singleton05 getInstance(){
        if(INSTANCE == null){
            synchronized(singleton05.class) {
//                妄图用减少同步代码块的方式提高效率，结果不可行，又回到线程不安全问题了
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE =  new singleton05();
            }

        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(singleton05.getInstance().hashCode())
            ).start();
            /**
             * 结果集
             * 2048645487
             * 2048645487
             * 1934637030
             * 1934637030
             * 1934637030
             * 412393942
             * 412393942
             * 412393942
             * 412393942
             */

        }
    }



}
