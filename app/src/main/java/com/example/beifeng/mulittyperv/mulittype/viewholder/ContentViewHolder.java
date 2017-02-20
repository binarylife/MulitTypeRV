package com.example.beifeng.mulittyperv.mulittype.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.beifeng.mulittyperv.R;

/**
 * Created by beifeng on 2017/2/17.
 * banner viewholder
 */

public class ContentViewHolder extends BaseViewHolder {
  @Bind(R.id.sdv_content) TextView textView;
  public ContentViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  @Override public void bindViewData(Object data) {
    //imageview.setImageURI(((BannerBean)data).getUrl());
  }
}
