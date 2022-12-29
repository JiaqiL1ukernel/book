package com.ljq.dao;

import com.ljq.pojo.Book;

import java.util.List;

public interface BookDao {

  int addBook(Book book);

  int deleteById(Integer id);

  int updateBook(Book book);

  Book queryById(Integer id);

  List<Book> queryBooks();

  Integer queryForPageTotalCount();

  List<Book> queryForPageItems(Integer begin, int pageSize);

  List<Book> queryForPageItems(Integer begin, Integer pageSize, Integer min, Integer max);

  Integer queryForPageTotalCount(Integer min, Integer max);
}
