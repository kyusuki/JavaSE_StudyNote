package taskSix.Demo1;

public interface Behave {
    public abstract void woof();
    public default void play(){
        System.out.println("喜欢带一段");
    }
    public default void eat(){
        System.out.println("喜欢吃哦马脊里");
    }
}
