package com.example.beifeng.mulittyperv.mulittype.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by beifeng on 2017/2/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{
    private View mItemView;
    SparseArray<View> views ;
    public BaseViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        //ButterKnife.bind(this, itemView);
        //  初始化存储view的集合
        views=new SparseArray<View>();
    }

    /**
     * 获取当前item的view
     * @param resId
     * @return
     */
    public View getViews(int resId) {
        View view= views.get(resId);
        if (view==null){
            view = mItemView;
            views.put(resId,mItemView);
        }
        return view;
    }

    /**
     *绑定itemview 的数据
     */
    public abstract void bindViewData(T data);
}
