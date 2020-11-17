package experiment;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {


    public void define_capacity(){

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(list.size());
        list.ensureCapacity(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);



        list.clear();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        System.out.println("长度为：" +list.size());

        System.out.println("iterator遍历");
        long start = System.currentTimeMillis();
        Iterator<Integer> itr= list.iterator();
        while (itr.hasNext()){
            itr.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("iterator:" + (end - start) + "ms");

//        System.out.println();
        System.out.println("索引值遍历");
        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("for:" + (end - start) + "ms");

//        System.out.println();
        System.out.println("for循环遍历");
        start = System.currentTimeMillis();
        for (Integer integer : list) {
            ;
        }
        end = System.currentTimeMillis();
        System.out.println("for2:" + (end - start) + "ms");

        //toarray
//        System.out.println();
//        System.out.println("toarray");

//        Integer[] integers = list.toArray(new Integer[0]);
//        System.out.println(integers.length);
//        for (Integer integer : integers) {
//            System.out.print(integer + " ");
//        }

//        会报错，不能这样赋值
//        Integer[] integers1 = new Integer[list.size()];
//        integers1 = list.toArray();
//        应该这么写
//        integers1 = list.toArray(integers1);
//        System.out.println(list.toArray()[0]);

//        for (Integer integer : integers1) {
//            System.out.print(integer + " ");
//        }

        list.add(2,8);

//        for (Integer integer : list) {
//            System.out.print(integer + " ");
//        }

//        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
    }
}
