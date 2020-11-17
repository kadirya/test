package algorithm.queue_stack;


public class LinkedListImplementationToQueueAndStack {
    public static class Node<T>{
        public T value;
        public Node<T> next;
        public Node<T> last;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class DoubbleEndsqueue<T>{
        public Node<T> head;  //头指针
        public Node<T> tail;  //尾指针


        public void addFromHead(T value){
            Node<T> curr = new Node<T>(value);
            if(head != null){
                curr.next = head;
                head.last = curr;
                head = curr;

            }else{
                head = curr;
                tail = curr;
            }
        }

        public void addFromBottom(T value){
            Node<T> curr = new Node<>(value);
            if (tail == null){
                head = curr;
                tail = curr;
            }else{
                curr.last = tail;
                tail.next=curr;
                tail = curr;
            }
        }


        public T popFormHead(){
            if (head == null){
                return null;
            }
            Node<T> curr =head;
            if (head == tail){
                head = null;
                tail = null;
            }else{
                head = head.next;
                head.last = null;
                curr.next = null;
            }

            return curr.value;

        }


        public T popFormBottom(){
            if (tail == null){
                return null;
            }
            Node<T> curr =tail;
            if (head == tail){
                head = null;
                tail = null;
            }else{
                tail = tail.last;
                tail.next = null;
                curr.last = null;
            }
            return curr.value;
        }

    }


    public class myQueue<T>{
        private DoubbleEndsqueue<T> queue;

        public myQueue(DoubbleEndsqueue<T> queue) {
            this.queue = queue;
        }

        public void push(T value){
           queue.addFromHead(value);
        }

        public T pop(){
            return queue.popFormBottom();
        }
    }



    public class myStack<T>{
        private  DoubbleEndsqueue<T> stack;

        public myStack(DoubbleEndsqueue<T> stack) {
            this.stack = stack;
        }


        public void push(T value){
            stack.addFromHead(value);
        }

        public T pop(){
            return stack.popFormHead();
        }
    }
}
