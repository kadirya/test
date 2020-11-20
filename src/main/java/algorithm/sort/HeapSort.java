package algorithm.sort;


/**
 * 如果数字不是一个一个给的可以先当做是完全二叉树
 * 完全二叉树：除了最后一层以外其他层都是满的，而且不满的一层也是从左到右逐渐变满的状态
 * （意思就是：有左节点，没有右节点可，有右节点没有左节点不可）
 * 时间复杂度为：Olog(N)
 *
 */
public class HeapSort {
//    public static void heapSort();

    public static void heap(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        //先把数组转换成大根堆
//        for (int i = 0; i < arr.length; i++){O(N)
//            //每次把arr[0]-arr[i-1]当做大根堆接着加元素
//            heapInsert(arr, i); O(logN)
//        }

        //如果用户一个一个给数组里的元素那只能heapinsert
        // 如果一次性给了所有那就可以heapify  整个for循环heapify出来复杂度为：O(N)
        for (int i = arr.length - 1; i > 0; i--){
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        //大根堆arr[0]永远是最大值
        // 0位置跟最后一个位置交换，大根堆缩小一个（就是不包含排好的部分）
        // 然后继续heapify
        // 大根堆逐渐变小一直到对大小剪成0，就排好序了
        swap(arr, 0, --heapSize);

        for (int i = 0; i < heapSize ;i++){
            heapify(arr, 0, heapSize);
            swap(arr, 0,heapSize--);
        }
    }

    //index往上看，直到父节点比自己大为止
    public static void heapInsert(int[] arr, int index){
        int rootIndex = (index-1)/2;
        while (arr[index] > arr[rootIndex]){
            swap(arr, index, rootIndex);
            index = rootIndex;
        }
    }


    //从index往下看，不断下沉
    //没有孩子比我大 或 已经没有孩子了时停
    //时间复杂：logN
    public static void heapify(int[] arr, int index, int heapSize){
        //有左孩子循环（循环到没有孩子节点为止）
        while (index < heapSize){
            int left = index * 2 + 1;
            //有右孩子并且右孩子比左孩子小时large=右孩子的下标，否则large=左孩子下标
            //两个孩子中较大的小标给large
            int large = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            //孩子节点较大的节点（arr[large]）跟头结点比较
            large = arr[large] > arr[index] ? large : index;
            //index节点的左右孩子都比他小就退出本次循环
            if (large == index){
                break;
            }
            swap(arr, index, large);
            index = large;
            left = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int index, int large){
        int temp = arr[index];
        arr[index] = arr[large];
        arr[large] = temp;
    }
}
