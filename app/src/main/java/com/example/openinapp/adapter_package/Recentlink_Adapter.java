package com.example.openinapp.adapter_package;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.openinapp.R;
import com.example.openinapp.data_package.RecentLink;
import com.example.openinapp.data_package.TopLink;

import java.util.List;

public class Recentlink_Adapter extends RecyclerView.Adapter<Recentlink_Adapter.ItemViewHolder> {
    List<RecentLink>recentLinks;
    Context context;
View view;
    public Recentlink_Adapter(List<RecentLink> recentLinks, Context context) {
        this.recentLinks = recentLinks;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.top_links_layout,parent,false);

        return  new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        RecentLink recentLink =recentLinks.get(position);
        Glide.with(context).load(recentLink.getOriginal_image()).into(holder.orgnal_image);
        holder.urlid.setText("  User_Id: " + String.valueOf(recentLink.getUrl_id()));
        holder.weblink.setText("  Weblink: " + recentLink.getWeb_link());
        holder.smartlink.setText("  Toplink: " +recentLink.getMart_link());
        holder.title.setText("  Title: " + recentLink.getTitle());
        holder.totalclicks.setText("  Totalclicks: " + String.valueOf(recentLink.getTotal_clicks()));
        if (recentLink.getThumbnail() == null) {
            holder.thumbnail.setText("  Thumbnail: " + null);
        } else {
            holder.thumbnail.setText("  Thumbnail: " + recentLink.getThumbnail());

        }

        holder.times_ago.setText("  Times_ago: " + recentLink.getTimesAgo());
        holder.created_at.setText("  Created_at: " + recentLink.getCreated_at());
        holder.domain_id.setText("  Domain_Id: " + recentLink.getDomain_id());
        holder.url_prifix.setText("  Url_prifix: " + recentLink.getUrl_prefix());
        holder.url_suffix.setText("  Url_suffix: " + recentLink.getUrl_suffix());
        holder.app.setText("  App: " + recentLink.getApp());

    }

    @Override
    public int getItemCount() {
        return recentLinks.size();
    }

    public  class  ItemViewHolder extends RecyclerView.ViewHolder{
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
