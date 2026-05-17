package 图书管理系统;
import java.util.Scanner;
import java.util.List;
public class BookTest {
    private Scanner sc; //声明Scanner对象而不再创建
    private static BookManager mg=new BookManager();
    private static User currentUser; //声明当前用户
    public BookTest(Scanner sc){
        this.sc=sc;
    }
    public void test(User u){
        mg.initBookList(); //初始化图书列表
        currentUser=u;
        boolean isReturn=true;
        //int port=sc.nextInt();
        //currentUser.setUserType(port);
        System.out.println("登录成功，已进入"+(currentUser.getUserType()==1?"管理员":"用户")+"端口");
        while(isReturn){
            showMenu();
            int choice=sc.nextInt();
            if(currentUser.getUserType()==0&&choice>=1&&choice<=3){
                System.out.println("无权限操作，请重新输入");
                continue;
            }
            switch(choice){
                case 1->addBook();
                case 2->updateBook();
                case 3->deleteBook();
                case 4->searchBook();
                case 5->borrowBook();
                case 6->returnBook();
                case 7->showBooks();
                case 8->countBooks();
                case 9->{
                    System.out.println("已退出系统，返回主界面");
                    isReturn=false;
                }
                default->System.out.println("输入错误，请重新输入");
            }
            System.out.println();
        }
    }
    //菜单
    public void showMenu(){
        System.out.println("----图书管理系统----");
        if(currentUser.getUserType()==1){
            System.out.println("    1.添加图书");
            System.out.println("    2.修改图书信息");
            System.out.println("    3.删除图书");
            System.out.println("    4.查询图书");
            System.out.println("    5.借阅图书");
            System.out.println("    6.归还图书");
            System.out.println("    7.显示所有图书");
            System.out.println("    8.统计图书信息");
            System.out.println("    9.退出系统");
            System.out.print("请输入功能（1-9）：");
        }
        else if(currentUser.getUserType()==0){
            System.out.println("    1.添加图书");
            System.out.println("    2.修改图书信息");
            System.out.println("    3.删除图书");
            System.out.println("    4.查询图书");
            System.out.println("    5.借阅图书");
            System.out.println("    6.归还图书");
            System.out.println("    7.显示所有图书");
            System.out.println("    8.统计图书信息");
            System.out.println("    9.退出系统");
            System.out.print("请输入功能（4-9）：");
        }
    }
    //添加操作
    public void addBook(){
        System.out.println("----添加图书----");
        System.out.print("请输入ISBN号：");
        String isbn=sc.next();
        System.out.print("请输入书名：");
        String title=sc.next();
        System.out.print("请输入作者：");
        String author=sc.next();
        System.out.print("请输入出版社：");
        String publisher=sc.next();
        System.out.print("请输入出版日期（格式：YYYY-MM-DD）：");
        String publishDate=sc.next();
        System.out.print("请输入总藏书量（正整数）：");
        int totalCount=sc.nextInt();
        System.out.print("请输入当前库存（正整数）：");
        int availableCount=sc.nextInt();
        Book newBook=new Book(isbn,title,author,publisher,publishDate,totalCount,availableCount);
        boolean isSuccess=mg.addBook(newBook);
        if(isSuccess){
            System.out.println("添加成功");
        }
        else{
            System.out.println("添加失败,ISBN号已存在");
        }
    }
    //修改操作
    public void updateBook(){
        System.out.println("----修改图书信息----");
        System.out.print("请输入要修改的ISBN号：");
        String isbn=sc.next();
        List<Book> b=mg.searchBook(isbn, true);
        if(b.isEmpty()){ //判断图书是否存在
            System.out.println("未找到该ISBN号的图书，修改失败");
            return;
        }
        System.out.print("请输入新书名：");
        String title=sc.next();
        System.out.print("请输入新作者：");
        String author=sc.next();
        System.out.print("请输入新出版社：");
        String publisher=sc.next();
        System.out.print("请输入新出版日期（格式：YYYY-MM-DD）：");
        String publishDate=sc.next();
        System.out.print("请输入新总藏书量（正整数）：");
        int totalCount=sc.nextInt();
        System.out.print("请输入新当前库存（正整数）：");
        int availableCount=sc.nextInt();
        Book newBook=new Book(isbn,title,author,publisher,publishDate,totalCount,availableCount);
        boolean isSuccess=mg.updateBook(isbn, newBook);
        if(isSuccess){
            System.out.println("修改成功");
        }
        else{
            System.out.println("修改失败，ISBN号不存在");
            return;
        }
    }
    //删除操作
    public void deleteBook(){
        System.out.println("----删除图书----");
        System.out.print("请输入要删除的ISBN号：");
        String isbn=sc.next();
        List<Book> b=mg.searchBook(isbn, true);
        if(b.isEmpty()){
            System.out.println("未找到该ISBN号的图书，删除失败");
            return;
        }
        boolean isSuccess=mg.deleteBook(isbn);
        if(isSuccess){
            System.out.println("删除成功");
        }
        else{
            System.out.println("删除失败，ISBN号不存在");
            return;
        }
    }
    //查询操作
    public void searchBook(){
        System.out.println("----查询图书----");
        System.out.println("1.根据ISBN号查询");
        System.out.println("2.根据书名查询");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.print("请输入要查询的ISBN号：");
            String isbn=sc.next();
            List<Book> b=mg.searchBook(isbn,true);
            if(b.isEmpty()){
                System.out.println("未找到该ISBN号的图书");
                return;
            }
            else{
                for(int i=0;i<b.size();i++){
                    Book book=b.get(i);
                    printBook(book);
                }
            }
        }
        else if(choice==2){
            System.out.print("请输入要查询的书名：");
            String title=sc.next();
            List<Book> b=mg.searchBook(title, false);
            if(b.isEmpty()){
                System.out.println("未找到该书名的图书");
                return;
            }
            else{
                for(int i=0;i<b.size();i++){
                    Book book=b.get(i);
                    printBook(book);
                }
            }
        }
    }
    //借阅操作
    public void borrowBook(){
        System.out.println("----借阅图书----");
        System.out.print("请输入要借阅书的ISBN号；");
        String isbn=sc.next();
        System.out.print("请输入借阅人姓名：");
        String name=sc.next();
        System.out.print("请输入借阅人的学号：");
        String id=sc.next();
        boolean isSuccess=mg.borrowBook(isbn,name,id);
        if(isSuccess){
            System.out.println("借阅成功");
        }
        else{ //判断是没找到还是已借完
            List<Book> b=mg.searchBook(isbn,true);
            if(b.isEmpty()){
                System.out.println("借阅失败，未找到该ISBN对应的书");
            }
            else{
                System.out.println("借阅失败，该书已被借完");
            }
        }
    }
    //归还操作
    public void returnBook(){
        System.out.println("----归还图书----");
        System.out.print("请输入要归还书的ISBN号：");
        String isbn=sc.next();
        System.out.print("请输入归还人的学号：");
        String id=sc.next();
        boolean isSuccess=mg.returnBook(isbn,id);
        if(isSuccess){
            System.out.println("归还成功");
        }
        else{
            System.out.println("归还失败");
        }
    }
    //显示所有图书
    public void showBooks(){
        System.out.println("----图书列表----");
        List<Book> bs=mg.getBookList();
        if(bs.isEmpty()){
            System.out.println("当前无图书");
            return;
        }
        for(int i=0;i<bs.size();i++){
            Book b=bs.get(i);
            printBook(b);
        }
    }
    //统计图书信息
    public void countBooks(){
        System.out.println("----图书统计----");
        List<Book> bs=mg.getBookList();
        int totalCount=0;
        int availableCount=0;
        int borrowCount=0;
        for(int i=0;i<bs.size();i++){
            totalCount++;
            Book b=bs.get(i);
            if(b.getAvailableCount()>0){
                availableCount++;
            }
        }
        borrowCount=totalCount-availableCount;
        System.out.println("总图书数量："+totalCount+"本");
        System.out.println("可借图书数量："+availableCount+"本");
        System.out.println("已借出图书数量："+borrowCount+"本");
    }
    //打印对应图书信息
    public void printBook(Book book){
        System.out.println("ISBN号："+book.getIsbn());
        System.out.println("书名："+book.getTitle());
        System.out.println("作者："+book.getAuthor());
        System.out.println("出版社："+book.getPublisher());
        System.out.println("出版日期："+book.getPublishDate());
        System.out.println("总藏书量："+book.getTotalCount()+"本");
        System.out.println("当前库存："+book.getAvailableCount()+"本");
        System.out.println("当前状态："+(book.getAvailableCount()>0?"可借":"已全部借出"));
    }
}
