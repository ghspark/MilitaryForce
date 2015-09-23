package com.gh.app.militaryforce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.bean.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitysAdapter extends BaseAdapter implements SectionIndexer {
	private List<City> list_city = new ArrayList<City>();
	private Context context;

	public CitysAdapter(Context context) {
		this.context=context;
	}
	
	
	public void addData(List<City> list_city){
		Collections.sort(list_city, new Comparator<City>() {


			@Override
			public int compare(City lhs, City rhs) {
				return lhs.getCity_pre().compareTo(rhs.getCity_pre());
			}
		});
		this.list_city=list_city;
	}
	
	public void setCurrentCity(String cityname){


		for(int i=0;i<list_city.size();i++){
			if(list_city.get(i).getCity_name().equals(cityname)){
				City city=list_city.get(i);
				list_city.remove(i);
				list_city.add(0, city);
			}
			
		}
	}
	
	public void remove(City city){
		list_city.remove(city);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return list_city.size();
	}

	@Override
	public Object getItem(int position) {
		return list_city.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.select_city_item, null);
			viewHolder = new ViewHolder();
			viewHolder.group_title = (TextView) convertView.findViewById(R.id.group_title);
			viewHolder.column_title = (TextView) convertView
					.findViewById(R.id.column_title);
			
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		
		City city=list_city.get(position);
		final String name=city.getCity_name();
		final String avatar=city.getCity_pre();
		viewHolder.column_title.setText(name);

		int section = getSectionForPosition(position);
		if(position==0){
			viewHolder.group_title.setVisibility(View.VISIBLE);
			viewHolder.group_title.setText("选择当前城市");	
		}
		else if (position==1 || position == getPositionForSection(section)) {
			viewHolder.group_title.setVisibility(View.VISIBLE);
			viewHolder.group_title.setText(city.getCity_pre());
		} else {
			viewHolder.group_title.setVisibility(View.GONE);
		}
		

		return convertView;
	}

	@Override
	public Object[] getSections() {
		return null;
	}

	@Override
	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = list_city.get(i).getCity_pre();
			char firstChar = sortStr.toUpperCase().charAt(0);
			if (firstChar == section){
				return i;
			}
		}
		return -1;
	}
	
	
	@Override
	public int getSectionForPosition(int position) {
		return list_city.get(position).getCity_pre().charAt(0);
	}
	
	static class ViewHolder {
        TextView group_title;
		TextView column_title;
	
	}

	

	

}
