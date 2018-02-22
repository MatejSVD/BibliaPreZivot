package com.example.m.navigationdrawler22_6;

import android.content.Context;
import android.os.Bundle;
//import android.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//import android.app.Fragment;

import android.support.v4.app.Fragment;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

public class ModlitbaTab3 extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //pomohlo: http://stackoverflow.com/questions/17076663/problems-with-settext-in-a-fragment-in-oncreateview

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.modlitba3, container, false);

        //TextView textView;

        //@Override
        //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);

        TextView textView= (TextView) view.findViewById(R.id.text);

        XmlPullParserFactory pullParserFactory;

        //http://alvinalexander.com/java/simpledateformat-convert-date-to-string-formatted-parse
        Date today = Calendar.getInstance().getTime();

        // (2) create a date "formatter" (the date format we want)
        SimpleDateFormat formatter = new SimpleDateFormat("HH" , Locale.US);
        SimpleDateFormat formatter1 = new SimpleDateFormat("   ");

        // (3) create a new String using the date format we want
        String folderName = formatter.format(today);
        String folderName1 = formatter1.format(today);
        // (4) this prints "Folder Name = 02.10.06"


        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getActivity().getApplicationContext().getAssets().open("sample2.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            ArrayList<Zamyslenia> myslienky=  parseXML(parser);

            String text="";



            for(Zamyslenia country:myslienky)
            {
                //funkcia, ktora zo zoznamu vypise iba data s prislusnym datumom
                if(folderName.equals(country.getId()))
                    text+= "id : "+country.getId()+" name : "+country.getName()+" capital : "+country.getCapital()+"\n";
            }

            textView.setText(text);
            textView = (TextView) getActivity().findViewById(R.id.text);

            // funkcia pre scrolovanie textu https://www.youtube.com/watch?v=Vl61Qrz8NKQ
            // textView.setMovementMethod(new ScrollingMovementMethod());
            //loadText;

            // private void loadText(){
            //textView.setMovementMethod(new ScrollingMovementMethod());

            //}


        } catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }






        return view;
    }


    private ArrayList<Zamyslenia> parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {


        ArrayList<Zamyslenia> myslienky = null;
        int eventType = parser.getEventType();
        Zamyslenia country = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    myslienky = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("country")){
                        country = new Zamyslenia();
                        country.id=parser.getAttributeValue(null,"id");
                    } else if (country != null){
                        if (name.equals("name")){
                            country.name = parser.nextText();
                        } else if (name.equals("capital")){
                            country.capital = parser.nextText();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("country") && country != null){
                        myslienky.add(country);
                    }
            }
            eventType = parser.next();
        }

        return myslienky;

    }







}
