package com.ljq.service.impl;

import com.ljq.dao.BookDao;
import com.ljq.dao.impl.BookDaoimpl;
import com.ljq.pojo.Book;
import com.ljq.pojo.Page;
import com.ljq.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

  private BookDao  bookDao = new BookDaoimpl();
  @Override
  public void addBook(Book book) {
    bookDao.addBook(book);
  }

  @Override
  public void deleteBookById(Integer id) {
    bookDao.deleteById(id);
  }

  @Override
  public void updateBook(Book book) {
    bookDao.updateBook(book);
  }

  @Override
  public Book queryBookById(Integer id) {
    return bookDao.queryById(id);
  }

  @Override
  public Page<Book> page(int pageNo, int pageSize) {
    Page<Book> page = new Page<>();

    page.setPageSize(pageSize);
    Integer pageTotalCount = bookDao.queryForPageTotalCount();
    page.setPageTotalCount(pageTotalCount);

    Integer pageTotal = pageTotalCount/pageSize;
    if(pageTotalCount%pageSize>0){
      pageTotal++;
    }
    page.setPageTotal(pageTotal);


    page.setPageNo(pageNo);
    Integer begin = (page.getPageNo()-1)*pageSize;
    List<Book> items = bookDao.queryForPageItems(begin,pageSize);
    page.setItems(items);

    return page;
  }

  @Override
  public List<Book> queryBooks() {
    return bookDao.queryBooks();
  }

  @Override
  public Page<Book> page(Integer pageNo, Integer pageSize, Integer min, Integer max) {
    Page<Book> page = new Page<>();

    page.setPageSize(pageSize);
    Integer pageTotalCount = bookDao.queryForPageTotalCount(min,max);
    page.setPageTotalCount(pageTotalCount);

    Integer pageTotal = pageTotalCount/pageSize;
    if(pageTotalCount%pageSize>0){
      pageTotal++;
    }
    page.setPageTotal(pageTotal);


    page.setPageNo(pageNo);
    Integer begin = (page.getPageNo()-1)*pageSize;
    List<Book> items = bookDao.queryForPageItems(begin,pageSize,min,max);
    page.setItems(items);

    return page;
  }
}
