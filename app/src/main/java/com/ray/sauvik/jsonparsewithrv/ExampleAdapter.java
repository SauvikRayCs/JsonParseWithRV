package com.ray.sauvik.jsonparsewithrv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList){
        mContext = context;
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.example_item, viewGroup, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        ExampleItem currentItem = mExampleList.get(i);

        String userNameinfo = currentItem.getmUserName();
        String userAddressinfo = currentItem.getmUserAddress();
        int userPininfo = currentItem.getmUserPin();

        exampleViewHolder.mTextViewName.setText(userNameinfo);
        exampleViewHolder.mTextViewAddress.setText(userAddressinfo);
        exampleViewHolder.mTextViewPin.setText("pin: " +userPininfo);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewName;
        public TextView mTextViewAddress;
        public TextView mTextViewPin;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.textView);
            mTextViewAddress = itemView.findViewById(R.id.textView2);
            mTextViewPin = itemView.findViewById(R.id.textView3);


        }
    }
}
