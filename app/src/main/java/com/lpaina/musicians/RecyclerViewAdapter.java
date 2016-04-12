package com.lpaina.musicians;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hugo.weaving.DebugLog;

@DebugLog
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CardHolder> {

    private List<Musician> musicians;

    public RecyclerViewAdapter(List<Musician> musicians) {
        this.musicians = musicians;
    }

    @Override
    public int getItemCount() {
        return musicians.size();
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(CardHolder cardHolder, int i) {
        Musician musician = musicians.get(i);
        cardHolder.imageViewPhoto.setImageDrawable(musician.getPhoto());
        cardHolder.textViewName.setText(musician.getName());
        cardHolder.textViewStyle.setText(musician.getStyleString());

        String contentFormat = cardHolder.context.getString(R.string.content_format);
        String content = String.format(contentFormat, musician.getAlbumsNum(), musician.getSongsNum());
        cardHolder.textViewContent.setText(content);
    }

    public static class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final Context context;
        ImageView imageViewPhoto;
        TextView textViewName;
        TextView textViewStyle;
        TextView textViewContent;

        CardHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            imageViewPhoto = (ImageView) itemView.findViewById(R.id.photo_small);
            textViewName = (TextView) itemView.findViewById(R.id.field_name);
            textViewStyle = (TextView) itemView.findViewById(R.id.field_style);
            textViewContent = (TextView) itemView.findViewById(R.id.field_content);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailsActivity.class);
            context.startActivity(intent);
        }

    }

}
