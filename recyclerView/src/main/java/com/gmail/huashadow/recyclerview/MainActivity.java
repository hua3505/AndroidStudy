package com.gmail.huashadow.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        List<String> data = new ArrayList<>();
        for (int i=0; i<100; i++) {
            data.add("Item " + i);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new MyAdapter(data));
    }

    private class MyAdapter extends RecyclerView.Adapter {

        List<String> mData;

        MyAdapter(List<String> data) {
            mData = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == 0) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_text_item, parent, false);
                return new MyViewHolder(view);
            } else if (viewType == 1) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_item_container, parent, false);
                return new FragmentItemViewHolder(view);
            }
            return null;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            int viewType = getItemViewType(position);
            if (viewType == 0) {
                ((MyViewHolder) holder).mTextView.setText(mData.get(position / 2));
            } else if(viewType == 1) {
                FragmentItemViewHolder fragmentItemViewHolder = (FragmentItemViewHolder) holder;
                int containerId = fragmentItemViewHolder.mRootView.getId();
                Fragment oldFragment = getSupportFragmentManager().findFragmentById(containerId);
                if (oldFragment != null) {
                    getSupportFragmentManager().beginTransaction().remove(oldFragment).commit();
                }
                int newContainerId = 1000 + position;
                fragmentItemViewHolder.mRootView.setId(newContainerId);
                getSupportFragmentManager().beginTransaction().add(newContainerId, new ItemFragment()).commit();
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (mData != null) {
                return position % 2;
            }
            return -1;
        }

        @Override
        public int getItemCount() {
            if (mData != null) {
                return 2 * mData.size();
            }
            return 0;
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            TextView mTextView;
            MyViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.tv_content);
            }
        }

        private class FragmentItemViewHolder extends ViewHolder {

            View mRootView;

            FragmentItemViewHolder(View itemView) {
                super(itemView);
                mRootView = itemView;
            }
        }
    }
}
