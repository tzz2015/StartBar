package com.rongke.mifan.starbarapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 杭州融科网络
 * 刘宇飞创建 on 2017/6/16.
 * 描述：评价条
 */

public class StartBar extends LinearLayout {

    private boolean isNeedScore;//是否需要显示分数
    private boolean isNeedTouch;
    private Context context;
    private int default_color;//分数默认颜色
    private int default_height;//星星高度
    private TextView scoreView;//触摸评分 默认不可以
    private int position;

    public StartBar(Context context) {
        super(context);
    }

    public StartBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            return;
        }
        initView(context, attrs);
    }

    public StartBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            return;
        }
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        this.context=context;
        setOrientation(LinearLayout.HORIZONTAL);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StartBar);
        //是否需要显示分数 默认不需要
        isNeedScore = a.getBoolean(R.styleable.StartBar_is_need_score, false);
        //触摸评分 默认不可以
        isNeedTouch = a.getBoolean(R.styleable.StartBar_is_need_touch, false);
        //文本颜色
        default_color = a.getResourceId(R.styleable.StartBar_text_color,R.color.public_orange);
        //星星高度
        default_height = a.getResourceId(R.styleable.StartBar_star_height,30);
        a.recycle();
        removeAllViews();
        for(int i=0;i<5;i++){
            ImageView imageView=new ImageView(context);
            imageView.setTag(i);
            imageView.setImageResource(R.drawable.selector_start);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!isNeedTouch){
                        return;
                    }
                    //修改选中的评分
                    ImageView imageView= (ImageView) v;
                    position = (int) imageView.getTag();
                    if(imageView.isSelected()){
                        setCore(position);
                    }else {
                        setCore(position+1);
                    }


                }


            });
            addView(imageView);
        }
        scoreView = new TextView(context);
        scoreView.setText("0.0分");
        scoreView.setTextColor(getResources().getColor(default_color));
        if(isNeedScore) scoreView.setVisibility(VISIBLE);
        else  scoreView.setVisibility(GONE);
        addView(scoreView);
         invalidate();
        for(int i=0;i<getChildCount();i++){
            View childAt = getChildAt(i);
            if(childAt instanceof ImageView){
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height=default_height;
                layoutParams.width=default_height;
                childAt.setLayoutParams(layoutParams);

            }
        }
    }

    /**
     * 设置分数
     * @param score
     */
    public void setCore(int score) {

        scoreView.setText((double)(score)+"分");
        for(int i=0;i<getChildCount();i++){
            if(i< score)
                getChildAt(i).setSelected(true);
            else getChildAt(i).setSelected(false);
        }
        invalidate();
    }


    /**
     * 获取分数
     */
    public int getScore(){
        return position+1;
    }
}
