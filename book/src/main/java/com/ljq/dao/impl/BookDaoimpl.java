package com.ljq.dao.impl;

import com.ljq.dao.BaseDao;
import com.ljq.dao.BookDao;
import com.ljq.pojo.Book;

import java.util.List;

public class BookDaoimpl extends BaseDao implements BookDao {
  @Override
  public int addBook(Book book) {
    String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) \n" +
      "values(?,?,?,?,?,?);";
    return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
  }

  @Override
  public int deleteById(Integer id) {
    String sql = "delete from t_book where id = ?";
    return update(sql,id);
  }

  @Override
  public int updateBook(Book book) {
    String sql = "update t_book set `name`=? , `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path`=? where id = ?";
    return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
  }

  @Override
  public Book queryById(Integer id) {
    String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
    return QueryForOne(sql,Book.class,id);
  }

  @Override
  public List<Book> queryBooks() {
    String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
    return QueryForList(sql,Book.class);
  }

  @Override
  public Integer queryForPageTotalCount() {
    String sql = "select count(*) from t_book ";
    Number num = (Number) QueryForSingelValue(sql);
    return num.intValue();
  }

  @Override
  public List<Book> queryForPageItems(Integer begin, int pageSize) {
    String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
    return QueryForList(sql,Book.class,begin,pageSize);
  }

  @Override
  public List<Book> queryForPageItems(Integer begin, Integer pageSize, Integer min, Integer max) {
    String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where" +
      " price between ? and ? order by price limit ?,?";
    return QueryForList(sql,Book.class,min,max,begin,pageSize);
  }

  @Override
  public Integer queryForPageTotalCount(Integer min, Integer max) {
    String sql = "select count(*) from t_book where price between ? and ?";
    Number num = (Number) QueryForSingelValue(sql,min,max);
    return num.intValue();
  }
}
