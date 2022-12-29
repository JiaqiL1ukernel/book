package com.ljq.dao.impl;

import com.ljq.dao.BookDao;
import com.ljq.pojo.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoimplTest {
  private BookDao bookDao = new BookDaoimpl();
  @Test
  void queryForPageItems() {
    List<Book> books = bookDao.queryForPageItems(0, 4, 10, 200);
    for (Book book : books) {
      System.out.println(book);
    }
  }


  @Test
  void queryForPageTotalCount(){
    Integer res = bookDao.queryForPageTotalCount(100, 200);
    System.out.println(res);
  }
}
