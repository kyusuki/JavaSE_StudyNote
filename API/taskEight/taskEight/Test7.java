package taskEight;

public class Test7 {
    public static void main(String[] args){
        String str="小明12141dfgsg小红，小红cfasfgagzxku小强，小强12415190asfakhjxgc小明";
        //替换
        String result1=str.replaceAll("[\\w&&[^_]]+","喜欢");
        System.out.println(result1);
        
        //切割
        String[] result2=str.split("[\\w&&[^_]]+");
        for(int i=0;i<result2.length;i++){
            System.out.println(result2[i]);
        }
    }
}
