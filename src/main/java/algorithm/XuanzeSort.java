package algorithm;

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
            swap(arr,i,minIndex);
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
    }
}
