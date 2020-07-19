package com.example.imageswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
Button next,pre;
ImageSwitcher img;
int position=0;
int[]images={R.drawable.first,R.drawable.second};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next=(Button)findViewById(R.id.next);
        pre=(Button)findViewById(R.id.pre);
        img=(ImageSwitcher)findViewById(R.id.img);
        img.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgv = new ImageView(MainActivity.this);
                imgv.setImageResource(images[position]);
                return imgv;
            }
        });
        img.setInAnimation(this,android.R.anim.slide_in_left);
        img.setOutAnimation(this,android.R.anim.slide_out_right);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>0)
                {
                    position--;
                } else if(position<0)
                {
                    position=0;
                }
                img.setImageResource(images[position]);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<images.length)
                {
                    position++;
                }
                if(position>images.length)
                {
                    position=images.length-1;
                    img.setImageResource(images[position]);
                }
            }
        });
    }
}
