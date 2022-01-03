package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    // resource id da cor de fundo das listas de palavras
    private int mColorResourceId;

    //construtor reutiliza o construtor retirando a utilização de getView
    public WordAdapter(Activity context, ArrayList<Word> Word, int colorResourceId){
        super(context, 0, Word);
        mColorResourceId = colorResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //localizando objeto da lista
        Word currentWord = getItem(position);

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //conectando com o textview do list_item.xml
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //setando o texto do TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //conectando com o textview do list_item.xml
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //setando o texto do TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


            //conectando com o imageview do list_item.xml
            ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            //setando a imagem do imageview
            image.setImageResource(currentWord.getmImageResouceId());
            //tornando a imageView visivel
            image.setVisibility(View.VISIBLE);
        }else {
            // tornando imageview invisivel para phrasesactivity
            image.setVisibility(View.GONE);
        }

        //setando cor de fundo da lista no layout
        View textContainer = listItemView.findViewById(R.id.text_container);
        //recuperando a cor nos recursos
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);


        return listItemView;

    }
}
