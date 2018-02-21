package com.example.denis.vrgcoursesapp.ui.adapter;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denis.vrgcoursesapp.R;
import com.example.denis.vrgcoursesapp.data.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticlesRecyclerAdapter.ViewHolder> {

    private List<Article> mArticles;

    private Context mContext;

    private ArticleItemListener mItemListener;

    private boolean mIsFavorites;

    public ArticlesRecyclerAdapter(List<Article> articles, Context context, @Nullable ArticleItemListener itemListener, boolean isFavorites) {
        mArticles = articles;
        mContext = context;
        mItemListener = itemListener;
        mIsFavorites = isFavorites;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article_card, parent, false);

        return new ArticlesRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleView.setText(mArticles.get(position).getTitle());
        holder.authorView.setText(mArticles.get(position).getAuthor());
        holder.dateView.setText(mArticles.get(position).getPublishedDate());

        if (mIsFavorites) {
            holder.favoriteView.setVisibility(View.GONE);
        }

        Picasso.with(mContext)
                .load(mArticles.get(position).getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public void setArticlesList(List<Article> articles) {
        mArticles = articles;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private ImageButton favoriteView;
        private TextView titleView;
        private TextView authorView;
        private TextView dateView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.card_avatar);
            titleView = view.findViewById(R.id.card_title);
            authorView = view.findViewById(R.id.card_author);
            dateView = view.findViewById(R.id.list_date);
            favoriteView = view.findViewById(R.id.favourite_button);

            favoriteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemListener != null) {
                        mItemListener.onFavoriteAddClicked(mArticles.get(getAdapterPosition()));
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemListener != null) {
                        mItemListener.onArticleClicked(mArticles.get(getAdapterPosition()));
                    }
                }
            });
        }
    }

    public interface ArticleItemListener {

        void onArticleClicked(Article clickedArticle);

        void onFavoriteAddClicked(Article favoritedArticle);
    }

}
