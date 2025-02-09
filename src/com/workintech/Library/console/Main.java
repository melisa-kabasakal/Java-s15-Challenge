package com.workintech.Library.console;

import com.workintech.Library.models.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("Yaşar Kemal");
        Author author2 = new Author("Vladimir Bartol");
        Author author3 = new Author("Cervantes");

        Book book1 = new Book(1L, author1, "İnce Memed", new Date(), 20.50 );
        Book book2 = new Book(2L, author2, "Alamut Kalesi", new Date(), 23.50 );
        Book book3 = new Book(3L, author3, "Don Quijote", new Date(), 25.50 );

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        //ID ile kitap ara:
        Book searchBookId = library.findBookById(1L);
        if(searchBookId != null){
            searchBookId.toString();
        }

        //Kitap ismi ile:
        Book searchedBookByName = library.findBookByName("Don Quijote");
        if(searchedBookByName != null){
            searchedBookByName.toString();
        }

        // Yazar adına göre kitabını bul:
        System.out.println("Author: " );
        for(Book book : library.findBooksByAuthor(author3)){
            book.toString();
        }

        //Kitap bilgilerini güncelleme:
        System.out.println("update: ");
        library.updateBook(2L, "Alamut Kalesi", author2, "in stock", "3rd Edition", 21.0 );

        // Kitap silme:
        library.removeBook(1L);

        //Kütüphaneden kitap verme:

        Reader reader1 = new Reader("Melisa");
        library.lendBook(book1, reader1);

        System.out.println(book1);

        // MemberRecord
        MemberRecord member = new MemberRecord(1L, "Student", new Date(), 0, "Melisa Kabasakal", "5364401092", "Ankara");

        // Başlangıçtaki kitap sayısı
        System.out.println("No books issued: " + member.getNoBooksIssued()); // 0

        // Kitap ekleme
        member.incBookIssued();
        member.incBookIssued();
        System.out.println("No books issued after borrowing: " + member.getNoBooksIssued());

        // Kitap iade etme
        member.decBookIssued();
        System.out.println("No books issued after returning: " + member.getNoBooksIssued());

        // Üye ödeme yaptı
        member.payBill();

        // Üye bilgileri
        member.whoyouare();


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Kitap arama
        Librarian librarian = new Librarian("Ali", "password123");

        // Kitap arama
        System.out.println("Searching for 'Alamut Kalesi':");
        Book searchedBook = librarian.searchBook(library.getBooks(), "Alamut Kalesi");
        if (searchedBook != null) {
            System.out.println("Found: " + searchedBook);
        }


    }
}
