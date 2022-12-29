package com.ljq.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
  private Integer totalCount;
  private BigDecimal totalPrice;
  private Map<Integer,CartItem> items = new HashMap<>();

  @Override
  public String toString() {
    return "Cart{" +
      "totalCount=" + totalCount +
      ", totalPrice=" + totalPrice +
      ", items=" + items +
      '}';
  }

  public Integer getTotalCount() {
    return totalCount;
  }


  public BigDecimal getTotalPrice() {
    return totalPrice;
  }


  public Map<Integer,CartItem> getItems() {
    return items;
  }

  public void setItems(Map<Integer,CartItem> items) {
    this.items = items;
  }

  public Cart(Integer totalCount, BigDecimal totalPrice, Map<Integer,CartItem> items) {
    this.totalCount = totalCount;
    this.totalPrice = totalPrice;
    this.items = items;
  }

  public Cart() {
    totalPrice = new BigDecimal(0);
    totalCount = 0;
  }



  /**
   * 添加商品
   * @author 刘家齐
   * @date 2022/12/28 17:11
   * @param item

   */
  public void addItem(CartItem item){
    Integer id = item.getId();
    if(!items.containsKey(id)){
      items.put(id,item);
    }else {
      Integer count = items.get(id).getCount();
      item.setCount(++count);
      item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
      items.put(id,item);
    }
    totalCount++;
    totalPrice=totalPrice.add(item.getPrice());
  }







/**
 *删除商品
 * @author 刘家齐
 * @date 2022/12/28 17:12
 * @param item

 */

  public void deleteItem(Integer id){
    CartItem item = items.get(id);
    totalCount -= item.getCount();
    totalPrice = totalPrice.subtract(item.getTotalPrice());
    items.remove(id);
  }





  /**
   *
   * @author 刘家齐
   * @date 2022/12/28 17:13
   * @param

   */

  public void clear(){
    items.clear();
    totalPrice = new BigDecimal(0);
    totalCount = 0;
  }





/**
 * 修改商品数量
 * @author 刘家齐
 * @date 2022/12/28 17:14
 * @param id
 * @param count

 */

  public void updateItemCount(Integer id,Integer count){
    CartItem item = items.get(id);
    if(count<=0){
      deleteItem(id);

    }else {

      item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
      totalCount += count-item.getCount();
      totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(count-item.getCount())));
      item.setCount(count);
      items.put(id,item);
    }
  }

}
