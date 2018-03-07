/*=====================================================================
□ Infomation
  ○ Data : 07.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ 맞춤형 비트맵 버튼 정의
     - 기존 버튼 객체(AppCompatButton)를 상속받아서 재정의

□ Study
  ○
=====================================================================*/
package com.eun1310434.bitmapwidget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BitmapButton extends AppCompatButton {
	public static int STATUS_NORMAL = 0; //non clicked
	public static int STATUS_CLICKED = 1; //clicked

	// Button NORMAL
	int iconNormal = R.drawable.bitmap_button_normal;
	int defaultTextColor = getResources().getColor(R.color.colorAccent); //Color.WHITE; // 글씨색
	float defaultTextSize = getResources().getDimension(R.dimen.text_size); // 글씨 크기
	Typeface defaultTypeface = Typeface.SANS_SERIF;  //Typeface.DEFAULT_BOLD; // 굵은 글씨

	// Bujtton  CLICKED
	int iconClicked = R.drawable.bitmap_button_clicked;
	int ClickedTextColor = Color.WHITE; // 글씨색
	float ClickedTextSize = getResources().getDimension(R.dimen.text_size); // 글씨 크기
	Typeface ClickedTypeface = Typeface.DEFAULT_BOLD;  //Typeface.DEFAULT_BOLD; // 굵은 글씨

	// 아이콘 상태 : STATUS_NORMAL, STATUS_CLICKED
	int iconStatus = STATUS_NORMAL;


	// [필수] 생성자
	public BitmapButton(Context context) {
		super(context);
		normal();
	}

	// [필수] 생성자
	public BitmapButton(Context context, AttributeSet atts) {
		super(context, atts);
		normal();
	}

	// 초기화
	public void normal() {
		setBackgroundResource(iconNormal);
		setTextColor(defaultTextColor);
		setTextSize(defaultTextSize);
		setTypeface(defaultTypeface);
		iconStatus = STATUS_NORMAL;
	}

	public void clicked() {
		setBackgroundResource(iconClicked);
		setTextColor(ClickedTextColor);
		setTextSize(ClickedTextSize);
		setTypeface(ClickedTypeface);
		iconStatus = STATUS_CLICKED;
	}


	// 아이콘 리소스 설정
	public void setIcon(int iconNormal, int iconClicked) {
		this.iconNormal = iconNormal;
		this.iconClicked = iconClicked;
	}

	// Handles touch event, move to main screen
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);

		int action = event.getAction();

		switch (action) {
			case MotionEvent.ACTION_DOWN:
				clicked();
				break;

			case MotionEvent.ACTION_OUTSIDE:
			case MotionEvent.ACTION_CANCEL:
			case MotionEvent.ACTION_UP:
				normal();
				break;
		}
		// 다시 그리기
		invalidate();
		return true;
	}

}
