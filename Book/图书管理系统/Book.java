package 图书管理系统;

public class Book {
    private String isbn; //ISBN号
    private String title; //书名
    private String author; //作者
    private String publisher; //出版社
    private String publishDate; //出版日期
    private int totalCount; //总书量
    private int availableCount; //可借书量
    public Book(){}
    public Book(String isbn,String title,String author,String publisher,String publishDate,int totalCount,int availableCount){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.publishDate=publishDate;
        this.totalCount=totalCount;
        this.availableCount=availableCount;
    }
    public void setIsbn(String isbn){
        this.isbn=isbn;
    }
    public String getIsbn(){
        return isbn;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public String getPublisher(){
        return publisher;
    }
    public void setPublishDate(String publishDate){
        this.publishDate=publishDate;
    }
    public String getPublishDate(){
        return publishDate;
    }
    public void setTotalCount(int totalCount){
        this.totalCount=totalCount;
    }
    public int getTotalCount(){
        return totalCount;
    }
    public void setAvailableCount(int availableCount){
        this.availableCount=availableCount;
    }
    public int getAvailableCount(){
        return availableCount;
    }
}
