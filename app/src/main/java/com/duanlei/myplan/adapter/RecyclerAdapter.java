package com.duanlei.myplan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duanlei.myplan.R;
import com.duanlei.myplan.model.Plan;

import java.util.List;

/**
 * Author: duanlei
 * Date: 2016-01-19
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Plan> mData;


    public RecyclerAdapter(List<Plan> data) {
        mData = data;
    }


    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将布局转化为View并传递给RecyclerView封装好的ViewHolder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //建立起ViewHolder中视图与数据的关联
        holder.time.setText(mData.get(position).getTime());
        holder.content.setText(mData.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView time;
        public TextView content;

        public ViewHolder(View view) {
            super(view);
            time = (TextView) view.findViewById(R.id.tv_time);
            content = (TextView) view.findViewById(R.id.tv_content);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
}
