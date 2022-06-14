package ts.week1.MyLinkedList;

public class Execute {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.add("Debdeep");
        mll.add("Goswami");
        mll.add("Software");
        mll.add("Engineer");
        //mll.display();
        //mll.add("Is a ",3);
        //mll.display();
        mll.append("End");
        mll.display();
    }
}
