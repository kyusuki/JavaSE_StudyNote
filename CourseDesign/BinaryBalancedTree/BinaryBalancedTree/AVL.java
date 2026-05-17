package BinaryBalancedTree;

import java.util.Scanner;

public class AVL {
    public static void binaryBalancedTreeTest(Scanner sc){
        @SuppressWarnings("resource")
        //Scanner sc=new Scanner(System.in);
        binaryBalancedTree bbt=new binaryBalancedTree();
        System.out.print("请输入节点数：");
        int n=sc.nextInt();
        System.out.print("请输入节点值：");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            bbt.insert(value);
        }
        while(true){
            System.out.println("1.查看树的结构 2.查找节点 3.删除节点 4.退出");
            int choice=sc.nextInt();
            switch(choice){
                case 1:{
                    bbt.printTree();
                    break;
                }
                case 2:{
                    System.out.print("请输入要查找的节点值：");
                    int target=sc.nextInt();
                    long time1=System.nanoTime();
                    boolean result=bbt.search(target);
                    long time2=System.nanoTime();
                    if(result){
                        System.out.println("节点存在");
                    }
                    else{
                        System.out.println("节点不存在");
                    }
                    System.out.println();
                    System.out.println("查找耗时："+(time2-time1)+"纳秒");
                    break;
                }
                case 3:{
                    System.out.print("请输入要删除的节点值：");
                    int target=sc.nextInt();
                    if(!(bbt.search(target))){
                        System.out.println("该节点不存在");
                        break;
                    }
                    bbt.delete(target);
                    System.out.println("删除成功");
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
class binaryBalancedTree{
    class TreeNode{
        private int value; //记录节点值
        private int height; //记录节点高度
        private TreeNode left; //记录左子节点
        private TreeNode right; //记录右子节点
        public TreeNode(int value){
            this.value=value;
            this.height=1; //每一个新节点高度都为1
        }
    }
    TreeNode root; //记录根节点
    //获取节点高度
    private int getHeight(TreeNode root){
        if(root==null){
            return 0; //空节点高度为0
        }
        return root.height;
    }
    //更新节点高度
    private void updateHeight(TreeNode root){
        if(root==null){
            return; //空节点高度不用更新
        }
        root.height=Math.max(getHeight(root.left),getHeight(root.right))+1; //计算节点高度的公式
    }
    //获取节点的平衡因子
    private int getBalanceFactor(TreeNode root){
        if(root==null){
            return 0; //节点为空时平衡因子0
        }
        /*
         * 平衡因子等于左子树高度与右子树高度的差值
         * 细节：
         * 当返回值大于1时，说明左子树高度大于右子树高度
         * 当返回值小于-1时，说明右子树高度大于左子树高度    
         */
        return getHeight(root.left)-getHeight(root.right);
    }
    //左旋转
    private TreeNode leftRotate(TreeNode root){
        TreeNode newRoot=root.right;
        TreeNode temp=newRoot.left;
        newRoot.left=root;
        root.right=temp;
        updateHeight(newRoot); //更新新根节点高度
        updateHeight(root); //更新旧根节点高度
        return newRoot; //把新根节点返回
    }
    //右旋转
    private TreeNode rightRotate(TreeNode root){
        TreeNode newRoot=root.left;
        TreeNode temp=newRoot.right;
        newRoot.right=root;
        root.left=temp;
        updateHeight(newRoot); //更新新根节点高度
        updateHeight(root); //更新旧根节点高度
        return newRoot; //把新根节点返回
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
        else{
            return root; //节点值相等情况，不进行插入
        }
        updateHeight(root); //更新节点高度
        int blanceRecord=getBalanceFactor(root); //获取节点平衡因子
        if(blanceRecord<=1){
            return root; //平衡因子小于等于1，没有破坏平衡，不需要处理
        }
        /*
         * 情况1：左左  解决：一次右旋
         * 细节：这里的getBalanceFactor(root.left)>=0解释
         *      当blanceRecode>1时，说明首先是左的情况
         *      再次调用计算平衡因子的方法，参数就是该节点的左子节点
         *      当这个调用的结果大于等于0时，说明左子树高度还是大于右子树高度
         *      符合左左情况
         */
        if(blanceRecord>1&&getBalanceFactor(root.left)>=0){
            return rightRotate(root);
        }
        /*
         * 情况2：右右  解决：一次左旋
         * 细节：同情况1类似
         *      只是现在的方法调用的参数是该节点的右子节点
         *      后面方法返回情况就与情况1一致
         */
        if(blanceRecord<-1&&getBalanceFactor(root.right)<=0){
            return leftRotate(root);
        }
        /*
         * 情况3：左右  解决：先局部左旋，再整体右旋
         * 细节：同上
         *      只是现在getBlanceFactor(root.left)方法的返回值小于0
         */
        if(blanceRecord>1&&getBalanceFactor(root.left)<0){
            root.left=leftRotate(root.left); //局部左旋，变为左左情况
            return rightRotate(root); //整体右旋
        }
        /*
         * 情况4：右左  解决：先局部右旋，再整体左旋
         * 细节：与情况3类似
         *      在getBlancedFactor(root.right)方法中，返回值大于0
         */
        if(blanceRecord<-1&&getBalanceFactor(root.right)>0){
            root.right=rightRotate(root.right); //局部右旋，变为右右情况
            return leftRotate(root); //整体左旋
        }
        return root; //最后返回根节点
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
            return null; //节点为空直接返回null
        }
        if(target==root.value){
            //情况1：删除的节点为叶子节点
            if(root.right==null&&root.left==null){
                return null; //直接用null代替这个节点返回
            }
            //情况2：删除的节点只有一个子节点
            if(root.left==null){
                return root.right; //用右子节点代替这个节点
            }
            if(root.right==null){
                return root.left; //用左子节点代替这个节点
            }
            //情况3：删除的节点有两个子节点
            int minValue=findMinValue(root.right); //调用方法找到右子树中最小节点值
            root.value=minValue; //把当前节点的值用找到的后继节点值替换
            root.right=NodeDelete(root.right,minValue); //右子树的最下节点已变换位置，需将其从树中删除
        }
        updateHeight(root); //重新更新节点高度
        int blanceRecord=getBalanceFactor(root); //再次获取新树的平衡因子，也就是再次判断树是否平衡
        /*
         * 四种情况，具体详见AVL插入的详解
         */
        //情况1：左左
        if(blanceRecord>1&&getBalanceFactor(root.left)>=0){
            return rightRotate(root); //一次整体右旋
        }
        //情况2：左右
        if(blanceRecord>1&&getBalanceFactor(root.left)<0){
            root.left=leftRotate(root.left); //局部左旋
            return rightRotate(root); //整体右旋
        }
        //情况3：右右
        if(blanceRecord<-1&&getBalanceFactor(root.right)<=0){
            return leftRotate(root); //一次整体左旋
        }
        //情况4：右左
        if(blanceRecord<-1&&getBalanceFactor(root.right)>0){
            root.right=rightRotate(root.right); //局部右旋
            return leftRotate(root); //整体左旋
        }
        if(target<root.value){
            root.left=NodeDelete(root.left,target); //左子节点不匹配，继续递归往左子树找
        }
        else if(target>root.value){
            root.right=NodeDelete(root.right,target); //右子节点不匹配，继续递归往右子树找
        }
        return root;
    }
    //找到中序遍历的后继节点，就是找这个节点右子树中的最小节点
    private int findMinValue(TreeNode root){
        if(root.left==null){
            return root.value; //此时左子节点为空，代表已经是最小节点，直接将当前节点值返回
        }
        return findMinValue(root.left); //没找到最小节点，递归继续往左找
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
