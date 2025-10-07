package com.example.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Header
    private Button profileButton;

    // Patient card
    private ImageView patientPhoto;
    private TextView patientName, patientAge, patientId, emergencyStatus, lastVisit;

    // Vital signs
    private TextView heartRateValue, heartRateLabel;
    private TextView bpValue, bpLabel;
    private TextView tempValue, tempLabel;

    // Quick actions
    private Button medicalRecordButton, prescriptionButton, labResultsButton;
    private Button emergencyButton, appointmentButton;

    // Alerts
    private Button viewDetailsButton;

    // Bottom nav
    private Button navHome, navPatients, navCalendar, navSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // your existing XML

        bindViews();
        setupQuickActions();
        setupBottomNav();
        populateInitialData();
    }

    private void bindViews() {
        profileButton = findViewById(R.id.profileButton);

        patientPhoto = findViewById(R.id.patientPhoto);
        patientName  = findViewById(R.id.patientName);
        patientAge   = findViewById(R.id.patientAge);
        patientId    = findViewById(R.id.patientId);
        emergencyStatus = findViewById(R.id.emergencyStatus);
        lastVisit    = findViewById(R.id.lastVisit);

        heartRateValue = findViewById(R.id.heartRateValue);
        heartRateLabel = findViewById(R.id.heartRateLabel);
        bpValue        = findViewById(R.id.bpValue);
        bpLabel        = findViewById(R.id.bpLabel);
        tempValue      = findViewById(R.id.tempValue);
        tempLabel      = findViewById(R.id.tempLabel);

        medicalRecordButton = findViewById(R.id.medicalRecordButton);
        prescriptionButton  = findViewById(R.id.prescriptionButton);
        labResultsButton    = findViewById(R.id.labResultsButton);
        emergencyButton     = findViewById(R.id.emergencyButton);
        appointmentButton   = findViewById(R.id.appointmentButton);

        viewDetailsButton = findViewById(R.id.viewDetailsButton);

        navHome     = findViewById(R.id.navHome);
        navPatients = findViewById(R.id.navPatients);
        navCalendar = findViewById(R.id.navCalendar);
        navSettings = findViewById(R.id.navSettings);
    }



    private void setupQuickActions() {
        // Open our second activity as an example
        medicalRecordButton.setOnClickListener(v ->
                startActivity(new Intent(this, PatientDetailsActivity.class))
        );

        emergencyButton.setOnClickListener(v -> {
            // Opens dialer (no CALL permission needed)
            Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:198"));
            startActivity(dial);
        });
    }


    private void setupBottomNav() {
        View.OnClickListener nav = v -> {
            int id = v.getId();
            if (id == R.id.navHome) {
                Toast.makeText(this, "Accueil", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.navPatients) {
                startActivity(new Intent(this, PatientDetailsActivity.class));
            }
        };
        navHome.setOnClickListener(nav);
        navPatients.setOnClickListener(nav);
    }

    private void populateInitialData() {
        patientName.setText("Selima");
        patientAge.setText("30 ans");
        patientId.setText("ID: PAT-7842");
        lastVisit.setText("15 Nov 2024");

        heartRateValue.setText("72");
        heartRateLabel.setText("BPM");
        bpValue.setText("120/80");
        bpLabel.setText("mmHg");
        tempValue.setText("36.8");
        tempLabel.setText("°C");
    }

}
