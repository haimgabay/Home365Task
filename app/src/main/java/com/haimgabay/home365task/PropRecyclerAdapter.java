package com.haimgabay.home365task;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class PropRecyclerAdapter extends RecyclerView.Adapter<PropRecyclerAdapter.ViewHolder> {

        Context context;
        ArrayList<SinglePropDetails> propsArrayList;
        OnPropClickedListener mOnPropClickedListener;

        public PropRecyclerAdapter(ArrayList<SinglePropDetails> propsArrayList, Context context,
                                     OnPropClickedListener onPropClickedListener){
            this.propsArrayList = propsArrayList;
            this.context = context;
            this.mOnPropClickedListener = onPropClickedListener;
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.row_item_for_one_property, parent,  false);
            RecyclerView.ViewHolder viewHolder = new ViewHolder(view, mOnPropClickedListener);
            return (ViewHolder) viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//            holder.title.setText(propsArrayList.get(position).getCreated());
        }

        @Override
        public int getItemCount() {
            return propsArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//            TextView title;
//            ImageView imageView;
//            ImageView favoriteImageView;
//            TextView releaseDate;
            OnPropClickedListener onPropClickedListener;

            public ViewHolder(@NonNull View itemView, OnPropClickedListener onPropClickedListener) {
                super(itemView);
//                title = itemView.findViewById(R.id.movieTitle);
                this.onPropClickedListener = onPropClickedListener;
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mOnPropClickedListener != null) {
                    mOnPropClickedListener.OnPropClicked(getBindingAdapterPosition(), itemView);
                }
            }
        }

        public interface OnPropClickedListener{
            void OnPropClicked(int position, View itemView);
        }
    }
