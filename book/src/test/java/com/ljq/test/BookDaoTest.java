package com.ljq.test;

import com.ljq.dao.impl.BookDaoimpl;
import com.ljq.pojo.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {

  BookDaoimpl bookDaoimpl = new BookDaoimpl();
  @Test
  void addBook() {

    bookDaoimpl.addBook(new Book(null,"java核心技术卷I","霍斯特曼",new BigDecimal(27.88),500,600,null));
  }

  @Test
  void deleteById() {
    bookDaoimpl.deleteById(21);
  }

  @Test
  void updateBook() {
    bookDaoimpl.updateBook(new Book(21,"java核心技术卷II","霍斯特曼",new BigDecimal(45.88),500,2000,null));
  }

  @Test
  void queryById() {
    Book book = bookDaoimpl.queryById(21);
    System.out.println(book);
  }

  @Test
  void queryBooks() {
    List<Book> books = bookDaoimpl.queryBooks();
    for (Book book : books) {
      System.out.println(book);
    }
  }

  @Test
  void queryForPageTotalCount(){
    Integer integer = bookDaoimpl.queryForPageTotalCount();
    System.out.println(integer);
  }
  @Test
  void queryForPageItems(){
    List<Book> books = bookDaoimpl.queryForPageItems(0, 4);
    for (Book book : books) {
      System.out.println(book);
    }
  }
}
