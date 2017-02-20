package com.example.beifeng.mulittyperv.mulittype.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.beifeng.mulittyperv.mulittype.decorate.Visitable;
import com.example.beifeng.mulittyperv.mulittype.factory.ItemTypeFactory;
import com.example.beifeng.mulittyperv.mulittype.viewholder.BaseViewHolder;
import java.util.List;

/**
 * Created by beifeng on 2017/2/17.
 */

public class MulitAdpter extends RecyclerView.Adapter<BaseViewHolder> {
  private ItemTypeFactory typeFactory;
  List<Visitable> mItems;
  /**
   * 构造函数
   */
  public MulitAdpter(List<Visitable> mData) {
    //  item工厂类 生产viewholder
    this.typeFactory = new ItemTypeFactory();
    mItems=mData;
  }

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent,false);
    return typeFactory.createViewHolder(viewType, view);
  }

  @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
    holder.bindViewData(mItems.get(position));
  }

  @Override public int getItemViewType(int position) {
    return mItems.get(position).type(typeFactory);
  }

  @Override public int getItemCount() {
    return (mItems != null ? mItems.size() : 0);
  }
}
