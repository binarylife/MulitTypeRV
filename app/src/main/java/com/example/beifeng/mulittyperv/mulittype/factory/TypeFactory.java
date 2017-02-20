package com.example.beifeng.mulittyperv.mulittype.factory;

import android.view.View;
import com.example.beifeng.mulittyperv.mulittype.bean.BannerBean;
import com.example.beifeng.mulittyperv.mulittype.bean.ContentBean;
import com.example.beifeng.mulittyperv.mulittype.viewholder.BaseViewHolder;

/**
 * Created by beifeng on 2017/2/17.
 * type 工厂类 用来返回不同的itmetpe
 */

public interface TypeFactory {
  //  定义所有的返回类型
  int type(BannerBean bannerBean);

  int type(ContentBean contentBean);

  BaseViewHolder createViewHolder(int type, View itemView);
}

