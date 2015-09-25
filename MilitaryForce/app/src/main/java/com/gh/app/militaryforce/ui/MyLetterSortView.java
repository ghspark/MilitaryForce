package com.gh.app.militaryforce.ui;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.gh.app.militaryforce.R;

public class MyLetterSortView extends View {
	private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
	public String[] mLetter=null;

	private int choose = -1;

	private Paint paint = new Paint();

	private TextView mTextDialog;
	private float yPos = 0;

	public void setTextView(TextView mTextDialog) {
		this.mTextDialog = mTextDialog;
	}

	public MyLetterSortView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyLetterSortView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyLetterSortView(Context context) {
		super(context);
	}

	/**
	 * 将字母内容设置进来
	 * 
	 * 
	 */
	public void addDatas(String[] mLetter) {
		if (mLetter != null) {
			this.mLetter = new String[mLetter.length];
			this.mLetter = mLetter;
		}
	}


	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// ��ȡ����ı䱳����ɫ.
		if(mLetter!=null){
		
		int height = getHeight();// ��ȡ��Ӧ�߶�
		int width = getWidth(); // ��ȡ��Ӧ���
		// int singleHeight = height / mLetter.length;// ��ȡÿһ����ĸ�ĸ߶�
		int singleHeight = 40;

		for (int i = 0; i < mLetter.length; i++) {
			paint.setColor(Color.parseColor("#4876FF"));
			paint.setTypeface(Typeface.DEFAULT_BOLD);
			paint.setAntiAlias(true);
			// paint.setTextSize(PixelUtil.sp2px(12));
			paint.setTextSize(28);

			// ѡ�е�״̬
			if (i == choose) {
				paint.setColor(Color.parseColor("#3399ff"));
				paint.setFakeBoldText(true);
			}
			// x�������м�-�ַ��ȵ�һ��.
			float xPos = width / 2 - paint.measureText(mLetter[i]) / 2;
			if ((mLetter.length) % 2 == 1) {
				// float yPos = singleHeight * i + singleHeight;
				 yPos = (i - (mLetter.length - 1) / 2) * singleHeight
						+ (getHeight() / 2);
				 Log.d("ghsparkgaohang", "我是奇数"+yPos);
				 
			} 
			if ((mLetter.length) % 2 == 0){
				
				yPos = (float) ((i - (mLetter.length) / 2) * singleHeight
						+ 0.5 * singleHeight + 0.5 * getHeight());
				
				Log.d("ghsparkgaohang", "我是偶数"+yPos);
				
			}
			
			canvas.drawText(mLetter[i], xPos, yPos, paint);
			paint.reset();// ���û���
		}
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		final int action = event.getAction();
		final float y = event.getY();// ���y���
		final int oldChoose = choose;
		final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
		final int c = (int) (y / getHeight() * mLetter.length);// ���y�����ռ�ܸ߶ȵı���*b����ĳ��Ⱦ͵��ڵ��b�еĸ���.

		switch (action) {
		case MotionEvent.ACTION_UP:
			setBackgroundDrawable(new ColorDrawable(0x00000000));
			choose = -1;//
			invalidate();
			if (mTextDialog != null) {
				mTextDialog.setVisibility(View.INVISIBLE);
			}
			break;

		default:

			setBackgroundResource(R.drawable.letter_sort_background);
			if (oldChoose != c) {
				if (c >= 0 && c < mLetter.length) {
					if (listener != null) {
						listener.onTouchingLetterChanged(mLetter[c]);
					}
					if (mTextDialog != null) {
						mTextDialog.setText(mLetter[c]);
						mTextDialog.setVisibility(View.VISIBLE);
					}

					choose = c;
					invalidate();
				}
			}

			break;
		}
		return true;
	}

	/**
	 * ���⹫���ķ���
	 * 
	 * @param onTouchingLetterChangedListener
	 */
	public void setOnTouchingLetterChangedListener(
			OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
		this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
	}

	public interface OnTouchingLetterChangedListener {
		public void onTouchingLetterChanged(String s);
	}

}
