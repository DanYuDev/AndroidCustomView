package com.example.coderlt.bitmapshadertest.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * -----------------------------------------
 * CircleImageView
 * 继承自 ImageView，没有添加另外的属性
 * 对宽高测量做了简单处理，保证是一个正方形的View
 * ----------------------------------------
 * 利用 BitmapShader 渲染一个圆形，很容易得到这个 CircleImageView
 * 主要测试下继承 CircleImageView 可以利用哪些属性
 * Created by coderlt on 2018/2/4.
 */

public class CircleImageView extends ImageView {
    private static final String TAG = "CircleImageView";
    private int mWidth,mHeight;
    private Paint mPaint;
    private Bitmap bitmap;
    private float cx,cy;
    private float radius = -1;

    public CircleImageView(Context context){
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        if(radius == -1){
            mWidth = getMeasuredWidth();
            mHeight = getMeasuredHeight();

            radius = Math.min(mWidth,mHeight);
        }
        Log.d(TAG,"radius is :"+radius);
        // 得到最适合圆角图片的正方形
        setMeasuredDimension((int)radius,(int)radius);
    }

    /**
     * 调用完父构造函数（super(context,attrs)）之后，就可以得到 Drawable 对象
     */
    private void init(){
        // --------------------key  codes----------------------------------
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        bitmap = bitmapDrawable.getBitmap();
        //--------------------------------------------------------------
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
    }

    @Override
    protected void onSizeChanged(int x,int y,int oldx,int oldy){
        mWidth = x;
        mHeight = y;

        cx = x/2;
        cy = y/2;
        radius = Math.min(cx,cy);
    }

    @Override
    public void onDraw(Canvas canvas){

        canvas.drawCircle(cx,cy,radius,mPaint);
    }

    /**
     * 这两个方法是为了提供属性动画的 getter 和 setter 方法
     * @return
     */
    /*public float getRadius(){
        return radius;
    }*/

    public void setRadius(float radius){
        this.radius = radius;
        requestLayout();
    }

}
