package com.example.deneme;

import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter myAdapter;
    private Button btn_listen, btn1, btn2, btn3;
    private int position;

    String toSpeak;
    TextToSpeech t1;


    public String[] dinle_btn_txttoSpeak_list = {
            "Resimde kaç adet karpuz var?",
            "Resimde kaç adet havuç var?",
            "Resimde kaç adet elma var?",
            "Resimde kaç adet armut var?",
            "Resimde kaç adet badem var?",
            "Resimde kaç adet çilek var?",
            "Resimde kaç adet kayısı var?",
            "Resimde kaç adet şeftali var?",
            "Resimde kaç adet kavun var?"

    };

    public String[] btn1_txttoSpeak_list = {
            "BİR",
            "ÜÇ",
            "ÜÇ",
            "SEKİZ",
            "ALTI",
            "BEŞ",
            "ALTI",
            "DOKUZ",
            "BEŞ"
    };



    public String[] btn2_txttoSpeak_list = {
            "İKİ",
            "DÖRT",
            "BEŞ",
            "İKİ",
            "DÖRT",
            "YEDİ",
            "ÜÇ",
            "ALTI",
            "İKİ"
    };

    public String[] btn3_txttoSpeak_list = {
            "ÜÇ",
            "ALTI",
            "YEDİ",
            "DÖRT",
            "DOKUZ",
            "SEKİZ",
            "DÖRT",
            "BEŞ",
            "ÜÇ"
    };

    public String[] btn1_number_list3 = {
            "1",
            "3",
            "3",
            "8",
            "6",
            "5",
            "6",
            "9",
            "5"
    };

    public Integer[] btn1_number_list4 = {1,3,3,8,6,5,6,9,5};



    public String[] right_btn_txttoSpeak_list = {};

    public int[] right_btn_id_list = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    t1.setLanguage(new Locale("tr", "TR"));
                }
            }
        });

        viewPager = (ViewPager)findViewById(R.id.viewPager_meyve_sayi);
        myAdapter = new SlideAdapter(this);
        viewPager.setAdapter(myAdapter);

        // renkleri int olarak tanımlayıp renk kodu çevrimi yapıldı.
        int Red = Color.parseColor("#DE1435");
        int Yellow = Color.parseColor("#F2F057");
        int Orange = Color.parseColor("#ED9242");
        int Green = Color.parseColor("#3CB56C");


        // image_meyve_sayi değiştikçe btn1, btn2, btn3 ünde rengini
        // sorulan meyvenin rengine ayarlayacak listeyi tanımladık.
        final List<Integer> btn_color_list = new ArrayList<Integer>();
        btn_color_list.add(Green);
        btn_color_list.add(Orange);
        btn_color_list.add(Red);
        btn_color_list.add(Yellow);
        btn_color_list.add(Green);
        btn_color_list.add(Red);
        btn_color_list.add(Yellow);
        btn_color_list.add(Red);
        btn_color_list.add(Yellow);


        // btn1 de sirayla gorulecek sayilarin listesi
        final List<Integer> btn1_number_list1 = new ArrayList<Integer>();
        btn1_number_list1.add(1);
        btn1_number_list1.add(3);
        btn1_number_list1.add(3);
        btn1_number_list1.add(8);
        btn1_number_list1.add(6);
        btn1_number_list1.add(5);
        btn1_number_list1.add(6);
        btn1_number_list1.add(9);
        btn1_number_list1.add(5);


        // btn2 de sirayla gorulecek sayilarin listesi
        // final List<CharSequence> btn2_number_list = new ArrayList<CharSequence>();

        //);

        final CharSequence [] btn1_number_list2 = {
                "2",
                "4",
                "5",
                "2",
                "4",
                "7",
                "3",
                "6",
                "2"
        };




        // btn3 de sirayla gorulecek sayilarin listesi
       /* final List<Integer> btn3_number_list = new ArrayList<Integer>();
        btn3_number_list.add(3);
        btn3_number_list.add(6);
        btn3_number_list.add(7);
        btn3_number_list.add(4);
        btn3_number_list.add(9);
        btn3_number_list.add(8);
        btn3_number_list.add(4);
        btn3_number_list.add(5);
        btn3_number_list.add(3);
*/
        // activity_meyve_sayi içerisindeki id lere göre
        // MeyveSayiActivity içerisindeki btn lar tanımlandi
        btn1 = findViewById(R.id.btn_meyve_sayisi_1);
        btn2 = findViewById(R.id.btn_meyve_sayisi_2);
        btn3 = findViewById(R.id.btn_meyve_sayisi_3);

        // burada ilk sayfa acildiginda buton renkleri
        // goruntulenen sayılar ayarlandi
        btn1.setBackgroundColor(btn_color_list.get(position));
        //   btn1.setText(btn1_number_list.get(position));
        btn2.setBackgroundColor(btn_color_list.get(position));
        //  btn2.setText(btn2_number_list.get(position));
        btn3.setBackgroundColor(btn_color_list.get(position));
        //   btn3.setText(btn3_number_list.get(position));

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                toSpeak = dinle_btn_txttoSpeak_list[position];
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);

                btn1.setBackgroundColor(btn_color_list.get(position));
                btn2.setBackgroundColor(btn_color_list.get(position));
                btn3.setBackgroundColor(btn_color_list.get(position));


               btn1.setText(btn1_number_list1.get(position));
              //  btn1.setText("10");
                int sayi1;
                //sayi1 = btn1_number_list4[position];
               // btn1.setText(Integer.getInteger(btn1_number_list3[position]));
               // btn1.toString();





            }
        });

    }


}
