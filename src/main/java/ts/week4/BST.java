package ts.week4;

import java.util.ArrayList;

public class BST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            root = new Node(data);
            return root;
        }
        if(data<root.data){
            //  To be inserted in left side
            root.left = insert(root.left,data);
        }else{
            //  To be inserted in right side
            root.right = insert(root.right,data);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root,int key){
        //  Time complexity O{h}  h = height of the tree
        if(root==null){
            //  Not found
            return false;
        }
        if(key==root.data){
            //  Data found
            return true;
        }else if(key<root.data){
            //  Search Left Subtree
            return search(root.left,key);
        }else {
            //  Search Right Subtree
            return search(root.right,key);
        }
    }

    public static Node delete(Node root, int key){
        if(key < root.data){
            root.left = delete(root.left,key);
        }else if(key> root.data ){
            root.right = delete(root.right,key);
        }else{
            //  We found the node to be deleted

            //  case 1 ( Node with No child )
            if(root.left==null && root.right==null){
                return null;
            }

            //  case 2 ( Node with one child )
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            //  case 3 ( Node with two child )
            Node ins = inorderSuccessor(root.right);
            root.data = ins.data;
            root.right = delete(root.right,ins.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void printInRange(Node root,int begin,int end){
        //  Base case
        if(root==null){
            return;
        }

        if(root.data>=begin && root.data <= end){
            //  case 1 where root is in between the range
            printInRange(root.left,begin,end);
            System.out.print(root.data +" ");
            printInRange(root.right,begin,end);
        } else if(root.data > end){
            //  case 2 where the max data is less than root data
            printInRange(root.left,begin,end);
        }else{
            //  case 3 where min data is more than root data
            printInRange(root.right,begin,end);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        //  Base case
        if(root==null){
            return;
        }
        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            //  For leaf node
            printRootToLeaf(root.left,path);
            printRootToLeaf(root.right,path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args){
        int[] values ={8,5,3,1,4,6,10,11,14};

        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }
        inorder(root);
//        if(search(root,20)){
//            System.out.println("Data found in the tree");
//        }else{
//            System.out.println("Data not found");
//        }

        delete(root,10);
        System.out.println();
        inorder(root);
        insert(root,10);
        System.out.println();
        inorder(root);
        delete(root,14);
        System.out.println();
        inorder(root);

        System.out.println("\nPrint in Range");
        printInRange(root,5,10);
        System.out.println("\nAll root to leaf paths in the tree");
        printRootToLeaf(root,new ArrayList<Integer>());
    }
}
