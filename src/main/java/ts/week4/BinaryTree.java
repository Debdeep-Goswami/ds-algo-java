package ts.week4;

public class BinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public Node insertLevelOrder(int[] array,int position){
        Node temp = null;
        //  Base case
        if(position<array.length){
            temp = new Node(array[position]);

            //  Insert lett child
            temp.left = insertLevelOrder(array,2*position + 1);

            //  Insert right child
            temp.right = insertLevelOrder(array,2*position + 2);
        }
        return temp;
    }
    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }
    public boolean isIdentical(Node root1, Node root2){
        //  If both are null
        if(root1 == null && root2 == null){
            return true;
        }
        //  If either of them is null
        if(root1 == null || root2 == null){
            return false;
        }
        //  If it matches
        if(root1.data == root2.data){
            return isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
        }
        //  For any other case
        return false;
    }
    public boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(subRoot==null){
            return true;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        //  To check if the subRoot data has any match with left or right subtree
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean nodeExists(Node root, int key){
        //  Base case
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(nodeExists(root.left,key)){
            return true;
        }
        if(nodeExists(root.right,key)){
            return true;
        }
        return false;
    }

    public boolean isBST(Node root,int min,int max){
        //  Base case or if tree is null
        if(root==null){
            return true;
        }else{
            if(root.data>max || root.data<min){
                return false;
            }
            return isBST(root.left,min, root.data) && isBST(root.right, root.data, max);
        }
    }

    public static void main(String[] args){

        int[] firstTree = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        BinaryTree binaryTree = new BinaryTree();
        Node mainRoot = binaryTree.insertLevelOrder(firstTree,0);
        binaryTree.inOrder(mainRoot);

//        int[] secondTree = {3,6,6};
//        Node subRoot = binaryTree.insertLevelOrder(secondTree,0);
//
//        System.out.println("\nIs Identical "+binaryTree.isIdentical(mainRoot,subRoot));
//        System.out.println("Is Subtree "+binaryTree.isSubtree(mainRoot,subRoot));
//        System.out.println("\n"+binaryTree.nodeExists(mainRoot,3));

        int[] bstTree = {5,4,6};
        Node root = binaryTree.insertLevelOrder(bstTree,0);
        binaryTree.inOrder(root);
        System.out.println("\n"+binaryTree.isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
