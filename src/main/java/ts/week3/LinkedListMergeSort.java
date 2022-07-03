package ts.week3;

public class LinkedListMergeSort {

    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node head;
    public static Node addNode(Node head, int data){
        Node temp = head;

        if(temp == null){
        //  Very First node insertion
            Node newNode = new Node(data);
            head=newNode;
        }else{
        //  Inserting node at the end
            while(temp.next!=null){
                temp=temp.next;
            }
            Node newNode = new Node(data);
            temp.next=newNode;
            head = temp;
        }
        return head;
    }
    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //System.out.println("The middle element is "+slow.data);
        return slow;
    }
    public static Node mergeList(Node one,Node two){
        Node result = null;

        //  Base case
        if(one==null){
            return two;
        }
        if(two==null){
            return one;
        }

        //  Recursive call to merge
        if(one.data< two.data){
            result = one;
            result.next=mergeList(one.next,two);
        }else{
            result = two;
            result.next=mergeList(two.next,one);
        }
        return result;
    }
    public static Node mergeSort(Node head){

        //  Base case to check if list is empty or has a single element
        if(head == null || head.next == null){
            return head;
        }

        //  Get the middle node
        Node mid = findMid(head);

        //  Breaking the list into two halves
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        //  Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        //  Merge both left and right halves
        Node sortedList = mergeList(left,right);
        return sortedList;
    }
    public static void displayList(Node start){
        Node temp = start;
        while(temp!=null){
            System.out.println(" "+temp.data);
            temp=temp.next;
        }
    }

    public static void displayList(Node start, Node end){
        Node temp = start;
        while(temp!=end){
            System.out.println(" "+temp.data);
            temp=temp.next;
        }
    }

    public static void main(String[] args){
        LinkedListMergeSort linkedListMergeSort = new LinkedListMergeSort();
        Node head =  linkedListMergeSort.head;
        head= addNode(head,30);
        addNode(head,20);
        addNode(head,10);
        addNode(head,40);
        addNode(head,50);

//        displayList(head);
//
//        System.out.println("______________________________");
//
//        Node mid = findMid(head);
//        displayList(head,mid);
//        System.out.println("_____________________");
//        displayList(mid);

        head = mergeSort(head);
        displayList(head);
    }
}
