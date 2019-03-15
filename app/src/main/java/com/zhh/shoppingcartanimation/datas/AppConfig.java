package com.zhh.shoppingcartanimation.datas;

import com.zhh.shoppingcartanimation.model.FoodModel;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {

   public static List<FoodModel> factoryFoods() {

      List<FoodModel> datas = new ArrayList<>();

      datas.add(new FoodModel(1, "杨桃", "http://foodqs.cn/memberpicture/landiaoxianguo200679132637.jpg", "杨桃好好吃的...", 0, 18.00));
      datas.add(new FoodModel(2, "凤梨", "https://imgsa.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=27f58e5f5b0fd9f9b41a5d3b4444bf4f/cb8065380cd791235bd03557a7345982b2b780e5.jpg", "凤梨好好吃的...", 0, 9.9));
      datas.add(new FoodModel(3, "草莓", "http://sucai.dabaoku.com/zhiwu/shuiguo/er122.jpg", "草莓好好吃的...", 0, 25));
      datas.add(new FoodModel(4, "西瓜", "http://img.xinggan.com/uploads/allimg/130531/1_130531135001_1.jpg", "西瓜好好吃的...", 0, 3.50));
      datas.add(new FoodModel(5, "香蕉", "https://imgsa.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=9c96e55c30d12f2eda08a6322eabbe07/5d6034a85edf8db12c69f8ef0f23dd54574e74f2.jpg", "香蕉好好吃的...", 0, 3));
      datas.add(new FoodModel(6, "苹果", "http://pic.pimg.tw/leeyihugh/1409076519-230101976.jpg", "苹果好好吃的...", 0, 5));
      datas.add(new FoodModel(8, "梨", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSM3tPMibWK8L_aWnymYP4Vf80k15e__XRt3J1v__yImZ3DApBn", "梨好好吃的...", 0, 4.99));
      datas.add(new FoodModel(9, "葡萄", "http://www.39kf.com/uploadfiles/image/10190/TXT-200541114561734.jpg", "葡萄好好吃的...", 0, 9));
      datas.add(new FoodModel(10, "猕猴桃", "https://imgsa.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=96ada3f897510fb36c147fc5b85aa3f0/d8f9d72a6059252da44af0453d9b033b5bb5b916.jpg", "猕猴桃好好吃的...", 0, 20));
      datas.add(new FoodModel(11, "西红柿", "https://imgsa.baidu.com/baike/crop%3D0%2C114%2C1024%2C676%3Bc0%3Dbaike116%2C5%2C5%2C116%2C38/sign=a21bb1b02034349b604934c5f4da39ff/a50f4bfbfbedab6484791d6aff36afc379311e14.jpg", "西红柿好好吃的...", 0, 2));
      datas.add(new FoodModel(7, "黑布林", "http://img.caichongwang.com/thumbs/0036628.jpg", "黑布林好好吃的...", 0, 8.99));

      return datas;
   }
}
