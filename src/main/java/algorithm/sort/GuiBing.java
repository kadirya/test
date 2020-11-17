package algorithm.sort;

import java.util.Arrays;

public class GuiBing {

    //递归实现归并排序
    //时间复杂度O(Nlog(N))

    /**
     * 递归做法
     * 分到左组，右组各一个元素，左组和右组是有序的因为只有一个数，然后开始merge
     * 0,...m1...,m,...m2...n-1,n   0-n个元素二分0----m,m+1----n; 再分 0----m1，m1+1----m......以此类推
     */
    public static void process(int[] arr,int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merger(arr, L, mid, R);
    }


    /**
     * @param arr 要排序的集合
     * @param L  左组第一个下标
     * @param M  左组最后一个下表  M+1右组第一个元素
     * @param R   右组最后一个下标
     * merge的过程就是把有序的两个组合并成有序的一组
     * 左组的第一个元素和右组第一个元素比较那个那个小那个就是help数组的第一个元素
     * arr[p1] <= arr[p2] 为true，那么左组下标右移，下一步左组第二个元素跟右组第一个元素比较 以此类推 直到左组和右组其中一个越界
     * 左组和右组其中一个越界后，比如右组越界  左组剩下的元素直接按原顺序加到help数组后面
     * 最后把help数组赋值给原数组的L到R的位置上
     * 时间复杂度为O(N*logN)
     */
    public static void merger(int[] arr, int L, int M, int R){
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        //执行到 p1，p2其中一个越界
        while (p1 <= M && p2 <= R){  //p1 p2都不越界（M以内P1是左组元素，R以内p2是右组元素）
            //
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p1没越界就执行
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        //p2没越界就执行
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (i=0; i<help.length; i++){
            arr[L+i] = help[i];
        }

    }

    //非递归实现
    //时间复杂度为O(N*logN)

    /**
     * 非递归实现
     * @param arr
     * mergsize为有序组大小
     */
    public static void mergerSort(int[] arr){
        if (arr == null && arr.length < 2){
            return;
        }
        int N = arr.length;
        int mergerSzie = 1;  //当前有序的左组长度
        while (mergerSzie < N){ //logN次
            int L = 0;
            while (L < N){
                //L...M左组（长度为mergesize）
                int mid = L + mergerSzie - 1;
                if (mid >= N){
                    break;
                }
                int R = Math.min(mid + mergerSzie, N - 1);
                merger(arr, L, mid, R);
                L = R + 1;

            }

            //如果n接近int类型的最大值
            // 进行下面mergsize左移就有可能越界int范围 报错
            if (mergerSzie > N/2){
                break;
            }

             mergerSzie <<= 1;
        }
    }



    //对数器
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }



    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 8;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            mergerSort(arr1);
            process(arr1, 0, arr1.length);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
//        mergerSort(arr);
        process(arr, 0, arr.length);
        printArray(arr);
    }
}
