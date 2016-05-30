package com.dogoodapps.enlist.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {

	private static ImageLoader INSTANCE;

	public static ImageLoader getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ImageLoader();
		}
		return INSTANCE;
	}

	public void load(Context context, String url, ImageView imageView) {
		Glide.with(context)
			.load(url)
			.centerCrop()
			//.placeholder(R.drawable)
			.crossFade().into(imageView);
	}

}
