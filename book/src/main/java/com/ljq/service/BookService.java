package com.ljq.service;

import com.ljq.pojo.Book;
import com.ljq.pojo.Page;

import java.util.List;

public interface BookService {

  void addBook(Book book);

  void deleteBookById(Integer id);

  void updateBook(Book book);

  Book queryBookById(Integer id);

  Page<Book> page(int pageNo,int pageSize);

  List<Book> queryBooks();


  Page<Book> page(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
