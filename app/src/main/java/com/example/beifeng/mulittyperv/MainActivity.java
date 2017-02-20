package com.example.beifeng.mulittyperv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import com.example.beifeng.mulittyperv.mulittype.adapter.MulitAdpter;
import com.example.beifeng.mulittyperv.mulittype.bean.BannerBean;
import com.example.beifeng.mulittyperv.mulittype.bean.ContentBean;
import com.example.beifeng.mulittyperv.mulittype.decorate.Visitable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.rv) RecyclerView mRecycleView;

  @Override protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mRecycleView = (RecyclerView) findViewById(R.id.rv);
    //  模拟本地数据
    List<Visitable> beans = new ArrayList<>();
    beans.add(new BannerBean(
        "www.baidu.com"));
    beans.add(new ContentBean());
    beans.add(new BannerBean(
        "www.jd.com"));
    beans.add(new BannerBean(
        "www.baidu.com"));
    beans.add(new ContentBean());
    beans.add(new BannerBean(
        "www.qq.com"));
    beans.add(new ContentBean());
    beans.add(new BannerBean(
        "www.sina.com"));
    beans.add(new ContentBean());
    beans.add(new BannerBean(
        "www.taobao.com"));
    beans.add(new ContentBean());
    MulitAdpter multiRecyclerAdapter = new MulitAdpter(beans);
    LinearLayoutManager linearLayoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    mRecycleView.setLayoutManager(linearLayoutManager);
    mRecycleView.setAdapter(multiRecyclerAdapter);
  }
}
