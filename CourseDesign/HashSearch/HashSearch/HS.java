package HashSearch;

import HashSearch.hashSearch.hashTable;

public class HS {
    public static void hashSearchTest(){
        hashTable hs=new hashTable(10); //创建一个哈希表，容量为10
        hs.insert("a",1);
        hs.insert("b",2);
        hs.insert("c",3);
        long time1=System.nanoTime();
        System.out.println(hs.search("a"));
        long time2=System.nanoTime();
        System.out.println("查找a耗时："+(time2-time1)+"纳秒");
        long time3=System.nanoTime();
        System.out.println(hs.search("b"));
        long time4=System.nanoTime();
        System.out.println("查找b耗时："+(time4-time3)+"纳秒");
        long time5=System.nanoTime();
        System.out.println(hs.search("c"));
        long time6=System.nanoTime();
        System.out.println("查找c耗时："+(time6-time5)+"纳秒");
        System.out.println(hs.search("d"));
        hs.delete("b");
        System.out.println(hs.search("b"));
    }
}
class hashSearch{
    //创建哈希节点
    static class Node{
        String key; //键值
        int value; //值
        Node next; //指向下一个节点
        public Node(String key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    //创建哈希表
    static class hashTable{
        private Node[] table; //哈希表数组
        private int size; //哈希表大小（记录元素的数量）
        private int capacity; //哈希表容量
        private final double LOAD_FACTOR=0.75; //负载因子阈值
        public hashTable(int capacity){
            this.capacity=capacity;
            this.size=0;
            this.table=new Node[capacity];
        }
        //计算哈希索引值
        private int hash(String key){
            int hash=0; //初始哈希索引值为0
            for(int i=0;i<key.length();i++){
                char c=key.charAt(i); //获取当前字符，计算时用对应的ASCII码
                hash=(hash*31+c)%capacity;
            }
            return Math.abs(hash);
        }
        //插入键值对，这里用链地址法解决冲突
        public void insert(String key,int value){
            /*
             * 检查是否需要扩容
             * 细节：负载因子=已用空间/总空间
             *      而负载因子与冲突概率密切相关
             *      负载因子=0.5时，冲突概率最小
             *      负载因子=0.75时，冲突平衡点
             *      负载因子=1.0时，冲突概率最大
             */
            if((double)size/capacity>=LOAD_FACTOR){
                resize(2*capacity); //当超过负载因子时，扩容为原来的两倍
            }
            int index=hash(key); //获取当前键值的哈希索引
            Node newNode=new Node(key,value);
            //哈希表为空时，直接插入
            if(table[index]==null){
                table[index]=newNode; //哈希表为空，把这个节点直接插在这个位置上
                size++;
                return;
            }
            //哈希表不为空时，遍历链表，找到是否有相同键值对
            Node current=table[index]; //创建current临时指针变量
            while(current!=null){
                if(current.key.equals(key)){
                    current.value=value; //找到相同键值对，更新值
                    return;
                }
                if(current.next==null){
                    break; //没有找到，插到链表末尾
                }
                current=current.next; //没有找到，继续遍历下一个
            }
            current.next=newNode; //没有找到，插到链表末尾
            size++; //每次插入新节点，哈希表大小加1
        }
        //查找键对应的值
        public int search(String key){
            int index=hash(key);
            Node current=table[index];
            //遍历链表，找到匹配的键值
            while(current!=null){
                if(current.key.equals(key)){
                    return current.value; //找到就直接返回对应值
                }
                current=current.next; //没找到，继续遍历找
            }
            return -1; //遍历结束都没有找到，返回-1
        }
        //删除键值对
        public boolean delete(String key){
            int index=hash(key);
            Node current=table[index];
            Node prev=null; //记录前一个节点
            //查找要删除的节点
            while(current!=null){
                if(current.key.equals(key)){
                    break;
                }
                prev=current; //把前面的节点用当前节点覆盖
                current=current.next; //继续找
            }
            //没有找到要删除的节点
            if(current==null){
                return false;
            }
            //删除节点
            if(prev==null){
                table[index]=current.next; //如果前一个结点是头节点，直接用下一个节点覆盖
            }
            else{
                prev.next=current.next; //不是头结点时，用当前节点的下一个节点去覆盖
            }
            size--; //每次删除，都要减小哈希表大小
            return true; //返回true，此时已删除成功
        }
        //扩容方法
        private void resize(int newCapacity){
            Node[] newTable=new Node[newCapacity]; //创建新的哈希表数组
            capacity=newCapacity;
            size=0; //每次扩容时，哈希表大小都要重给为0
            //遍历原来的哈希表，把所有节点重新哈希到新的哈希表中
            for(Node node:newTable){
                Node current=node;
                while(current!=null){
                    insert(current.key,current.value);
                    current=current.next;
                }
            }
        }
    }
}
