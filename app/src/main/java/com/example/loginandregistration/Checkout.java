package com.example.loginandregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class Checkout extends AppCompatActivity {
    ImageButton btn_back;
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String combinedOrder = extras.getString("combinedOrder");
            double totalPrice = extras.getDouble("totalPrice");

            // Displaying data in Checkout activity
            TextView textViewOrderSummary = findViewById(R.id.textView12);

            TextView textViewAmericanoQty = findViewById(R.id.ameQTY);
            TextView textViewCappuccinoQty = findViewById(R.id.cappQTY);
            TextView textViewMacchiatoQty = findViewById(R.id.maccQTY);
            TextView textViewOrderTotal = findViewById(R.id.orderTotal);
            btn_back = (ImageButton)findViewById(R.id.btn_Back);
            order = (Button)findViewById(R.id.btn_Order);

            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Checkout.this, MainMenu.class);
                    startActivity(intent);
                    finish();
                }
            });

            order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Checkout.this, Login.class);
                    Toast.makeText(Checkout.this, "Thank Your for Ordering, your Coffee will be delivered to you shortly.", Toast.LENGTH_SHORT).show();
                }
            });

            textViewOrderSummary.setText(combinedOrder);

            textViewAmericanoQty.setText(String.valueOf(extras.getInt("americanoQty")));
            textViewCappuccinoQty.setText(String.valueOf(extras.getInt("cappuccinoQty")));
            textViewMacchiatoQty.setText(String.valueOf(extras.getInt("macchiatoQty")));
            textViewOrderTotal.setText(String.valueOf(totalPrice));
        }
    }
}