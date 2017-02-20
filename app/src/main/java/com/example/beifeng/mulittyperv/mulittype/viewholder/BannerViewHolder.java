package com.example.beifeng.mulittyperv.mulittype.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.beifeng.mulittyperv.R;
import com.example.beifeng.mulittyperv.mulittype.bean.BannerBean;

/**
 * Created by beifeng on 2017/2/17.
 * banner viewholder
 */

public class BannerViewHolder extends BaseViewHolder {
  @Bind(R.id.sdv_pictuer) TextView textview;
  public BannerViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  @Override public void bindViewData(Object data) {
    textview.setText(((BannerBean)data).getUrl());
  }
}
