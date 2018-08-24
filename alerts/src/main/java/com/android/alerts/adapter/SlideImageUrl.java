package com.android.alerts.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.alerts.R;
import com.android.alerts.Utils.ModuleUtils;

import java.util.List;

public class SlideImageUrl extends PagerAdapter {


    private List<String> IMAGES;
    private LayoutInflater inflater;
    private Context context;

    public SlideImageUrl(Context context, List<String> IMAGES) {
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
        ModuleUtils.loadPicasso(imageView,IMAGES.get(position));

        //imageView.setImageResource(IMAGES.get(position));

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
