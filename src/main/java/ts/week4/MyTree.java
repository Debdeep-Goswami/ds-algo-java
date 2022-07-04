package ts.week4;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    static class BinaryTree{
        static int index =-1;
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root){
        //  Terminating condition
        if(root==null){
            //  -1 to show null but we can avoid that too
            System.out.print(null+" ");
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        //  Terminating condition
        if(root==null){
            //  -1 to show null but we can avoid that too
            System.out.print(null+" ");
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        //  Terminating condition
        if(root==null){
            System.out.print(null+" ");
            return;
        }
        postorder(root.right);
        postorder(root.left);
        System.out.print(root.data+" ");
    }


    public static void levelorder(Node root){
        if(root==null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else{
                System.out.print(currentNode.data+" ");
                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }
        }

    }

    public static int countOfNodes(Node root){
        //  Base case
        if(root==null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root){
        //  Base case
        if(root==null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int heightofTree(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = heightofTree(root.left);
        int rightHeight = heightofTree(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static int diameterofTree(Node root){
        if(root==null){
            return 0;
        }
        int diam1 = diameterofTree(root.left);
        int diam2 = diameterofTree(root.right);
        int diam3 = heightofTree(root.left) + heightofTree(root.right) + 1;

        return Math.max(diam3,Math.max(diam1,diam2));
    }

    static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height,int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameterofTreeOptimized(Node root){
        if(root==null){
            return new TreeInfo(0,0);
        }

        TreeInfo left = diameterofTreeOptimized(root.left);
        TreeInfo right = diameterofTreeOptimized(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height+right.height+1;

        int myDiameter = Math.max(diam3,Math.max(diam1,diam2));

        TreeInfo myInfo = new TreeInfo(myHeight,myDiameter);
        return myInfo;
    }


    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes);
//        System.out.println(root.data);
//        preorder(root);
//        System.out.println();
//        inorder(root);
//        System.out.println();
//        postorder(root);
//        System.out.println();
//        levelorder(root);

//        System.out.println("Count of nodes = "+countOfNodes(root));
//        System.out.println("Sum of nodes = "+sumOfNodes(root));
//        System.out.println("Height of Tree = "+heightofTree(root));
//        System.out.println("Diameter of Tree = "+diameterofTree(root));
        System.out.println("Diameter of Tree = "+diameterofTreeOptimized(root).diameter);
    }
}
