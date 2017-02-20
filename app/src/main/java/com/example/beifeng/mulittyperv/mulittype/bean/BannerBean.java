package com.example.beifeng.mulittyperv.mulittype.bean;

import com.example.beifeng.mulittyperv.mulittype.decorate.Visitable;
import com.example.beifeng.mulittyperv.mulittype.factory.TypeFactory;

/**
 * Created by beifeng on 2017/2/17.
 * 头部bean
 */

public class BannerBean implements Visitable {
  String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public BannerBean(String url) {
    this.url = url;
  }



  /**
   * 工厂类返回对应itembean的类型
   */
  @Override public int type(TypeFactory typeFactory) {
    return typeFactory.type(this);
  }
}
