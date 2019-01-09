package com.jamper.swipemenulistview.swipe;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/**
 * 
 * @author baoyz
 * @date 2014-8-23
 * 
 */
public class SwipeMenuItem {

	private int id;
	private Context mContext;
	private String title;
	private Drawable icon;
	private Drawable background;
	private int titleColor;
	private int iconTintColor = 0;
	private int titleSize;
	private int width;
	private int layoutBackgroundColor = 0;
	private Margins margins;
	private String fontName;
	private int imageWidth = 15;
	private int imageHeight = 15;

	public SwipeMenuItem(Context context) {
		mContext = context;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTitleColor() {
		return titleColor;
	}

	public int getTitleSize() {
		return titleSize;
	}

	public void setTitleSize(int titleSize) {
		this.titleSize = titleSize;
	}

	public void setTitleColor(int titleColor) {
		this.titleColor = titleColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(int resId) {
		setTitle(mContext.getString(resId));
	}

	public Drawable getIcon() {
		return icon;
	}

	public void setIcon(Drawable icon) {
		this.icon = icon;
	}

	public void setIcon(int resId) {
		this.icon = mContext.getResources().getDrawable(resId);
	}

	public Drawable getBackground() {
		return background;
	}

	public void setBackground(Drawable background) {
		this.background = background;
	}

	public void setBackground(int resId) {
		this.background = mContext.getResources().getDrawable(resId);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getIconTintColor() {
		return iconTintColor;
	}

	public void setIconTintColor(int iconTintColor) {
		this.iconTintColor = mContext.getResources().getColor(iconTintColor);
	}

	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

	public int getLayoutBackgroundColor() {
		return layoutBackgroundColor;
	}

	public void setLayoutBackgroundColor(int layoutBackgroundColor) {
		this.layoutBackgroundColor = mContext.getResources().getColor(layoutBackgroundColor);
	}

	public Margins getMargins() {
		return margins;
	}

	public void setMargins(Margins margins) {
		this.margins = margins;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public String getFontName() {
		return this.fontName;
	}

	public void setImageSize(int imageWidth, int imageHeight){
		this.imageWidth = dp2px(imageWidth);
		this.imageHeight = dp2px(imageHeight);
	}

	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, mContext.getResources().getDisplayMetrics());
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}
}
