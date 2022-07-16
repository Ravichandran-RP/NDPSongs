package sg.edu.rp.c346.id20026389.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle,tvSingers,tvYear,tvStars;
    EditText etTtile,etSingers,etYear;
    RadioGroup rgRating;
    RadioButton rating1,rating2,rating3,rating4,rating5;
    Button btnInsert,btnShow;


    @Override
    protected void onResume() {
        super.onResume();
        etTtile.setText("");
        etSingers.setText("");
        etYear.setText("");
        rating1.setChecked(false);
        rating2.setChecked(false);
        rating3.setChecked(false);
        rating4.setChecked(false);
        rating5.setChecked(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle=findViewById(R.id.tvSongTitle);
        tvSingers=findViewById(R.id.tvSingers);
        tvYear=findViewById(R.id.tvYear);
        tvStars=findViewById(R.id.tvStars);
        etTtile=findViewById(R.id.etSongTitle);
        etSingers=findViewById(R.id.etSingers);
        etYear=findViewById(R.id.etYear);
        rgRating=findViewById(R.id.RadioGroupRating);
        rating1=findViewById(R.id.rb1);
        rating2=findViewById(R.id.rb2);
        rating3=findViewById(R.id.rb3);
        rating4=findViewById(R.id.rb4);
        rating5=findViewById(R.id.rb5);
        btnInsert=findViewById(R.id.btnInsert);
        btnShow=findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int stars;
                DBHelper dbh = new DBHelper(MainActivity.this);
                if (etTtile.getText().toString().trim().length()==0 ||
                        etSingers.getText().toString().trim().length()==0 ||
                        etYear.getText().toString().trim().length()==0){
                    Toast.makeText(MainActivity.this, "Please fill up all the fields",
                            Toast.LENGTH_LONG).show();
                }
                else{

                    String songTitle = etTtile.getText().toString().trim();
                    String songSingers = etSingers.getText().toString().trim();
                    int year = Integer.parseInt(etYear.getText().toString().trim());
                    if (rating1.isChecked()){
                        stars=1;
                    }
                    else if (rating2.isChecked()){
                        stars=2;
                    }
                    else if (rating3.isChecked()){
                        stars=3;
                    }
                    else if (rating4.isChecked()){
                        stars=4;
                    }
                    else if (rating5.isChecked()){
                        stars=5;
                    }
                    else {
                        stars=0;
                    }
                    long inserted_id = dbh.insertSong(songTitle,songSingers,year,stars);
                    if (inserted_id != -1) {
//                    al.clear();
//                    al.addAll(dbh.getAllNotes());
//                    aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Insert failed",
                                Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,
                        Showcase.class);
                startActivity(i);

            }
        });





    }
}