package com.duanlei.myplan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duanlei.myplan.adapter.RecyclerAdapter;
import com.duanlei.myplan.model.Plan;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: duanlei
 * Date: 2016-01-22
 */
public class PlanListFragment extends Fragment {

    private List<Plan> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView =
                (RecyclerView) inflater.inflate(R.layout.fragment_plan, container, false);


        setupData();

        setupRecyclerView(recyclerView);

        return recyclerView;
    }

    private void setupData() {
        mData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            mData.add(new Plan("2016.1.22", "计划内容，，，，，，" + i));
        }
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        //设置item排列的方向，为垂直方向
        recyclerView.setLayoutManager(
                new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new RecyclerAdapter(mData));
    }


}
