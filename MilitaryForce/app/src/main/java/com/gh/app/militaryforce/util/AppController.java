package com.gh.app.militaryforce.util;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

//import com.desmond.facebook_like_feed.volley.CustomVolley;
//import com.desmond.facebook_like_feed.volley.LruBitmapCache;

/**
 * Created by desmond on 13/7/14.
 */
public class AppController extends Application {

	public static final String TAG = AppController.class.getSimpleName();
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private LruBitmapCache mLruBitmapCache;

	private static AppController mInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;

	}

	public static synchronized AppController getInstance() {
		// Log.d("gaohang", "hello android1");
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		Log.d("gaohang", "hello android");
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public  ImageLoader getImageLoader() {
		getRequestQueue();
		if (mImageLoader == null) {
			getLruBitmapCache();
			mImageLoader = new ImageLoader(this.mRequestQueue, mLruBitmapCache);
		}

		return mImageLoader;
	}

	public LruBitmapCache getLruBitmapCache() {
		if (mLruBitmapCache == null) {
			mLruBitmapCache = new LruBitmapCache();
		}
		return mLruBitmapCache;
	}

	public void addToRequestQueue(Request<?> req, String tag) {
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		getRequestQueue().add(req);
	}

	public void addToRequestQueue(Request<?> req) {
		req.setTag(TAG);
		Log.d("gaohang", "hello android");
		getRequestQueue().add(req);

	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}
}