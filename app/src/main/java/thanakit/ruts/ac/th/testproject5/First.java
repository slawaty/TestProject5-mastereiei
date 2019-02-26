package thanakit.ruts.ac.th.testproject5;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class First extends AppCompatActivity {
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference LED1, LED2,LED3, LED4, REfer,REfer1, REfer2;

    public Button Switch_1, Switch_2, Switch_3,Switch_4;
    public Integer Valuel, Valuel01, Valuel02, Valuel03, Valuel04;
    public String date;
    public TextView textname,textview1, textview2, textview3, textview4,texttem, texthum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //เรียก datebase ให้ตรงกับที่อยุ่ firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        LED1 = firebaseDatabase.getReference("LED1");
        LED2 = firebaseDatabase.getReference("LED2");
        LED3 = firebaseDatabase.getReference("LED3");
        LED4 = firebaseDatabase.getReference("LED4");

        REfer = firebaseDatabase.getReference();
        REfer1 = firebaseDatabase.getReference();
        REfer2 = firebaseDatabase.getReference();


        textname = findViewById(R.id.txtname);
        textview1 = findViewById(R.id.txtview1);
        textview2 = findViewById(R.id.txtview2);
        textview3 = findViewById(R.id.txtview3);
        textview4 = findViewById(R.id.txtview4);
        texttem = findViewById(R.id.txttem);
        texthum = findViewById(R.id.txthum);


        REfer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                date = String.valueOf(map.get("Name"));
                textname.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        REfer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                date = String.valueOf(map.get("LED1"));
                textview1.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        REfer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                date = String.valueOf(map.get("LED2"));
                textview2.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        REfer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                date = String.valueOf(map.get("LED3"));
                textview3.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        REfer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                date = String.valueOf(map.get("LED4"));
                textview4.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        REfer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                date = String.valueOf(map.get("Humidity"));
                texthum.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        REfer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                date = String.valueOf(map.get("Tempurater"));
                texttem.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Switch_1 = (Button) findViewById(R.id.btn1);

        LED1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Valuel = dataSnapshot.getValue(Integer.class);
                if (Valuel==1){
                    Switch_1.setText("LED1_NO");
                    Valuel01=0;
                }else {
                    Switch_1.setText("LED1_OFF");
                    Valuel01 = 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LED1.setValue(Valuel01);
            }
        });//เสร็จสิ้นปุ่ม ฺ butLED1

        Switch_2 = (Button) findViewById(R.id.btn2);
        LED2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Valuel = dataSnapshot.getValue(Integer.class);
                if (Valuel==1){
                    Switch_2.setText("LED2_NO");
                    Valuel02=0;
                }else {
                    Switch_2.setText("LED2_OFF");
                    Valuel02= 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LED2.setValue(Valuel02);
            }
        });//เสร็จสิ้นปุ่ม ฺ butLED2

        Switch_3 = (Button) findViewById(R.id.btn3);
        LED3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Valuel = dataSnapshot.getValue(Integer.class);
                if (Valuel==1){
                    Switch_3.setText("LED3_NO");
                    Valuel03=0;
                }else {
                    Switch_3.setText("LED3_OFF");
                    Valuel03 = 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LED3.setValue(Valuel03);
            }
        });//เสร็จสิ้นปุ่ม ฺ butLED1

        Switch_4 = (Button) findViewById(R.id.btn4);
        LED4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Valuel = dataSnapshot.getValue(Integer.class);
                if (Valuel==1){
                    Switch_4.setText("LED4_NO");
                    Valuel04=0;
                }else {
                    Switch_4.setText("LED4_OFF");
                    Valuel04 = 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Switch_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LED4.setValue(Valuel04);
            }
        });//เสร็จสิ้นปุ่ม ฺ butLED4

    }



}