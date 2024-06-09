package com.example.loginandregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenu extends AppCompatActivity {

    FirebaseAuth auth;
    RadioButton tallAme, grandeAme, ventiAme, tallCapu, grandeCapu, ventiCapu, tallMacchi, grandeMacchi, ventiMacchi;
    Button button, checkOut, plusAme, minusAme, plusCapu, minusCapu, plusMacchi, minusMacchi;
    TextView textView;
    String selectedCoffee;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        tallAme = (RadioButton)findViewById(R.id.tallAme);
        grandeAme = (RadioButton)findViewById(R.id.grandeAme);
        ventiAme = (RadioButton)findViewById(R.id.ventiAme);
        tallCapu = (RadioButton)findViewById(R.id.tallAme);
        grandeCapu = (RadioButton)findViewById(R.id.grandeAme);
        ventiCapu = (RadioButton)findViewById(R.id.ventiAme);
        tallMacchi = (RadioButton)findViewById(R.id.tallAme);
        grandeMacchi = (RadioButton)findViewById(R.id.grandeAme);
        ventiMacchi = (RadioButton)findViewById(R.id.ventiAme);
        checkOut = findViewById(R.id.btn_checkout);
        plusAme = findViewById(R.id.plusame);
        minusAme = findViewById(R.id.minusame);
        plusCapu = findViewById(R.id.pluscapu);
        minusCapu = findViewById(R.id.minuscapu);
        plusMacchi = findViewById(R.id.plusmacchi);
        minusMacchi = findViewById(R.id.minusmacchi);
      

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tallAme.isChecked()) {
                    selectedCoffee = tallAme.getText().toString();
                } else if (grandeAme.isChecked()) {
                    selectedCoffee = grandeAme.getText().toString();
                } else if (ventiAme.isChecked()) {
                    selectedCoffee = ventiAme.getText().toString();
                } else if (tallCapu.isChecked()) {
                    selectedCoffee = tallCapu.getText().toString();
                } else if (grandeCapu.isChecked()) {
                    selectedCoffee = grandeCapu.getText().toString();
                }
                  else if (ventiCapu.isChecked()){
                    selectedCoffee = ventiCapu.getText().toString();
                }
                else if (tallMacchi.isChecked()){
                    selectedCoffee = tallMacchi.getText().toString();
                }
                else if (grandeMacchi.isChecked()){
                    selectedCoffee = grandeMacchi.getText().toString();
                }
                else if (ventiMacchi.isChecked()){
                    selectedCoffee = ventiMacchi.getText().toString();
                }
                Toast.makeText(getApplicationContext(), selectedCoffee, Toast.LENGTH_LONG).show();
            }
        });



        plusAme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quanAme;
                quanAme++;
            }
        });

        minusAme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quanAme;
                quanAme--;
            }
        });
        plusCapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quanCapu++;
            }
        });

        minusCapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quanCapu--;
            }
        });

        plusMacchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quanMacchi++;
            }
        });

        minusMacchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quanMacchi --;
            }
        });



        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}