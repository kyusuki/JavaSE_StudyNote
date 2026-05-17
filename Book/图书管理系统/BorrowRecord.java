package 图书管理系统;
import java.time.LocalDate;
public class BorrowRecord {
    private String borrowerName; //借阅人姓名
    private String borrowerId; //借阅人学号
    private String bookIsbn; //所借书ISBN号
    private LocalDate borrowDate; //借阅时间
    private LocalDate returnDate; //归还时间
    public BorrowRecord(){}
    public BorrowRecord(String borrowerName,String borrowerId,String bookIsbn,LocalDate borrowDate){
        this.borrowerName=borrowerName;
        this.borrowerId=borrowerId;
        this.bookIsbn=bookIsbn;
        this.borrowDate=borrowDate;
        this.returnDate=null; //初始默认未归还
    }
    public void setBorrowerName(String borrowerName){
        this.borrowerName=borrowerName;
    }
    public String getBorrowerName(){
        return borrowerName;
    }
    public void setBorrowerId(String borrowerId){
        this.borrowerId=borrowerId;
    }
    public String getBorrowerId(){
        return borrowerId;
    }
    public void setBookIsbn(String bookIsbn){
        this.bookIsbn=bookIsbn;
    }
    public String getBookIsbn(){
        return bookIsbn;
    }
    public void setBorrowDate(LocalDate borrowDate){
        this.borrowDate=borrowDate;
    }
    public LocalDate getBorrowDate(){
        return borrowDate;
    }
    public void setReturnDate(LocalDate returnDate){
        this.returnDate=returnDate;
    }
    public LocalDate getReturnDate(){
        return returnDate;
    }
}
