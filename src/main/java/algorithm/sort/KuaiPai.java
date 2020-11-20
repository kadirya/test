package algorithm.sort;

public class KuaiPai {
    


    /**
     *
     * @return
     * 去一个随机元素m  在下标为0-n数组中  比m小的所有元素放左边  等于m的再中间 大于m的放右边
     * 从a[0]开始，从左往右跟 m 比较   小于区在a[-1]位置， 大于区在a[n]位置
     * 若 a[i] == m ,i++
     * a[i] < m  a[i]与小于区右一个交换  小于区向右扩一个元素，i++
     * a[i] > m  a[i]与大于区左一个交换，大于区向左扩一个元素，i不变（因为我们比较从左开始，跟右边交换的元素是我们还没看所以不++，先看；而左边交换过来的元素因为已经看完了所以需要交换）
     *
     */

    public void process(int[] arr, int L, int R){
        if (L < R){
            return;
        }
        //L-R之间的随机一个下标： L + (int)Math.random() * (R - L + 1)
        //先把随机下标跟R位置的数交换，就变成了荷兰国旗问题
        swap(arr, L + (int)Math.random() * (R - L + 1), R);
        int[] equalarea = netherlandsFlag(arr, L, R);
        process(arr, L,equalarea[0] -1);
        process(arr, equalarea[1] + 1, R);
    }


    //a[L...R]的荷兰国旗国企问题, 以arr[R]划分
    // 小于区：<arr[R]  等于区：arr[R]  大于区：>arr[R]

    public static int[] netherlandsFlag(int arr[], int L, int R){
        if(R < L){
            return new int[] {-1,-1};
        }
        if(L == R){
            return new int[]{L,R};
        }
        int less = L-1;  //小于区
        int more = R;    //大于区   先不动arr[R]，所以大于区先包含它
        int index = L;
        while (index < more){
            if (arr[index] == arr[R]){
                index++;
            } else if (arr[index] < arr[R]){
                //当前元素和小于区又一个交换，小于区往右扩一个位置（也就是先把小于区向右扩一个，然后小于区最后一个元素和当前元素交换  一个意思啦~）
                swap(arr, index++, ++less);
            } else {
                //跟小于区一个道理
                swap(arr, index, --more);
            }
            //more是大于区的第一个数，交换完arr[R]来到等于区了
            // 小于区：L---less  等于区：less+1---more  大于区：more+1---R
            swap(arr,R,more);

        }
        return new int[]{less+1, more};      //返回等于区？
    }


    public static int partition(){

        return 0;
    }




    public static void swap(int[] arr, int index, int R){
        int temp = arr[index];
        arr[index] = arr[R];
        arr[R] = temp;
    }
}
