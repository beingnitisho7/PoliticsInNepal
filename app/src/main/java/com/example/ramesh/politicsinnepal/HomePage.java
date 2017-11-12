package com.example.ramesh.politicsinnepal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import com.daimajia.slider.library.Transformers.BaseTransformer;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.ramesh.politicsinnepal.Adapters.HomeLayout_Adapter;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.SlideInEffect;

public class HomePage extends Activity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    private SliderLayout mHomeSlider;

    JazzyListView list_menu;
    LinearLayout upperPart;
    TextView brkNews;
    ImageView disclaimer,aboutDevelopers;


    String[] menuItems ={

            "पार्टी उम्मेदवारहरू",
            "पार्टीहरूको जानकारी",
            "चुनाव सम्बन्धी शिक्षा",
            "नागरिक सर्वेक्षण",
    };


    Integer[] menuId={

            R.drawable.candidates,
            R.drawable.information,
            R.drawable.education,
            R.drawable.poll,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        disclaimer = (ImageView)findViewById(R.id.appDisclaimer);
        aboutDevelopers = (ImageView)findViewById(R.id.aboutDevelopers);

        aboutDevelopers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this,"About Developers", Toast.LENGTH_SHORT).show();

            }
        });

        disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(HomePage.this);
                TextView textView=new TextView(HomePage.this);
                dialog.setTitle("Disclaimer!!!");
                textView.setTextSize(18);
                textView.setText(R.string.disclaimer);
                dialog.setContentView(textView);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                dialog.show();

            }
        });


        brkNews = (TextView)findViewById(R.id.breaking_news);

      //Replace the textview with new news in every 3 seconds

        final int[] array = {R.string.text1, R.string.text2,R.string.text3,R.string.text4,R.string.text5,R.string.text6,R.string.text7};
        brkNews.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                brkNews.setText(array[i]);
                i++;
                if (i ==array.length)
                    i = 0;
                brkNews.postDelayed(this, 3000);
            }
        });

        brkNews.setMovementMethod(new ScrollingMovementMethod());


        HomeLayout_Adapter homeLayoutAdapter = new HomeLayout_Adapter(this, menuItems, menuId);
        list_menu = (JazzyListView) findViewById(R.id.menuList);
        upperPart = (LinearLayout) findViewById(R.id.layout_top);
        list_menu.setTransitionEffect(new SlideInEffect());
        list_menu.setAdapter(homeLayoutAdapter);

        list_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int pos= (int) parent.getAdapter().getItemId(position);
               // Toast.makeText(HomePage.this, String.valueOf(pos), Toast.LENGTH_LONG).show();
                    Intent secondPage;
                    secondPage=new Intent(HomePage.this,SecondaryPage.class);
                    secondPage.putExtra("pos",pos);
                    startActivity(secondPage);

            }
        });


        mHomeSlider = (SliderLayout) findViewById(R.id.homeSliderLayout);
        DefaultSliderView defaultSliderView = new DefaultSliderView(this);

        defaultSliderView.image(R.drawable.nepal);

        mHomeSlider.addSlider(defaultSliderView);
        mHomeSlider.stopAutoCycle() ;
        mHomeSlider.setPagerTransformer(false, new BaseTransformer() {
            @Override
            protected void onTransform(View view, float position) {

            }
        });

    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mHomeSlider.stopAutoCycle();
        super.onStop();
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
