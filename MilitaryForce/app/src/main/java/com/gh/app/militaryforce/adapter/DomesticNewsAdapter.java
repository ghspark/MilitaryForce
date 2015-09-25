package com.gh.app.militaryforce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.bean.News;
import com.gh.app.militaryforce.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gaohang on 15/9/25.
 */
public class DomesticNewsAdapter extends BaseAdapter {
    private List<News> demestic_list;
    private Context context;

    public DomesticNewsAdapter(Context context) {
        this.context = context;
        this.demestic_list = new ArrayList<News>();
    }

    public void addDatas(List<News> list_news) {
        //demestic_list.addAll(demestic_list.size(),list_news);
        demestic_list.addAll(list_news);
    }

    public void clearDataAll(){
        demestic_list=null;
    }

    @Override
    public int getCount() {
        return demestic_list.size();
    }

    @Override
    public Object getItem(int position) {
        return demestic_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){

            convertView= LayoutInflater.from(context).inflate(R.layout.demestic_news_item,parent,false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        String title=demestic_list.get(position).getTitle().trim();
        String body=demestic_list.get(position).getDesc().trim();
        String source = demestic_list.get(position).getSource().trim();
        body= StringUtils.replaceBlank(body);

        viewHolder.demestic_title.setText(title);
        viewHolder.demestic_body.setText(body);
        viewHolder.demestic_source.setText(source==null?"新浪":source);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.demestic_title)
        TextView demestic_title;
        @Bind(R.id.demestic_body)
        TextView demestic_body;
        @Bind(R.id.demestic_source)
        TextView demestic_source;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
