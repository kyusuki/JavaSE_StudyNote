public class 自动驾驶 {
    public static void main(String[] args){
        boolean isLightGreen=false;
        boolean isLightYellow=false;
        boolean isLightRed=true;
        if(isLightGreen){
            System.out.println("go!");
        }
        if(isLightYellow){
            System.out.println("slow!");
        }
        if(isLightRed){
            System.out.println("stop!");
        }
    }
}
