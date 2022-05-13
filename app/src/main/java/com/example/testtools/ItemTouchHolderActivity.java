package com.example.testtools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.testtools.adapter.CustomItemTouchHelperCallback;
import com.example.testtools.adapter.TouchHolderAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
* recycler 拖拽换位置，侧滑删除
* */
public class ItemTouchHolderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> dataList;
    private TouchHolderAdapter touchHolderAdapter;
    private GridLayoutManager gridLayoutManager;
    private ItemTouchHelper itemTouchHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_touch_holder);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.mCyclerview);
        dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add("item " + i);
        }
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        touchHolderAdapter = new TouchHolderAdapter(dataList, this);
        recyclerView.setAdapter(touchHolderAdapter);
        itemTouchHelper = new ItemTouchHelper(new CustomItemTouchHelperCallback(new CustomItemTouchHelperCallback.SwipedClickInterFace() {
            @Override
            public void deletePosition(int position) {
                dataList.remove(position);
                touchHolderAdapter.notifyDataSetChanged();
            }

            @Override
            public void swipItem(int position, int target) {
//                recyclerview  单行时：
//                Collections.swap(dataList,position,target);
//                touchHolderAdapter.notifyItemMoved(position,target);

//                recyclerView多行时
                String s = dataList.get(position);
                dataList.remove(position);
                dataList.add(target, s);
                touchHolderAdapter.notifyItemMoved(position, target);
                Log.e("onMove", dataList.toString());
            }
        }));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}