package com.example.admin.glide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

/**
 * Glide的使用
 */
public class MainActivity extends AppCompatActivity {

    private Activity mActivity;
    // 将从 此URL 加载网络图片。
    private String img_url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527574333898&di=4f3e0bc375b4da4069c25d799cbcb542&imgtype=0&src=http%3A%2F%2Fimg4.goumin.com%2Fattachments%2Fphoto%2F0%2F0%2F46%2F11901%2F3046846.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(new MyAdapter(this, R.layout.item));

    }

    private class MyAdapter extends ArrayAdapter {
        private int resource;

        public MyAdapter(@NonNull Context context, int resource) {
            super(context, resource);
            this.resource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(mActivity).inflate(resource, null);
            }

            ImageView imageView = convertView.findViewById(R.id.imageView);
            Glide.with(mActivity).load(img_url).centerCrop()
                    /*
                     * 缺省的占位图片，一般可以设置成一个加载中的进度GIF图
                     */
                    .placeholder(R.mipmap.ic_launcher).crossFade().into(imageView);

            return convertView;
        }

        @Override
        public int getCount() {
            // 假设加载的数据量很大
            return 10000;
        }
    }
}
