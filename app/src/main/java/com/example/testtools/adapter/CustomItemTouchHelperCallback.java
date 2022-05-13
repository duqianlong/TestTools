package com.example.testtools.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class CustomItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private SwipedClickInterFace swipedClickInterFace;

    public CustomItemTouchHelperCallback(SwipedClickInterFace swipedClickInterFace) {
        this.swipedClickInterFace = swipedClickInterFace;
    }

    /*
        它是一个抽象方法，返回自己所需要支持的移动方法的flags，通过官方的注释可以看到你可以使用makeMovementFlags创建你所需要支持的dragFlags和moveFlags
    */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
//            设置拖动方向, 此处设置上下拖动事件
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
//            设置滑动方向, 此处设置左右侧滑事件
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        // 应用 拖动 和 滑动 设置
//        return makeMovementFlags(dragFlags, swipeFlags);
        Log.e("==== <getMovementFlags>", "position:" + viewHolder.getAdapterPosition());
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    /*
        执行上下移动的操作，返回值是否移动。
        srcViewHolder ： 是按住的那个条目
        targetViewHolder： 移动到的那个条目
    */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        Log.e("====== <onMove>", "position:" + viewHolder.getAdapterPosition()+"  target"+target.getAdapterPosition());
         swipedClickInterFace.swipItem(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    /*
     * 执行左右滑动的操作
     * direction: 4:左滑  8：右滑
     * */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        Log.e("====== <onSwiped>", "position:" + viewHolder.getAdapterPosition() + "    direction" + direction);
        swipedClickInterFace.deletePosition(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    public interface SwipedClickInterFace {
        void deletePosition(int position);
        void swipItem(int position,int target);
    }
}
