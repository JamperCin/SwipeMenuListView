package com.jamper.swipemenulistview.swipe;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jamper.swipemenulistview.R;

/**
 * @author baoyz
 * @date 2014-8-23
 */
public class SwipeMenuView extends LinearLayout implements OnClickListener {

    private SwipeMenuListView mListView;
    private SwipeMenuLayout mLayout;
    private SwipeMenu mMenu;
    private OnSwipeItemClickListener onItemClickListener;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public SwipeMenuView(SwipeMenu menu, SwipeMenuListView listView) {
        super(menu.getContext());
        mListView = listView;
        mMenu = menu;
        List<SwipeMenuItem> items = menu.getMenuItems();
        int id = 0;
        for (SwipeMenuItem item : items) {
            addItem(item, id++);
        }
    }


    private void addItem(SwipeMenuItem item, int id) {
        try {
            LayoutParams params = new LayoutParams(item.getWidth(), ViewGroup.LayoutParams.MATCH_PARENT);

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;

            RelativeLayout parent = (RelativeLayout) inflater.inflate(R.layout.menu_layout, null);

            Margins margins = item.getMargins();
            if (margins != null)
                params.setMargins(margins.getLeft(), margins.getTop(), margins.getRight(), margins.getBottom());

            parent.setLayoutParams(params);

            ImageView imageView = (ImageView) parent.findViewById(R.id.ic_icon_s);
            TextView tv = (TextView) parent.findViewById(R.id.titleText_s);

            parent.setId(id);

            if (item.getBackground() != null)
                parent.setBackgroundDrawable(item.getBackground());
            parent.setOnClickListener(this);


            addView(parent);

            this.setLayoutParams(params);

            if (item.getIcon() != null)
                imageView.setImageDrawable(item.getIcon());

            try {
                if (item.getIconTintColor() != 0)
                    imageView.setColorFilter(item.getIconTintColor());
            } catch (Exception e) {
                Log.d("HTTP", "mess >> " + e.getMessage());
            }

            if (!TextUtils.isEmpty(item.getTitle())) {
                tv.setText(item.getTitle());
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(item.getTitleSize());
                tv.setTextColor(getContext().getResources().getColor(item.getTitleColor()));
            }

            try {
                if (!TextUtils.isEmpty(item.getTitle())) {
                    Typeface font = Typeface.createFromAsset(getContext().getAssets(), item.getFontName());
                    tv.setTypeface(font);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            try{
                imageView.getLayoutParams().height = item.getImageHeight();
                imageView.getLayoutParams().width = item.getImageWidth();
            }catch (Exception e){
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private ImageView createIcon(SwipeMenuItem item) {
        ImageView iv = new ImageView(getContext());
        iv.setImageDrawable(item.getIcon());
        return iv;
    }

    private TextView createTitle(SwipeMenuItem item) {
        TextView tv = new TextView(getContext());
        tv.setText(item.getTitle());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(item.getTitleSize());
        tv.setTextColor(item.getTitleColor());
        return tv;
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null && mLayout.isOpen()) {
            onItemClickListener.onItemClick(this, mMenu, v.getId());
        }
    }

    public OnSwipeItemClickListener getOnSwipeItemClickListener() {
        return onItemClickListener;
    }

    public void setOnSwipeItemClickListener(OnSwipeItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setLayout(SwipeMenuLayout mLayout) {
        this.mLayout = mLayout;
    }

    public static interface OnSwipeItemClickListener {
        void onItemClick(SwipeMenuView view, SwipeMenu menu, int index);
    }
}
