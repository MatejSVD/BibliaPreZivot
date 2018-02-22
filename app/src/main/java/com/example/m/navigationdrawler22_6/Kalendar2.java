package com.example.m.navigationdrawler22_6;


//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

//import android.app.Fragment;

import android.support.v4.app.Fragment;

import java.io.IOException;
import java.io.InputStream;


import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Kalendar2 extends Fragment implements DatePickerDialog.OnDateSetListener {

    public TextView dateTextView;


    //   public Tab2Chat() {
    // Required empty public constructor
    // }


    // @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.kalendar2, container, false);

        // Find our View instances
        dateTextView = (TextView) view.findViewById(R.id.text);
        Button dateButton = (Button) view.findViewById(R.id.date_button);


        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Kalendar2.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );


                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getActivity().getFragmentManager().findFragmentByTag("Datepickerdialog");
        if(dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = +dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        dateTextView.setText(date);


        //  TextView textView;


        // TextView textView = (TextView) .findViewById(R.id.text);

        //textView= (TextView)findViewById(R.id.text);


        //  @Override
        //protected void onCreate(Bundle savedInstanceState) {
        //  super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        XmlPullParserFactory pullParserFactory;

        //http://alvinalexander.com/java/simpledateformat-convert-date-to-string-formatted-parse
        //Date today = Calendar.getInstance().getTime();

        // (2) create a date "formatter" (the date format we want)
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // (3) create a new String using the date format we want
        //String folderName = formatter.format(today);

        // (4) this prints "Folder Name = 2009-09-06"


        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getActivity().getApplicationContext().getAssets().open("sample.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            ArrayList<Zamyslenia> myslienky = parseXML(parser);

            String text = "";


            for (Zamyslenia country : myslienky) {
                //funkcia, ktora zo zoznamu vypise iba data s prislusnym datumom
                //  if(folderName.equals(country.getId()))
                if (date.equals(country.getId())){



                    text += "id : " + country.getId() + " name : " + country.getName() + " capital : " + country.getCapital() + "\n";
                }}
            dateTextView.setText(text);
            //   textView.setText(text);
            // textView = (TextView) dateTextView.findViewById(R.id.text);



        } catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }



    private ArrayList<Zamyslenia> parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {


        ArrayList<Zamyslenia> myslienky = null;
        int eventType = parser.getEventType();
        Zamyslenia country = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name;
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    myslienky = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("country")) {
                        country = new Zamyslenia();
                        country.id = parser.getAttributeValue(null, "id");
                    } else if (country != null) {
                        if (name.equals("name")) {
                            country.name = parser.nextText();
                        } else if (name.equals("capital")) {
                            country.capital = parser.nextText();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("country") && country != null) {
                        myslienky.add(country);
                    }
            }
            eventType = parser.next();
        }

        return myslienky;

    }




}


