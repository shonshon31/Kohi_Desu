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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenu extends AppCompatActivity {

    private RadioGroup szAme, szCapu, szMacchi;
    FirebaseAuth auth;
    RadioButton tallAme, grandeAme, ventiAme, tallCapu, grandeCapu, ventiCapu, tallMacchi, grandeMacchi, ventiMacchi;
    Button button, checkOut, plusAme, minusAme, plusCapu, minusCapu, plusMacchi, minusMacchi;
    TextView textView, quanAme, quanCapu, quanMacchi;

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
        szAme = findViewById(R.id.szAme);
        szCapu = findViewById(R.id.szCapu);
        szMacchi = findViewById(R.id.szMacchi);
        checkOut = findViewById(R.id.btn_checkout);
        plusAme = findViewById(R.id.plusame);
        minusAme = findViewById(R.id.minusame);
        plusCapu = findViewById(R.id.pluscapu);
        minusCapu = findViewById(R.id.minuscapu);
        plusMacchi = findViewById(R.id.plusmacchi);
        minusMacchi = findViewById(R.id.minusmacchi);
        quanAme = findViewById(R.id.quaname);
        quanCapu = findViewById(R.id.quancapu);
        quanMacchi = findViewById(R.id.quanmacchi);

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String combinedOrder = getCombinedSelectedOrder();
                Toast.makeText(MainMenu.this, combinedOrder, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Checkout.class);
                startActivity(intent);
                finish();
            }
        });

        plusAme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusquan_Ame();
            }
        });

        minusAme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusquan_Ame();
            }
        });

        plusCapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusquan_Capu();
            }
        });

        minusCapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusquan_Capu();
            }
        });

        plusMacchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusquan_Macchi();
            }
        });

        minusMacchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusquan_Macchi();
            }
        });

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
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

    private void plusquan_Ame() {
        String currentValue = quanAme.getText().toString();
        int currentNumber = Integer.parseInt(currentValue);
        int newNumber = currentNumber + 1;
        quanAme.setText(String.valueOf(newNumber));
    }

    private void minusquan_Ame() {
        String currentValue = quanAme.getText().toString();
        int currentNumber = Integer.parseInt(currentValue);
        int newNumber = Math.max(currentNumber - 1, 0);
        quanAme.setText(String.valueOf(newNumber));
    }

    private void plusquan_Capu() {
        String currentValue = quanCapu.getText().toString();
        int currentNumber = Integer.parseInt(currentValue);
        int newNumber = currentNumber + 1;
        quanCapu.setText(String.valueOf(newNumber));
    }

    private void minusquan_Capu() {
        String currentValue = quanCapu.getText().toString();
        int currentNumber = Integer.parseInt(currentValue);
        int newNumber = Math.max(currentNumber - 1, 0);
        quanCapu.setText(String.valueOf(newNumber));
    }

    private void plusquan_Macchi() {
        String currentValue = quanMacchi.getText().toString();
        int currentNumber = Integer.parseInt(currentValue);
        int newNumber = currentNumber + 1;
        quanMacchi.setText(String.valueOf(newNumber));
    }

    private void minusquan_Macchi() {
        String currentValue = quanMacchi.getText().toString();
        int currentNumber = Integer.parseInt(currentValue);
        int newNumber = Math.max(currentNumber - 1, 0);
        quanMacchi.setText(String.valueOf(newNumber));
    }

    private String getCombinedSelectedOrder() {
        int selectedId1 = szAme.getCheckedRadioButtonId();
        int selectedId2 = szCapu.getCheckedRadioButtonId();
        int selectedId3 = szMacchi.getCheckedRadioButtonId();

        String selectedValue1 = "";
        String selectedValue2 = "";
        String selectedValue3 = "";

        if (selectedId1 != -1) {
            RadioButton selectedRadioButton1 = findViewById(selectedId1);
            selectedValue1 = selectedRadioButton1.getText().toString();
        }
        if (selectedId2 != -1) {
            RadioButton selectedRadioButton2 = findViewById(selectedId2);
            selectedValue2 = selectedRadioButton2.getText().toString();
        }
        if (selectedId3 != -1) {
            RadioButton selectedRadioButton3 = findViewById(selectedId3);
            selectedValue3 = selectedRadioButton3.getText().toString();
        }

        return "Americano: " + selectedValue1 + ", Cappuccino: " + selectedValue2 + ", Macchiato: " + selectedValue3;
    }
}
