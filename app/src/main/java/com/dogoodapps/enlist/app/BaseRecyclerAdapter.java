package com.dogoodapps.enlist.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public abstract class BaseRecyclerAdapter<T, V extends View> extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder<V>> {

	private Context context;

	private List<T> list = Collections.emptyList();

	public BaseRecyclerAdapter(Context context) {
		super();
		this.context = context;
	}

	public Context getContext() {
		return context;
	}

	protected abstract V newView(Context context);

	protected abstract void bind(T value, V view);

	@Override
	public ViewHolder<V> onCreateViewHolder(ViewGroup viewGroup, int pos) {
		return new ViewHolder<>(newView(context));
	}

	@Override
	public void onBindViewHolder(ViewHolder<V> viewHolder, int pos) {
		bind(list.get(pos), viewHolder.view);
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void refresh() {
		notifyDataSetChanged();
	}

	public static class ViewHolder<V extends View> extends RecyclerView.ViewHolder {
		V view;

		public ViewHolder(V v) {
			super(v);
			view = v;
		}
	}

}