>* RecycleView在项目中使用大家比较简单，但当页面中item类型超过三个以上（比如绚丽的首页等），通过不同的类型去选择不同的viewHolder会导致adapter中的代码过于复杂，后期增加或删减item更加痛苦。本文将采用另一种方式来应对复杂多变的item。   
  
![详细类图参考.png](http://upload-images.jianshu.io/upload_images/716897-15cefd8221093301.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

>*使用方式：

###1.所有itemBean统一实现Visitable接口中的type方法
```java
/**
 * Created by beifeng on 2017/2/17.
 * 所有itembean统一实现的接口
 */
public interface Visitable {
    int type(TypeFactory typeFactory);
}
```
###itemBean中通过typeFactory返回对应的type区分
```java
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

```
 ###2. 简单的工厂模式，通过不同类型bean返回不同类型的holder
```java
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
```
###具体实现类ItemTypeFactory
通过将不同item的layoutID作为type返回对应item的viewholder，这种做法的好处是 在adapter的 `onCreateViewHolder(ViewGroup parent, int viewType) `中通过viewtype直接获取view，进而获取相应的viewHoler，大大减轻了adapter中的复杂的类型判断。
```java
/**
 * Created by beifeng on 2017/2/17.
 * 实现type工程类
 */

public class ItemTypeFactory TypeFactory {
  public static final int BANNER_ITEM_LAYOUT = R.layout.item_banner_mulittype;//  测试布局1
  public static final int CONTENT_ITEM_LAYOUT = R.layout.item_content_mulittype;//  测试布局2
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
```
### 3.此时可以在recycleView的Adpter中愉快的玩耍啦
```java
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
    return typeFactory.createViewHolder(viewType, view);//划重点

  }

  @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
    holder.bindViewData(mItems.get(position));
  }

  @Override public int getItemViewType(int position) {
    return mItems.get(position).type(typeFactory);  //划重点
  }

  @Override public int getItemCount() {
    return (mItems != null ? mItems.size() : 0);
  }
}
```
### 4.总结
此时可以在recycleView的Adpter中愉快的玩耍啦，面对更复杂的recycleView页面轻松应对。这种方式虽然类结构较复杂，但将复杂的多类型item与adapter解耦，便于维护。后期需要新增个类型，完全可以不用修改adapter，只需要增加对应的bean，viewHolder即可。
[Demo链接](https://github.com/meierjan/BetterAdapters)
### 实现思路
[Jan M](https://medium.com/@meierjan) and [Dmitri Kudrenko](https://medium.com/@dmitrikudrenko) on Github 
[https://github.com/meierjan/BetterAdapters](https://github.com/meierjan/BetterAdapters)
