package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 解题思路
 * 找到最小值放在最左边：
 * 从arr[0]----arr[n] 查找最小值，跟arr[0]交换 ，固定arr[0]  n(看+比较)+1
 * 从arr[1]----arr[n] 找到最小值，跟arr[1]交换 ，固定arr[1]  n(看+比较)+1
 * ....
 * 从arr[n-1]----arr[n] 找到最小，固定arr[n-1]排序结束，
 * 计算时间复杂度：
 * （看+比较）(n+n-1+n-2+...+1) +n(交换)
 * 常数操作数为：
 * 2(n+n-1+n-2...+1)+n
 * (n+n-1+n-2...+1) 是个等差数列 = aN^2+bN+c   时间复杂度抹掉低阶项和高阶项系数；所以会去掉常数项（bN+c）和高阶项系数（a）
 * 算时间复杂度时：拆分的基本动作是个常数级别的操作就ok
 *间复杂度为：O(n^2)
 */
public class XuanzeSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
//                if(arr[j]<arr[minIndex]){
//                    minIndex=j;
//                }
//                每次的arr[j]跟最小值比较，如果arr[j]比最小值还小，那最小值指向arr[j]（就是最小值下标为j）
//                找到这一轮的最小值下标
               minIndex = arr[j] < arr[minIndex] ? j : minIndex;

            }
//            if(i != minIndex){
                swap(arr,i,minIndex);
//            }

        }

    }

    /**
     * 第一层：大小n,从左排i++
     * 第二层：大小i到n，从左排j++
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;



        //异或运算：相同为0，不同为1     意思就是:无进位相加（进位忽略）
        //异或运算满足交换律和结合律，意思就是跟数字顺序没有关系
        //要求 交换a,b 并且不能申请第额外变量（就是必能定义temp）  可以这么写
//        arr[i] = arr[i] ^ arr[j];   //arr[i] = arr[i] ^ arr[j]     arr[j]=arr[j]
//        arr[j] = arr[j] ^ arr[i];   //arr[j] = arr[j] ^ arr[i] = arr[j] ^  arr[i] ^ arr[j] = arr[j] ^  arr[j] ^ arr[i] = 0 ^ arr[i] = arr[i]
//        arr[i] = arr[i] ^ arr[j];   //arr[i] = arr[i] ^ arr[j] ^ arr[i] = arr[i] ^ arr[i] ^ arr[j] = 0 ^ arr[j] = arr[j]

        //这种写法只能在不同的东西交换  若指向想的是同一个东西就会出错
        // 若 i和j是同一个下标（i=j=0  arr[0] arr[i]就是arr[j]）那他们指向的是同一个东西了arr[0]
    }



    // for test  对数器
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
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
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
        selectionSort(arr);
        printArray(arr);
    }
}
