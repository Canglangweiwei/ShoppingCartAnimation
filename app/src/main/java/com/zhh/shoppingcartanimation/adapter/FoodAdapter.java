package com.zhh.shoppingcartanimation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhh.shoppingcartanimation.R;
import com.zhh.shoppingcartanimation.model.FoodModel;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

@SuppressWarnings("ALL")
public class FoodAdapter extends BaseAdapter {

    private List<FoodModel> models;
    private Context context;
    private FoodActionCallback callback;

    public FoodAdapter(Context context, List<FoodModel> models, FoodActionCallback callback) {
        this.context = context;
        this.models = models;
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_food, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final FoodModel model = models.get(position);

        viewHolder.item_good_name.setText(model.getName());
        viewHolder.item_good_price.setText("￥" + priceResult(model.getPrice()));
        viewHolder.item_gooddescription.setText(model.getDescription());
        viewHolder.item_good_num.setText(String.valueOf(model.getNum()));

        // 加载图片
        Glide.with(context).load(model.getPath())
                .placeholder(R.drawable.images)
                .error(R.drawable.images)
                .into(viewHolder.item_good_image);

        viewHolder.item_good_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback == null) {
                    return;
                }
                callback.addGoods(v, position);
            }
        });

        viewHolder.item_good_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback == null || 0 == model.getNum()) {
                    return;
                }
                callback.reduceGoods(position);
            }
        });
        return convertView;
    }

    class ViewHolder {

        @Bind(R.id.item_good_image)
        ImageView item_good_image;
        @Bind(R.id.item_good_name)
        TextView item_good_name;
        @Bind(R.id.item_good_price)
        TextView item_good_price;
        @Bind(R.id.item_gooddescription)
        TextView item_gooddescription;
        @Bind(R.id.item_good_num)
        TextView item_good_num;
        @Bind(R.id.item_good_add)
        ImageView item_good_add;
        @Bind(R.id.item_good_reduce)
        ImageView item_good_reduce;

        ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }

    public interface FoodActionCallback {
        void addGoods(View view, int position);

        void reduceGoods(int position);
    }

    /**
     * 单位精度计算(价格)
     */
    public String priceResult(double price) {
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(new BigDecimal(price));
    }
}
