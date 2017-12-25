package com.example.liuyawen20171221.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liuyawen20171221.R;
import com.example.liuyawen20171221.bean.ShowBean;
import com.example.liuyawen20171221.view.ShowActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder>{
    Context context;
    List<ShowBean.DataBean> list;

    public ShowAdapter(Context context, List<ShowBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item_show,null);
        return new ShowViewHolder(view);
    }
    //设置一个变量
    public OnItemClickListener onItemClickListener;
    //3.定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    //1.首先自定义一个接口
    public interface OnItemClickListener {
        public void onItemClieck(String str);
    }
    @Override
    public void onBindViewHolder(ShowViewHolder holder, int position) {
        ShowViewHolder holder1=holder;
        final int pid = list.get(position).getPid();
        holder.textView.setText(list.get(position).getTitle());
        holder.price.setText(list.get(position).getPrice()+"");
        holder.simpleDraweeView.setImageURI(list.get(position).getImages());
//        holder.ll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickListener.onItemClieck(pid+"");
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list==null ? 0 :list.size();
    }

    class ShowViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView textView,price;
        LinearLayout ll;
        public ShowViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.iv);
            textView=itemView.findViewById(R.id.tv);
            price=itemView.findViewById(R.id.price);
            ll=itemView.findViewById(R.id.ll);
        }
    }
}
