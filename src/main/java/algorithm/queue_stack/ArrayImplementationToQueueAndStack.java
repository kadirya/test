package algorithm.queue_stack;

//数组实现链表
public class ArrayImplementationToQueueAndStack {

    public static class myQueue{
        private int [] arr;
        private int pushi;
        private int popi;
        private int size;
        private final int limit;

        public myQueue(int limit) {
            this.arr = new int[limit];
            this.pushi = 0;
            this.popi = 0;
            this.size = 0;
            this.limit = limit;
        }


        public void push(int value){

            if (size == limit){
                System.out.println("队列已满！");
                return;
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }


        public int pop(){
            if (size == 0){
                System.out.println("队列为空");
                return 0;
            }
            size--;
            int Result = arr[popi];
            popi = nextIndex(popi);
            return Result;
        }

//        当前下标为i，返回下一个下标位置
        private int nextIndex(int i) {
            return pushi < limit-1 ? i+1 : 0;
        }
    }

    public static class myStack{
        private int [] arr;
        private int index;
        private final int limit;


        public myStack(int limit) {
            this.arr = new int[limit];
            this.index = 0;
            this.limit = limit;
        }

        public void push(int value){
            if (index == limit){
                System.out.println("栈已满！");
                return;
            }
            arr[index] = value;
            index++;
        }

        public int pop(){
            if (index == 0){
                System.out.println("栈为空！");
                return 0;
            }
            int result = arr[index-1];
            index--;
            return result;
        }
    }
}
