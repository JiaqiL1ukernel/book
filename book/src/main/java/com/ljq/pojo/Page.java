package com.ljq.pojo;

import java.util.List;

public class Page<T> {
  public static final Integer PAGE_SIZE=4;
  private Integer pageNo;
  private Integer pageTotal;
  private Integer pageSize = PAGE_SIZE;
  private Integer pageTotalCount;
  private List<T> items;
  private String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Page{" +
      "pageNo=" + pageNo +
      ", pageTotal=" + pageTotal +
      ", pageSize=" + pageSize +
      ", pageTotalCount=" + pageTotalCount +
      ", items=" + items +
      ", url='" + url + '\'' +
      '}';
  }

  public static Integer getPageSize() {
    return PAGE_SIZE;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageTotalCount() {
    return pageTotalCount;
  }

  public void setPageTotalCount(Integer pageTotalCount) {
    this.pageTotalCount = pageTotalCount;
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    if(pageNo<1){
      pageNo = 1;
    }else if(pageNo>pageTotal){
      pageNo = pageTotal;
    }
    this.pageNo = pageNo;
  }

  public Integer getPageTotal() {
    return pageTotal;
  }

  public void setPageTotal(Integer pageTotal) {
    this.pageTotal = pageTotal;
  }

  public Page() {
  }

  public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items) {
    this.pageNo = pageNo;
    this.pageTotal = pageTotal;
    this.pageSize = pageSize;
    this.pageTotalCount = pageTotalCount;
    this.items = items;
  }
}
