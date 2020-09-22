package designPatterns.singleton;

/**
 *lazy loading
 * 懒汉式
 * 可以通过 synchronized 解决线程安全问题，但也带来了效率下降
 */
public class singleton04 {
    public static singleton04 INSTANCE;

    private singleton04(){

    };

    public static synchronized singleton04 getInstance(){
        if(INSTANCE == null){

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE =  new designPatterns.singleton.singleton04();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(designPatterns.singleton.singleton04.getInstance().hashCode())
            ).start();

        }
    }



}
