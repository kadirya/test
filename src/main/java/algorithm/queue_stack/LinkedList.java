package algorithm.queue_stack;

//链表数据类型
public class LinkedList {
    public static class Node{
        public int value;
        public Node next;
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
    }

    /**
     * 单链表 顺序倒过来
     * @param head
     * @return

    第一步记录头的next
    第二步把头的next指向pre（pre是记录前一个头，所以初始值为null）
    记录pre ，把当前头的值赋给它
    头指向next，把头改成原来的next
     */
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;
    }


    public static DoubleNode reverseDoubleLinkedList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;

        }
        return pre;
    }


//删除单链表里面所有的值为num的元素
    public static Node removeValue(Node head, int num){
        while(head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        Node pre = head;  //上一个不等于num的位置
        Node curr = head;  //遍历
        while(curr != null){
            if(curr.value == num){
                pre.next = curr.next;
            }else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
