package com.example.openinapp.adapter_package;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.openinapp.R;
import com.example.openinapp.data_package.TopLink;

import java.util.List;

public class Toplinks_Adapter extends RecyclerView.Adapter<Toplinks_Adapter.ItemViewHolder> {
    List<TopLink> topLinkList;
    Context context;
    View view;

    public Toplinks_Adapter(List<TopLink> topLinkList, Context context) {
        this.topLinkList = topLinkList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_links_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TopLink topLink = topLinkList.get(position);
        Glide.with(context).load(topLink.getOriginal_image()).into(holder.orgnal_image);
        holder.urlid.setText("User_Id:    " + String.valueOf(topLink.getUrl_id()));
        holder.weblink.setText("Weblink:    " + topLink.getWeb_link());
        holder.smartlink.setText("Toplink:    " + topLink.getSmart_link());
        holder.title.setText("Title:    " + topLink.getTitle());
        holder.totalclicks.setText("Totalclicks:    " + String.valueOf(topLink.getTotal_clicks()));
        if (topLink.getThumbnail() == null) {
            holder.thumbnail.setText("Thumbnail:    " + null);
        } else {
            holder.thumbnail.setText("Thumbnail:    " + topLink.getThumbnail());

        }

        holder.times_ago.setText("Times_ago:    " + topLink.getTimes_ago());
        holder.created_at.setText("Created_at:    " + topLink.getCreated_at());
        holder.domain_id.setText("Domain_Id:    " + topLink.getDomain_id());
        holder.url_prifix.setText("Url_prifix:    " + topLink.getUrl_prefix());
        holder.url_suffix.setText("Url_suffix:    " + topLink.getUrl_suffix());
        holder.app.setText("App:    " + topLink.getApp());


    }

    @Override
    public int getItemCount() {
        return topLinkList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView orgnal_image;
        TextView urlid, weblink, smartlink, title, totalclicks, thumbnail, times_ago, created_at, domain_id, url_prifix, url_suffix, app;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            orgnal_image = itemView.findViewById(R.id.imageview);
            urlid = itemView.findViewById(R.id.url_id);
            weblink = itemView.findViewById(R.id.weblink);
            smartlink = itemView.findViewById(R.id.smartlink);
            title = itemView.findViewById(R.id.title);
            totalclicks = itemView.findViewById(R.id.total_click);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            times_ago = itemView.findViewById(R.id.times_ago);
            created_at = itemView.findViewById(R.id.created_at);
            domain_id = itemView.findViewById(R.id.domain_id);
            url_prifix = itemView.findViewById(R.id.url_prifix);
            url_suffix = itemView.findViewById(R.id.url_suffix);
            app = itemView.findViewById(R.id.app);
        }
    }
}
