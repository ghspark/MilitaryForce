package com.gh.app.militaryforce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.bean.Images;
import com.gh.app.militaryforce.bean.News;
import com.gh.app.militaryforce.util.AppController;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gaohang on 15/9/24.
 */
public class NewsAdapter extends BaseAdapter {
    private List<News> list_news;

    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
        list_news = new ArrayList<News>();
    }

  public void addDatas(List<News> news) {
        list_news.addAll(news);
    }

    @Override
    public int getCount() {
        return list_news.size();
    }

    @Override
    public Object getItem(int position) {
        return list_news.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            TextViewHolder textViewHolder = null;
            ImageViewHolder imageViewHolder = null;
            if (list_news.get(position).getImageurls().size()<=1) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.news_text_item, parent, false);
                    textViewHolder = new TextViewHolder(convertView);
                    convertView.setTag(textViewHolder);
                } else {
                    textViewHolder = (TextViewHolder) convertView.getTag();

                }
                String title = list_news.get(position).getTitle();
                String body = list_news.get(position).getDesc();
                int comment_count = list_news.get(position).getComment().getCount();

                textViewHolder.d_title.setText(title == null ? "sorry" : title);
                textViewHolder.d_body.setText(body == null ? "sorry" : body);
                textViewHolder.d_comment_count.setText(comment_count + "");
                List<Images> img = list_news.get(position).getImageurls();
                AppController.getInstance()
                        .getImageLoader().get(img.get(0).getUrl(), ImageLoader.getImageListener(textViewHolder.d_pic, R.drawable.default_ptr_flip, R.drawable.app_icon));


            } else {
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.news_image_item, parent, false);
                    imageViewHolder = new ImageViewHolder(convertView);
                    convertView.setTag(imageViewHolder);
                } else {
                    imageViewHolder = (ImageViewHolder) convertView.getTag();

                }

                String title = list_news.get(position).getTitle();
                int comment_count = list_news.get(position).getComment().getCount();
                imageViewHolder.new_title.setText(title == null ? "sorry" : title);
                imageViewHolder.news_comment_count.setText(comment_count + "");
                AppController.getInstance().getImageLoader().get(list_news.get(position).getImageurls().get(0).getUrl(), ImageLoader.getImageListener(imageViewHolder.news_iv1, R.drawable.default_ptr_flip, R.drawable.app_icon));
                AppController.getInstance().getImageLoader().get(list_news.get(position).getImageurls().get(1).getUrl(), ImageLoader.getImageListener(imageViewHolder.news_iv2, R.drawable.default_ptr_flip, R.drawable.app_icon));
                AppController.getInstance().getImageLoader().get(list_news.get(position).getImageurls().get(2).getUrl(), ImageLoader.getImageListener(imageViewHolder.news_iv3, R.drawable.default_ptr_flip, R.drawable.app_icon));

            }



        return convertView;
    }

    static class TextViewHolder {
        @Bind(R.id.d_title)
        TextView d_title;
        @Bind(R.id.d_body)
        TextView d_body;
        @Bind(R.id.d_pic)
        ImageView d_pic;
        @Bind(R.id.d_comment_count)
        TextView d_comment_count;

        public TextViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ImageViewHolder {
        @Bind(R.id.new_title)
        TextView new_title;
        @Bind(R.id.news_iv1)
        ImageView news_iv1;
        @Bind(R.id.news_iv2)
        ImageView news_iv2;
        @Bind(R.id.news_iv3)
        ImageView news_iv3;
        @Bind(R.id.news_comment_count)
        TextView news_comment_count;

        public ImageViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
