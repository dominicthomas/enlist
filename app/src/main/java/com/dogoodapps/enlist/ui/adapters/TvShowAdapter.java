package com.dogoodapps.enlist.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.model.TvShow;

import butterknife.ButterKnife;

public class TvShowAdapter extends BaseRecyclerAdapter<TvShow, View> {

	public TvShowAdapter(Context context) {
		super(context);
	}

	@Override
	protected View newView(Context context) {
		return View.inflate(context, R.layout.view_listitem_row, null);
	}

	@Override
	protected void bind(TvShow value, View view) {
		final TextView title = ButterKnife.findById(view, R.id.title);
		title.setText(value.getName());
	}

}
