package baseclasses;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainLibrary {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Library library=new Library();
        Admin admin=new Admin();
        Book book=new Book();
        Member member=new Member();
        List<Admin> adminList=new ArrayList<>();
        List<Member> memberList=new ArrayList<>();
        List<Book> bookList=new ArrayList<>();
        //----------------------------------------------
        System.out.println("Enter Library id");
        String libraryId=sc.nextLine();
        System.out.println("Enter library name");
        String libraryName=sc.nextLine();
        System.out.println("Enter library location");
        String libraryLocation=sc.nextLine();
//        sc.nextLine();

        //----------------------------------------------
        System.out.println("Enter Book title");
        String bookTitle=sc.nextLine();
        System.out.println("Enter book's isbn");
        String isbn=sc.nextLine();
        System.out.println("Enter Author name");
        String author=sc.nextLine();
        System.out.println("Enter book count");
        int bookCount=sc.nextInt();
        System.out.println("Enter publication year");
        int publicaionYear=sc.nextInt();
        sc.nextLine();
        book.setmAuthor(author);
        book.setmBookCount(bookCount);
        book.setmBookTitle(bookTitle);
        book.setmIsbn(isbn);
        book.setmPublictionYear(publicaionYear);
        bookList.add(book);
        //--------------------------------------------------
        System.out.println("Enter admin name");
        String adminName=sc.nextLine();
        System.out.println("Enter admin location");
        String adminLocation=sc.nextLine();
        System.out.println("Enter admin id");
        String adminId=sc.nextLine();
        System.out.println("Enter admin contact");
        long adminContact=sc.nextLong();
        sc.nextLine();
        admin.setmAdminId(adminId);
        admin.setmAdminContact(adminContact);
        admin.setmAdminLocation(adminLocation);
        admin.setmAdminName(adminName);
        adminList.add(admin);
        //---------------------------------------------
        System.out.println("Enter member name");
        String memberName=sc.nextLine();
        System.out.println("Enter member location");
        String memberLocation=sc.nextLine();
        System.out.println("Enter member id");
        String memberId=sc.nextLine();
        System.out.println("Enter member contact");
        long memberContact=sc.nextLong();
        member.setmMemberId(memberId);
        member.setmMemberContact(memberContact);
        member.setmMemberLocation(memberLocation);
        member.setmMemberName(memberName);
        memberList.add(member);
        //-------------------------
        library.setmLibraryId(libraryId);
        library.setmAdminsList(adminList);
        library.setmBooksList(bookList);
        library.setmLocation(libraryLocation);
        library.setMlibraryName(libraryName);
        library.setmMemberList(memberList);
        System.out.println(library);


    }
}
