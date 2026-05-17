package BinarySearchTree;

import java.util.Scanner;

public class BST {
    public static void main(String[] args){
        binarySearchTreeTest(new Scanner(System.in));
    }
    public static void binarySearchTreeTest(Scanner sc){
        @SuppressWarnings("resource")
        //Scanner sc=new Scanner(System.in);
        binarySearchTree bst=new binarySearchTree();
        System.out.print("请输入元素个数：");
        int n=sc.nextInt();
        System.out.print("请输入元素：");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            bst.insert(value);
        }
        while(true){
            System.out.println("1.查看树的结构 2.查找节点 3.删除节点 4.退出");
            int choice=sc.nextInt();
            switch(choice){
                case 1:{
                    bst.printTree();
                    break;
                }
                case 2:{
                    System.out.print("请输入要查找的元素：");
                    int target=sc.nextInt();
                    long time1=System.nanoTime();
                    if(bst.search(target)){
                        System.out.println("目标元素存在");
                    }
                    else{
                        System.out.println("目标元素不存在");
                    }
                    long time2=System.nanoTime();
                    System.out.println();
            
                    System.out.println("查找耗时："+(time2-time1)+"纳秒");
                    break;
                }
                case 3:{
                    System.out.print("请输入要删除的节点：");
                    int target=sc.nextInt();
                    if(!(bst.search(target))){
                        System.out.println("该节点不存在");
                        break;
                    }
                    bst.delete(target);
                    System.out.println("目标节点已删除");
                    break;
                }
                case 4:{
                    System.out.println("已退出");
                    System.exit(0);
                }
            }
        }
    }
}
class binarySearchTree{
    class TreeNode{
        private int value; //记录节点值
        private TreeNode left; //记录左子节点
        private TreeNode right; //记录右子节点
        public TreeNode(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }
    private TreeNode root; //记录根节点
    
    public binarySearchTree(){
        this.root=null; //初始化根节点为null
    }
    //插入节点
    public void insert(int value){
        root=NodeInsert(root,value);
    }
    private TreeNode NodeInsert(TreeNode root,int value){
        if(root==null){
            return new TreeNode(value); //如果当前节点为空，则创建一个新的节点
        }
        //小于节点值，递归插入到左子树
        if(value<root.value){
            root.left=NodeInsert(root.left,value);
        }
        //大于节点值，递归输入到右子树
        else if(value>root.value){
            root.right=NodeInsert(root.right,value);
        }
        return root; //返回根节点
    }
    
    //查找节点
    public boolean search(int target){
        return NodeSearch(root,target);
    }
    private boolean NodeSearch(TreeNode root,int target){
        if(root==null){
            return false; //当前节点为空，直接返回false
        }
        
        if(target==root.value){
            return true; //当前节点值被找到，返回true
        }
        //小于节点值，递归查找左子树
        else if(target<root.value){
            return NodeSearch(root.left,target);
        }
        //大于节点值，递归查找右子树
        else if(target>root.value){
            return NodeSearch(root.right,target);
        }
        return false;
    }
    //删除节点
    public void delete(int target){
        root=NodeDelete(root,target);
    }
    private TreeNode NodeDelete(TreeNode root,int target){
        if(root==null){
            return null; //空节点直接返回false
        }
        if(target==root.value){
            //情况1：删除的节点为叶子节点
            if(root.left==null&&root.right==null){
                return null; //直接对当前目标值节点返回null，删除节点
            }
            //情况2：删除的节点只有一个子节点
            if(root.left==null){
                return root.right; //返回右子节点，将目标节点用右子节点替换掉
            }
            if(root.right==null){
                return root.left; //返回左子节点，将目标节点用左子节点替换掉
            }
            //情况3：删除的节点有两个子节点
            /*
             * 细节：这里要用到中序遍历
             * 1.找到右子树中最小值节点
             * 2.用该节点的值替换当前节点
             * 3.删除中序后继节点
             */
            int minValue=findMinValue(root.right); //跳转到右子树去
            root.value=minValue; //用当前后继节点替换目标节点
            root.right=NodeDelete(root.right, minValue); //递归删除这个后继节点
            return root;
        }
        if(target<root.value){
            root.left=NodeDelete(root.left, target); //递归删除左子树中目标节点
        }
        else if(target>root.value){
            root.right=NodeDelete(root.right, target); //递归删除右子树中目标节点
        }
        return root;
    }
    //找到目标节点在中序遍历中的后继节点
    private int findMinValue(TreeNode root){
        if(root.left==null){
            return root.value; //如果左子节点为空，则此节点就是要找的后继节点
        }
        return findMinValue(root.left); //若左子节点不为空，递归继续往左子树找最小节点
    }
    //查看树的结构
    public void printTree() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        PrintTree(root, 0);
    }
    private void PrintTree(TreeNode root,int depth) {
        if(root!=null){
            PrintTree(root.right,depth+1);
            System.out.println("  ".repeat(depth)+root.value);
            PrintTree(root.left,depth+1);
        }
    }
}
/*
样例1：
输入：
5
10 5 15 3 7
 
样例2：
输入：
10
12 3 4 15 7 2 9 22 5 10

样例3：（完全升序）
输入：
6
1 3 5 7 9 11

样例4：（完全降序）
输入：
7
20 18 15 12 9 6 3

样例5：（含重复元素）
输入：
8
8 5 12 5 9 15 3 8

样例6：
输入：
12
25 18 30 10 20 28 35 5 15 22 29 40

样例7：（混合分布）
输入：
15
40 25 50 15 30 45 60 10 20 28 35 42 48 55 70

样例8：（小规模）
输入：
3
9 4 12

样例9：
输入：
20
55 30 70 20 40 60 80 15 25 35 45 58 65 75 85 10 18 22 27 32
*/
