package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.huashadow.study.databinding.databinding.ActivityRecyclerviewBinding;
import com.gmail.huashadow.study.databinding.databinding.ItemUserBinding;
import com.gmail.huashadow.study.databinding.viewmodel.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WolfXu on 2017/11/12.
 */

public class RecyclerViewActivity extends Activity {

    private ActivityRecyclerviewBinding mBinding;
    private List<User> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        initData();
        mBinding.recyclerview.setAdapter(mAdapter);
        mBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        mDatas.add(new User("1", "2"));
        mDatas.add(new User("3", "4"));
        mDatas.add(new User("1", "2"));
        mDatas.add(new User("1", "2"));
        mDatas.add(new User("1", "2"));
        mDatas.add(new User("1", "2"));
        mDatas.add(new User("1", "2"));
    }

    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemUserBinding binding = ItemUserBinding.inflate(getLayoutInflater(), parent, false);
            return new UserItemViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((UserItemViewHolder) holder).setUser(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
    };

    private static class UserItemViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding mBinding;

        public UserItemViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void setUser(User user) {
            mBinding.setUser(user);
            mBinding.executePendingBindings();
        }
    }
}
