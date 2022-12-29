package com.ljq.service;

import com.ljq.pojo.Book;
import com.ljq.pojo.Page;
import com.ljq.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

  @Test
  void page() {
    BookServiceImpl bookService = new BookServiceImpl();
    Page<Book> page = bookService.page(1, 4);
    List<Book> items = page.getItems();
    for (Book item : items) {
      System.out.println(item);
    }
  }
}
