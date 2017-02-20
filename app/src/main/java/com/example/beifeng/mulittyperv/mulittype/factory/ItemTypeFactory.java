package com.example.beifeng.mulittyperv.mulittype.factory;

import android.view.View;
import com.example.beifeng.mulittyperv.R;
import com.example.beifeng.mulittyperv.mulittype.bean.BannerBean;
import com.example.beifeng.mulittyperv.mulittype.bean.ContentBean;
import com.example.beifeng.mulittyperv.mulittype.viewholder.BannerViewHolder;
import com.example.beifeng.mulittyperv.mulittype.viewholder.BaseViewHolder;
import com.example.beifeng.mulittyperv.mulittype.viewholder.ContentViewHolder;

/**
 * Created by beifeng on 2017/2/17.
 * 实现type工程类
 */

public class ItemTypeFactory implements TypeFactory {
  //  将id作为type传入adapter
  public static final int BANNER_ITEM_LAYOUT = R.layout.item_banner_mulittype;
  public static final int CONTENT_ITEM_LAYOUT = R.layout.item_content_mulittype;
  @Override public int type(BannerBean bannerBean) {
    return BANNER_ITEM_LAYOUT;
  }

  @Override public int type(ContentBean contentBean) {
    return CONTENT_ITEM_LAYOUT;
  }

  @Override public BaseViewHolder createViewHolder(int type, View itemView) {
    switch (type) {
      case BANNER_ITEM_LAYOUT:
        return new BannerViewHolder(itemView);
      case CONTENT_ITEM_LAYOUT:
        return new ContentViewHolder(itemView);
      default:
        return null;
    }
  }
}
