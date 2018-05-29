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

/**
 * 地址:https://blog.csdn.net/u011179438/article/details/52367903
 * <p>
 * 常用功能：
 * //占位符
 * Glide.with(this).load(url).placeholder(R.mipmap.ic_launcher).into(imageview);
 * //错误占位符
 * Glide.with(this).load(url).error(R.mipmap.ic_launcher).into(imageview);
 * //强制显示淡入淡出功能,300表示动画时间300ms
 * Glide.with(this).load(url).crossFade(300).into(imageview);
 * //不要淡入淡出效果
 * Glide.with(this).load(url).dontAnimate().into(imageview);
 * //改变图片大小,单位是pixel
 * Glide.with(this).load(url).override(500,500).into(imageview);
 * //Glide可以直接显示Gif
 * Glide.with(this).load(gif_url).into(imageview);
 * //也可以只显示Glide的第一帧作为普通图片使用
 * Glide.with(this).load(gif_url).asBitmap().into(imageview);
 * //也可以强制显示Gif,如果目标url不是gif则调用error()方法
 * Glide.with(this).load(gif_url).asGif().into(imageview);
 * //还可以显示视频，但目前只支持本地视频
 * Glide.with(this).load(Uri.fromFile(new File(local_video_path))).into(imageview);
 * <p>
 * 高级功能:
 * //跳过内存缓存，只在磁盘缓存(默认false)
 * Glide.with(this).load(url).skipMemoryCacge(true).into(imageview);
 * //跳过磁盘缓存，只在内存缓存（NONE表示什么都不缓存）
 * Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageview);
 * //显示缩略图（显示原始图像的10%）
 * Glide.with(this).load(url).thumbnail(0.1f).into(imageview);
 * <p>
 * 高级功能:
 * //跳过内存缓存，只在磁盘缓存(默认false)
 * Glide.with(this).load(url).skipMemoryCacge(true).into(imageview);
 * //跳过磁盘缓存，只在内存缓存（NONE表示什么都不缓存）
 * Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageview);
 * //显示缩略图（显示原始图像的10%）
 * Glide.with(this).load(url).thumbnail(0.1f).into(imageview);
 * <p>
 * <p>
 * <p>
 * 下载bitmap:
 * <p>
 * private SimpleTarget<GlideDrawable> mTarget = new SimpleTarget<GlideDrawable>() {
 *
 * @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
 * //处理resource
 * }
 * };
 * <p>
 * private void loadFile(){
 * Glide.with(this).load("url").into(mTarget);
 * }
 * <p>
 * 高级功能:
 * //跳过内存缓存，只在磁盘缓存(默认false)
 * Glide.with(this).load(url).skipMemoryCacge(true).into(imageview);
 * //跳过磁盘缓存，只在内存缓存（NONE表示什么都不缓存）
 * Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageview);
 * //显示缩略图（显示原始图像的10%）
 * Glide.with(this).load(url).thumbnail(0.1f).into(imageview);
 * <p>
 * <p>
 * <p>
 * 下载bitmap:
 * <p>
 * private SimpleTarget<GlideDrawable> mTarget = new SimpleTarget<GlideDrawable>() {
 * @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
 * //处理resource
 * }
 * };
 * <p>
 * private void loadFile(){
 * Glide.with(this).load("url").into(mTarget);
 * }
 * <p>
 * 高级功能:
 * //跳过内存缓存，只在磁盘缓存(默认false)
 * Glide.with(this).load(url).skipMemoryCacge(true).into(imageview);
 * //跳过磁盘缓存，只在内存缓存（NONE表示什么都不缓存）
 * Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageview);
 * //显示缩略图（显示原始图像的10%）
 * Glide.with(this).load(url).thumbnail(0.1f).into(imageview);
 * <p>
 * <p>
 * <p>
 * 下载bitmap:
 * <p>
 * private SimpleTarget<GlideDrawable> mTarget = new SimpleTarget<GlideDrawable>() {
 * @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
 * //处理resource
 * }
 * };
 * <p>
 * private void loadFile(){
 * Glide.with(this).load("url").into(mTarget);
 * }
 * <p>
 * 高级功能:
 * //跳过内存缓存，只在磁盘缓存(默认false)
 * Glide.with(this).load(url).skipMemoryCacge(true).into(imageview);
 * //跳过磁盘缓存，只在内存缓存（NONE表示什么都不缓存）
 * Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageview);
 * //显示缩略图（显示原始图像的10%）
 * Glide.with(this).load(url).thumbnail(0.1f).into(imageview);
 * <p>
 * <p>
 * <p>
 * 下载bitmap:
 * <p>
 * private SimpleTarget<GlideDrawable> mTarget = new SimpleTarget<GlideDrawable>() {
 * @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
 * //处理resource
 * }
 * };
 * <p>
 * private void loadFile(){
 * Glide.with(this).load("url").into(mTarget);
 * }
 */

/**
 * 高级功能:
 * //跳过内存缓存，只在磁盘缓存(默认false)
 Glide.with(this).load(url).skipMemoryCacge(true).into(imageview);
 //跳过磁盘缓存，只在内存缓存（NONE表示什么都不缓存）
 Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageview);
 //显示缩略图（显示原始图像的10%）
 Glide.with(this).load(url).thumbnail(0.1f).into(imageview);
 *
 */

/**
 *
 * 下载bitmap:
 *
 * private SimpleTarget<GlideDrawable> mTarget = new SimpleTarget<GlideDrawable>() {
@Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//处理resource
}
};

 private void loadFile(){
 Glide.with(this).load("url").into(mTarget);
 }
 */