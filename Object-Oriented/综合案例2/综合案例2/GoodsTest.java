package 综合案例2;

public class GoodsTest {
    public static void main(String[] args){
        //创建数组
        Goods[] arr=new Goods[3];
        //创建对象
        Goods g1=new Goods("001","尼哥",250.5,100);
        Goods g2=new Goods("002","犹太人",123.4,50);
        Goods g3=new Goods("003","白皮猪",1044,26);
        //将对象添加到数组中
        arr[0]=g1;
        arr[1]=g2;
        arr[2]=g3;
        //遍历数组
        for(int i=0;i<arr.length;i++){
            Goods goods=arr[i];
            System.out.println(goods.getId()+" "+goods.getName()+" "+goods.getPrice()+" "+goods.getNum());
        }
    }
}
