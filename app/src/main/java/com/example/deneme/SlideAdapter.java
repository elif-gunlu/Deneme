package com.example.deneme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public int[] list_images = {
            R.drawable.sayikarpuz,
            R.drawable.sayihavuc,
            R.drawable.sayielma,
            R.drawable.sayiarmut,
            R.drawable.sayibadem,
            R.drawable.sayicilek,
            R.drawable.sayikayisi,
            R.drawable.sayiseftali,
            R.drawable.sayikavun
    };



    public SlideAdapter (Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == ((LinearLayout) o));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);

        ImageView imgSlideMeyveSayi = (ImageView)view.findViewById(R.id.image_meyve_sayisi);
        imgSlideMeyveSayi.setImageResource(list_images[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
