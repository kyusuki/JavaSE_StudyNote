import BasicSearch.BS;
import BinarySearch.BiS;
import InterpolationSearch.IS;
import FibonacciSearch.FS;
import BlockSearch.BS1;
import BinarySearchTree.BST;
import BinaryBalancedTree.AVL;
import HashSearch.HS;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){ 
            showMenu();
            int choice=sc.nextInt();
            switch(choice){
                case 1:{
                    BS.basicSearchTest(sc);
                    break;
                }
                case 2:{
                    BiS.binarySearchTest(sc);
                    break;
                }
                case 3:{
                    IS.interpolationSearchTest(sc);
                    break;
                }
                case 4:{
                    FS.fibonacciSearchTest(sc);
                    break;
                }
                case 5:{
                    BS1.blockSearchTest(sc);
                    break;
                }
                case 6:{
                    HS.hashSearchTest();
                    break;
                }
                case 7:{
                    BST.binarySearchTreeTest(sc);
                    break;
                }
                case 8:{
                    AVL.binaryBalancedTreeTest(sc);
                    break;
                }
                case 9:{
                    redBlackTreeTest();
                    break;
                }
                case 0:{
                    System.out.println("已退出");
                    System.exit(0);
                }
            }
        }
    }
    //展示菜单
    public static void showMenu(){
        System.out.println("======九种基本查找======");
        System.out.println("1.基本查找    2.二分查找");
        System.out.println("3.插值查找    4.斐波那契查找");
        System.out.println("5.分块查找    6.哈希查找");
        System.out.println("7.二分查找树  8.平衡二叉树");
        System.out.println("9.红黑树      0.退出");
    }
    public static void redBlackTreeTest(){
        System.out.println("现有能力不足，还无法独自实现红黑树");
    }
}
