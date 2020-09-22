package designPatterns.singleton;

/**
 *lazy loading
 * 懒汉式
 * 虽然打单了按需初始化的目的，但带来了线程不安全问题
 */
public class singleton03 {
    public static  singleton03 INSTANCE;

    private singleton03(){

    };

    public static singleton03 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE =  new singleton03();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(singleton03.getInstance().hashCode())
            ).start();
/**
 * 结果集如下
 * 412393942
 * 2040633862
 * 2040633862
 * 2040633862
 * 2040633862
 * 802181073
 * 556244866
 * 1846890052
 * 47100638
 * 2132637868
 * 1740670181
 * 1934637030
 * 2048645487
 * 463237198
 * 1206117557
 * 341117762
 * 182789839
 * 182789839
 * 182789839
 * 182789839
 * 182789839
 * 182789839
 * 182789839
 * 182789839
 * 182789839
 * 182789839
 */

        }
    }



}
