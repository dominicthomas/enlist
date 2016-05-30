package com.dogoodapps.enlist.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.ui.adapters.BaseRecyclerAdapter;
import com.dogoodapps.enlist.ui.presenters.BasePresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

// TODO: Tests / PTR?
public abstract class BaseMVPListFragment<P extends BasePresenter, A extends BaseRecyclerAdapter> extends Fragment {

	@InjectView(R.id.recycler_view)
	public RecyclerView recyclerView;

	private P presenter;

	private A adapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.presenter = initialisePresenter();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_base, container, false);
		ButterKnife.inject(this, view);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		adapter = initialiseAdapter();
		initialiseList();
		init();
	}

	private void initialiseList() {
		recyclerView.setHasFixedSize(true);
		LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		llm.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(llm);
		recyclerView.setAdapter(adapter);
	}

	protected abstract void init();

	protected abstract A initialiseAdapter();

	protected abstract P initialisePresenter();

	public P getPresenter() {
		return presenter;
	}

	public A getAdapter() {
		return adapter;
	}

}
