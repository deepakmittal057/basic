package com.alerts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.alerts.R;

import java.util.List;

public class SlideImage extends PagerAdapter {


    private List<Integer> IMAGES;
    private LayoutInflater inflater;
    private Context context;

    public SlideImage(Context context, List<Integer> IMAGES) {
        this.context = context;
        this.IMAGES=IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.image_view, view, false);

        //String imageName=IMAGES.get(position);
        assert imageLayout != null;
        ImageView imageView=(ImageView)imageLayout.findViewById(R.id.Profile_pic_imageView);
        view.addView(imageLayout, 0);
        imageView.setImageResource(IMAGES.get(position));

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }


}
