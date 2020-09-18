package algorithm;

/**
 * 冒泡排序：
 * 解题思路：
 * 从坐到右两两比较，谁大谁放后面
 * arr[0]到arr[n]：arr[0]和arr[1]比较，若arr[0]>arr[1]交换位置，arr[1]>arr[2]交换。。。。。最大值在最有边啊了，arr[n]固定了
 * arr[0]到arr[n-1]:第二排到倒数第二位置arr[n-1]固定了
 * 。。。。
 * arr[0]到arr[1],arr[1]固定了，排序结束
 * 计算时间复杂度：
 * (比较+交换)(n-1+n-2+....+1)=2(n-1+n-2+....+1)----》等差数列
 * 时间复杂度：O(n^2)
 */
public class MaopaoSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for (int i = arr.length - 1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j);
                }
            }
        }
    }

    /**
     * 第一层：大小n，从右排i--
     * 第二层：大小0到i，从左排，j++
     * @param arr
     * @param j
     */
    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }
}
