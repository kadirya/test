package algorithm;

/**
 * 插入排序
 * 解题思路
 * 搞定arr[0]----arr[0]范围上有序，就一个元素，天然有序
 * 搞定arr[0]----arr[1]范围上有序，arr[1]往坐看，比arr[0]小的话交换
 * 搞定arr[0]----arr[2]范围上有序，arr[2]往坐看，比arr[1]小的话交换，再跟arr[0]比，再小再换
 * 。。。。。
 * 搞定arr[0]----arr[n]范围上有序，arr[n]往坐看，比arr[n-1]小的话交换，再跟arr[n-2]比，再小再换.....
 * 计算算法复杂度：
 * 最坏情况下O()
 *
 */
public class CharuSort {
    public static void inputSort(int[] arr){
        if(arr==null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0 && arr[j] < arr[j-1]; j--) {
//                if(arr[j] < arr[j-1]){
                    swap(arr,j);
//                }else {
//                    continue;
//                }
            }
        }
    }

    /**
     * 第一层：大小n,从左排,i++
     * 第二层：大小0到i,从右排，j--
     * @param arr
     * @param j
     */
    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = temp;
    }
}
