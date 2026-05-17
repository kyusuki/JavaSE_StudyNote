package 图书管理系统;

public class ClearScreen {
    public void cleanScreen(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            for(int i=0;i<50;i++){
                System.out.println();
            }
        }
    }
}
