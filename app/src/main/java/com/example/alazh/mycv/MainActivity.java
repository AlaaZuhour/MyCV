package com.example.alazh.mycv;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import static android.R.attr.name;
import static android.R.attr.top;

public class MainActivity extends Activity {
    ArrayList<Edu> eduate =new ArrayList<>();
    ArrayList<Train> train=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button eduPlus=(Button) findViewById(R.id.eduPlus);
        Button trainPlus=(Button) findViewById(R.id.trainPlus);

        eduPlus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Spinner deg= (Spinner) findViewById(R.id.eduDeg);
                Spinner yea= (Spinner) findViewById(R.id.year1);
                EditText spec= (EditText) findViewById(R.id.specialty);
                EditText instit= (EditText) findViewById(R.id.instit);
                eduate.add(new Edu(yea.getSelectedItem().toString(),instit.getText().toString(),
                        spec.getText().toString(),deg.getSelectedItem().toString()));
                spec.setText(null);
                yea.setSelected(false);
                instit.setText(null);
                deg.setSelected(false);
            }
        });
       trainPlus.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View v) {
               EditText top= (EditText) findViewById(R.id.topic);
               EditText hor= (EditText) findViewById(R.id.hours);
               EditText comp= (EditText) findViewById(R.id.company);
               EditText dur= (EditText) findViewById(R.id.duration);
               train.add(new Train(hor.getText().toString(),top.getText().toString(),comp.getText().toString(),
                       dur.getText().toString()));
               dur.setText(null);
               top.setText(null);
               hor.setText(null);
               comp.setText(null);
           }
       });
    }
    public void onClick(View view){
        Intent i =new Intent(MainActivity.this,MYCV.class);
        EditText name1= (EditText) findViewById(R.id.name);
        EditText phone= (EditText) findViewById(R.id.phone);
        EditText email= (EditText) findViewById(R.id.email);
        i.putExtra("phone",phone.getText().toString());
        i.putExtra("email",email.getText().toString());
        i.putExtra("name",name1.getText().toString());
        Spinner deg= (Spinner) findViewById(R.id.eduDeg);
        Spinner yea= (Spinner) findViewById(R.id.year1);
        EditText spec= (EditText) findViewById(R.id.specialty);
        EditText instit= (EditText) findViewById(R.id.instit);
        eduate.add(new Edu(yea.getSelectedItem().toString(),instit.getText().toString(),
                spec.getText().toString(),deg.getSelectedItem().toString()));
        EditText top= (EditText) findViewById(R.id.topic);
        EditText hor= (EditText) findViewById(R.id.hours);
        EditText comp= (EditText) findViewById(R.id.company);
        EditText dur= (EditText) findViewById(R.id.duration);
        train.add(new Train(hor.getText().toString(),top.getText().toString(),comp.getText().toString(),
                dur.getText().toString()));
       // Bundle args = new Bundle();
       // args.putSerializable("education",(Serializable)eduate);
       i.putParcelableArrayListExtra("education",eduate);
        i.putParcelableArrayListExtra("training",train);
       // args.putSerializable("traning",(Serializable)train);
       // i.putExtra("BUNDLE1",args);
        startActivity(i);

    }
    static class Edu implements Parcelable {
        String year;
        String instituation;
        String speciality;
        String degree;
        public Edu(String year, String instituation,String speciality,String degree){
            this.degree=degree;
            this.instituation=instituation;
            this.speciality=speciality;
            this.year=year;
        }

        protected Edu(Parcel in) {
            year = in.readString();
            instituation = in.readString();
            speciality = in.readString();
            degree = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(year);
            dest.writeString(instituation);
            dest.writeString(speciality);
            dest.writeString(degree);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Edu> CREATOR = new Creator<Edu>() {
            @Override
            public Edu createFromParcel(Parcel in) {
                return new Edu(in);
            }

            @Override
            public Edu[] newArray(int size) {
                return new Edu[size];
            }
        };
    }
    static class Train implements Parcelable{
        String hor;
        String top;
        String comp;
        String dura;
        public Train(String hor, String top,String comp,String dura){
            this.hor=hor;
            this.comp=comp;
            this.dura=dura;
            this.top=top;
        }

        protected Train(Parcel in) {
            hor = in.readString();
            top = in.readString();
            comp = in.readString();
            dura = in.readString();
        }

        public static final Creator<Train> CREATOR = new Creator<Train>() {
            @Override
            public Train createFromParcel(Parcel in) {
                return new Train(in);
            }

            @Override
            public Train[] newArray(int size) {
                return new Train[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(hor);
            dest.writeString(top);
            dest.writeString(comp);
            dest.writeString(dura);
        }
    }
}
