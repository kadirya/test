package designPatterns.singleton;

/**
 *跟 gingleton01 一个意思
 */
public class singleton02 {
    public static final singleton02 INSTANCE;
    static {
        INSTANCE = new singleton02();
    }

    private singleton02(){

    };

    public static singleton02 getInstance(){

        return  INSTANCE;
    }

    public static void main(String[] args) {
        designPatterns.singleton.singleton02 s1 = designPatterns.singleton.singleton02.getInstance();
        designPatterns.singleton.singleton02 s2 = designPatterns.singleton.singleton02.getInstance();
        System.out.println(s1 == s2);
    }

}
