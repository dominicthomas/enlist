package com.dogoodapps.enlist.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.model.Movie;

import butterknife.ButterKnife;

public class MoviesAdapter extends BaseRecyclerAdapter<Movie, View> {

	public MoviesAdapter(Context context) {
		super(context);
	}

	@Override
	protected View newView(Context context) {
		return View.inflate(context, R.layout.view_listitem_row, null);
	}

	@Override
	protected void bind(Movie value, View view) {
		final TextView title = ButterKnife.findById(view, R.id.title);
		title.setText(value.getTitle());
	}

}
