package com.example.beifeng.mulittyperv.mulittype.decorate;

import com.example.beifeng.mulittyperv.mulittype.factory.TypeFactory;

/**
 * Created by beifeng on 2017/2/17.
 * 所有itembean统一实现的接口
 */

public interface Visitable {
    int type(TypeFactory typeFactory);
}
