package com.gh.app.militaryforce.ui;


import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.fragment.NewsFragment;

public enum MainTab {

	NEWS(0, R.string.main_tab_name_news, R.drawable.tab_icon_news,
			NewsFragment.class),

	PICTURES(1, R.string.main_tab_name_pics, R.drawable.tab_icon_pics,
			NewsFragment.class),

	VIDEOS(2, R.string.main_tab_name_videos, R.drawable.tab_icon_videos,
			NewsFragment.class),

	ME(3,R.string.main_tab_name_me, R.drawable.tab_icon_me,
			NewsFragment.class);


/*	QUICK(2, R.string.main_tab_name_quick, R.drawable.tab_icon_new,
			null),
*/
	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> clz;

	private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
		this.idx = idx;
		this.resName = resName;
		this.resIcon = resIcon;
		this.clz = clz;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
}
