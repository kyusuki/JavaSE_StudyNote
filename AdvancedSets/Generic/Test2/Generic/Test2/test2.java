package Generic.Test2;

public class test2 {
    public static void main(String[] args){
        MyArrayList<String> list=new MyArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);
        System.out.println(list.get(1));
    }
}
