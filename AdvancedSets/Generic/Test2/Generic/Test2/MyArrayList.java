package Generic.Test2;

import java.util.Arrays;

public class MyArrayList<E> {
    Object[] obj=new Object[10];
    int size;
    //E：表示不确定的类型，在使用时会确定具体类型   e：表示形参
    public boolean add(E e){
        obj[size]=e;
        size++;
        return true;
    }
    @SuppressWarnings("unchecked")
    public E get(int index){
        return (E)obj[index];
    }
    @Override
    public String toString(){
        return Arrays.toString(obj);
    }
}
