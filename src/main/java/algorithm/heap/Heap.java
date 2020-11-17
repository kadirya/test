package algorithm.heap;

import algorithm.heap.Heap.MyMaxHeap.RightMaxHeap;

public class Heap {
    public static class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty(){
            return heapSize == 0;
        }

        public boolean isFull(){
            return heapSize == limit;
        }

        public void push(int value){
           if(heap[heapSize] == limit){
               throw new RuntimeException("heap is full");
           }
           heap[heapSize] = value;
           heapInsert(heap,heapSize++);
        }

        private void heapInsert(int[] heap, int index) {
            //arr[index] 不比 arr[index父]大了就停
            int rootIndex = (index-1)/2;
            while (heap[index] > heap[rootIndex]){
                swap(heap, index, rootIndex);
                index = rootIndex;
            }

        }


        private int pop(){
            int result = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return result;
        }

        //从index往下看，不断下沉
        //没有孩子比我大 或 已经没有孩子了时停
        private void heapify(int[] arr, int index, int heapSize){
            int left = index * 2 + 1;
            while(left < heapSize){
                //左右孩子中谁大，把谁的低标付给largest
                //有右孩子 并且 右孩子的值大于左孩子得值 才是右 否则左
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index){
                    break;

                }
                swap(arr, index, largest);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void swap(int[] heap, int index, int rootIndex) {
            int temp = heap[index];
            heap[index] = heap[rootIndex];
            heap[rootIndex] = temp;
        }


        public static class RightMaxHeap {
            private int[] arr;
            private final int limit;
            private int size;

            public RightMaxHeap(int limit) {
                arr = new int[limit];
                this.limit = limit;
                size = 0;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public boolean isFull() {
                return size == limit;
            }

            public void push(int value) {
                if (size == limit) {
                    throw new RuntimeException("heap is full");
                }
                arr[size++] = value;
            }

            public int pop() {
                int maxIndex = 0;
                for (int i = 1; i < size; i++) {
                    if (arr[i] > arr[maxIndex]) {
                        maxIndex = i;
                    }
                }
                int ans = arr[maxIndex];
                arr[maxIndex] = arr[--size];
                return ans;
            }

        }




    }

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap my = new MyMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");

    }

}
