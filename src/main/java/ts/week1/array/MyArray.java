package ts.week1.array;

public class MyArray {
    String [] names = new String[10];

    public void insert(){
        names[0] = "Debdeep";
        names[1] = "Goswami";
        names[3] = "Kolkata";
     }

     public void display(){
        for (String name : names){
            System.out.println(name);
        }
     }
     public static void main(String[] args){
        MyArray ma = new MyArray();
        ma.insert();
        ma.display();
     }
}
