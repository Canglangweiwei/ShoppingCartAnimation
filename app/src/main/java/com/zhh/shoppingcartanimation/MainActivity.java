package com.zhh.shoppingcartanimation;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhh.shoppingcartanimation.adapter.FoodAdapter;
import com.zhh.shoppingcartanimation.datas.AppConfig;
import com.zhh.shoppingcartanimation.model.FoodModel;
import com.zhh.shoppingcartanimation.view.ShoppingCartAnimationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by zhh on 2017/1/19.
 * 个人
 * csdn网站：http://blog.csdn.net/zhh_csdn_ard
 * devstore网站：http://www.devstore.cn/user_home/zhanghai_ardapp.html
 */
@SuppressWarnings("ALL")
public class MainActivity extends BaseActivity implements FoodAdapter.FoodActionCallback {

   @Bind(R.id.listView)
   ListView listView;
   @Bind(R.id.goods_all_pricetv)
   TextView goods_all_pricetv;
   @Bind(R.id.good_numtv)
   TextView good_numtv;
   @Bind(R.id.goods_submit_tv)
   TextView txtSub;

   private List<FoodModel> foodsList;
   private List<FoodModel> selectList = new ArrayList<>();
   private FoodAdapter adapter = null;

   @Override
   protected int initContentView() {
      return R.layout.activity_main;
   }

   @Override
   protected void initUi() {
      configToolbar(false, "商品列表", true, new View.OnClickListener() {

         @Override
         public void onClick(View view) {
            Toast.makeText(MainActivity.this, "点击了操作按钮", Toast.LENGTH_SHORT).show();
         }
      });
   }

   @Override
   protected void initDatas() {
      foodsList = AppConfig.factoryFoods();
      adapter = new FoodAdapter(this, foodsList, this);
      listView.setAdapter(adapter);
   }

   @Override
   protected void initListener() {
      txtSub.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            if (null == selectList || selectList.size() == 0) {
               Toast.makeText(MainActivity.this, "你的购物车为空", Toast.LENGTH_SHORT).show();
            } else {
               Toast.makeText(MainActivity.this, "你一共加入购物车" + good_numtv.getText() +
                   "份商品,总价格为：" + goods_all_pricetv.getText(), Toast.LENGTH_SHORT).show();
            }
         }
      });
   }

   /**
    * 添加商品动画
    */
   @Override
   public void addGoods(View view, int item) {
      ShoppingCartAnimationView shoppingCartAnimationView = new ShoppingCartAnimationView(this);

      int position[] = new int[2];
      view.getLocationInWindow(position);
      shoppingCartAnimationView.setStartPosition(new Point(position[0], position[1]));
      ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
      rootView.addView(shoppingCartAnimationView);

      int endPosition[] = new int[2];
      good_numtv.getLocationInWindow(endPosition);
      shoppingCartAnimationView.setEndPosition(new Point(endPosition[0], endPosition[1]));
      shoppingCartAnimationView.startBeizerAnimation();
      FoodModel model = foodsList.get(item);
      model.setNum(model.getNum() + 1);

      adapter.reset();
      // 计算总价
      calculatePrice();
   }

   /**
    * 减少商品
    */
   @Override
   public void reduceGoods(int position) {
      FoodModel model = foodsList.get(position);
      model.setNum(model.getNum() - 1);
      adapter.reset();
      // 计算总价
      calculatePrice();
   }

   /**
    * 购物车份数+总价格计算
    */
   private void calculatePrice() {
      selectList.clear();
      double price = 0;
      int num = 0;
      for (FoodModel model : foodsList) {
         if (model.getNum() != 0) {
            selectList.add(model);
            price += model.getPrice() * model.getNum();
            num += model.getNum();
         }
      }
      goods_all_pricetv.setText("￥" + adapter.priceResult(price) + "元");
      good_numtv.setText(String.valueOf(num));
   }
}
