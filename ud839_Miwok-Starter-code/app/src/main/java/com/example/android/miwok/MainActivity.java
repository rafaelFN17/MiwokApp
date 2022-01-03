/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //referenciando o textView da tela correspondente ao numbers
        TextView numbers = (TextView)findViewById(R.id.numbers);


        //definindo o clickListener no textview de numbers
        numbers.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Criando intent que para chamar activity numbers
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                //chamando activity numbers
                startActivity(numbersIntent);
            }
        });

        //referenciando o textView da tela correspondente ao colors
        TextView colors = (TextView)findViewById(R.id.colors);

        // definindo o clickListener no textview de colors
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criando intent para chamar activity colors
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                //chamando activity colors
                startActivity(colorsIntent);
            }
        });

        //referenciando o textView da tela correspondente ao phrases
        TextView phrases = (TextView)findViewById(R.id.phrases);

        //definindo o clickListener no textview de phrases
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criando intent para chamar activity phrases
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                //chamando activity phrases
                startActivity(phrasesIntent);
            }
        });

        //referenciando o textview da tela correspondente ao family
        TextView family = (TextView)findViewById(R.id.family);

        //definindo o clickListener no textview de family
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criando intent para chamar activity family
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);

                //chamando activity family
                startActivity(familyIntent);
            }
        });


    }
}
