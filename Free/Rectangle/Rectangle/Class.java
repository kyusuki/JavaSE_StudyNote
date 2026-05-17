package Rectangle;

public class Class {
    private double length;
    private double width;
    private double area;
    private double perimeter;
    public Class(){}
    public Class(double length,double width){
        this.length=length;
        this.width=width;
        this.area=length*width;
        this.perimeter=2.0*(length+width);
    }
    public void setLength(double length){
        this.length=length;
    }
    public double getLength(){
        return length;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public double getWidth(){
        return width;
    }
    public void setArea(double length,double width){
        this.area=length*width;;
    }
    public double getArea(){
        return area;
    }
    public void setPerimeter(double length,double width){
        this.perimeter=2.0*(length+width);
    }
    public double getPerimeter(){
        return perimeter;
    }
}
