package 图书管理系统;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class BookManager {
    private List<Book> bookList=new ArrayList<>(); //所有图书列表
    private List<BorrowRecord> recordList=new ArrayList<>(); //所有借阅记录列表
    Book b1=new Book("9787302662617","计算机导论：微课视频版","袁方","清华大学出版社","2024-05-01",200,150);
    Book b2=new Book("9787302389668","计算机导论","吕云翔，李沛伦","清华大学出版社","2015-04-01",200,150);
    Book b3=new Book("9787302030829","计算机图形学（第三版）","孙家广等","清华大学出版社","1998-09-01",200,150);
    Book b4=new Book("9787115392275","计算机是怎样跑起来的","（日）矢泽久雄","人民邮电出版社","2015-05-01",200,150);
    Book b5=new Book("9787111407010","算法导论（第三版）","Thomas H. Cormen","机械工业出版社","2013-01-01",200,150);
    //初始化图书列表
    public void initBookList(){
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
    }
    //添加图书
    public boolean addBook(Book book){
        for(int i=0;i<bookList.size();i++){
            Book b=bookList.get(i);
            if(b.getIsbn().equals(book.getIsbn())){
                return false; //ISBN号已存在
            }
        }
        bookList.add(book);
        return true;
    }
    //修改图书信息
    public boolean updateBook(String isbn,Book newBook){
        for(int i=0;i<bookList.size();i++){
            Book b=bookList.get(i);
            if(b.getIsbn().equals(isbn)){
                newBook.setIsbn(isbn);
                bookList.set(i,newBook);
                return true; //更新成功
            }
        }
        return false; //未找到该图书
    }
    //删除图书
    public boolean deleteBook(String isbn){
        for(int i=0;i<bookList.size();i++){
            Book b=bookList.get(i);
            if(b.getIsbn().equals(isbn)){
                bookList.remove(i);
                return true; //删除成功
            }
        }
        return false; //未找到该图书
    }
    //查询图书
    public List<Book> searchBook(String keyword,boolean isbnSearch){
        List<Book> result=new ArrayList<>(); //创建结果列表
        for(int i=0;i<bookList.size();i++){
            Book b=bookList.get(i);
            if(isbnSearch){
                if(b.getIsbn().equals(keyword)){
                    result.add(b);
                }
            }
            else{
                if(b.getTitle().contains(keyword)){ //判断书名是否包含关键字
                    result.add(b);
                }
            }
        }
        return result;
    }
    //借阅图书
    public boolean borrowBook(String isbn,String borrowerName,String borrowerId){
        for(int i=0;i<bookList.size();i++){
            Book b=bookList.get(i);
            if(b.getIsbn().equals(isbn)){
                if(b.getAvailableCount()>0){ //判断是否可借
                    b.setAvailableCount(b.getAvailableCount()-1); //可借阅-1
                    BorrowRecord r=new BorrowRecord(borrowerName,borrowerId,isbn,LocalDate.now());
                    recordList.add(r); //添加借阅记录
                    return true; //借阅成功
                }
                else{
                    return false; //该书已被借完
                }
            }
        }
        return false; //未找到该图书
    }
    //归还图书
    public boolean returnBook(String isbn,String borrowerId){
        for(int i=0;i<recordList.size();i++){
            BorrowRecord r=recordList.get(i);
            if(r.getBookIsbn().equals(isbn)&&r.getBorrowerId().equals(borrowerId)&&r.getReturnDate()==null){ //判断是否归还
                r.setReturnDate(LocalDate.now()); //更新归还日期
                for(int j=0;j<bookList.size();j++){
                    Book b=bookList.get(j);
                    if(b.getIsbn().equals(isbn)){
                        b.setAvailableCount((b.getAvailableCount()+1)); //可借阅+1
                        return true; //归还成功
                    }
                }
            }
        }
        return false; //未找到该书借阅记录
    }
    public List<Book> getBookList(){
        return bookList;
    }
    public List<BorrowRecord> getRecordList(){
        return recordList;
    }
}
