package com.ljq.web;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {

  public static <T> T copyParaToBean(Map map,T bean){
    try {
      BeanUtils.populate(bean,map);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return bean;
  }

  public static Integer parseInt(String str,Integer defaultValue){
    Integer rs = 0;
    if(str=="" || str==null){
      rs = defaultValue;
    }else {
      rs = Integer.parseInt(str);
    }
    return rs;

  }
}
