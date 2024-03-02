package com.example.aplikasi3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText namaEditText, jumlahSepatuEditText1, jumlahSepatuEditText2, jumlahSepatuEditText3;
    private RadioGroup radioGroup;
    private RadioButton rbGold, rbSilver, rbReguler;
    private Button bayarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaEditText = findViewById(R.id.Nama);
        jumlahSepatuEditText1 = findViewById(R.id.Nol1);
        jumlahSepatuEditText2 = findViewById(R.id.Nol2);
        jumlahSepatuEditText3 = findViewById(R.id.Nol3);

        radioGroup = findViewById(R.id.RadioGroup);
        rbGold = findViewById(R.id.rbGold);
        rbSilver = findViewById(R.id.rbSilver);
        rbReguler = findViewById(R.id.rbReguler);

        bayarButton = findViewById(R.id.Bayar);
        bayarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungTotalHarga();
            }
        });
    }

    private void hitungTotalHarga() {
        // Mendapatkan input dari pengguna
        String namaPembeli = namaEditText.getText().toString();
        int jumlahSepatu1 = Integer.parseInt(jumlahSepatuEditText1.getText().toString());
        int jumlahSepatu2 = Integer.parseInt(jumlahSepatuEditText2.getText().toString());
        int jumlahSepatu3 = Integer.parseInt(jumlahSepatuEditText3.getText().toString());

        int totalHarga = (250000 * jumlahSepatu1) + (250000 * jumlahSepatu2) + (250000 * jumlahSepatu3);

        // Mendapatkan pilihan membership
        int selectedId = radioGroup.getCheckedRadioButtonId();
        int potonganMembership = 0;

        if (selectedId == rbGold.getId()) {
            potonganMembership = 20000;
        } else if (selectedId == rbSilver.getId()) {
            potonganMembership = 15000;
        } else if (selectedId == rbReguler.getId()) {
            potonganMembership = 10000;
        }

        // Potongan tambahan jika pembelian lebih dari 10 juta
        if (totalHarga > 10000000) {
            potonganMembership += 0.1 * totalHarga;
        }

        // Menghitung total harga setelah potongan
        int totalHargaSetelahPotongan = totalHarga - potonganMembership;

        // Menampilkan hasil
        String hasil = "Nama Pembeli: " + namaPembeli + "\nTotal Harga: Rp " + totalHarga +
                "\nPotongan Membership: Rp " + potonganMembership +
                "\nTotal Harga Setelah Potongan: Rp " + totalHargaSetelahPotongan;

        Toast.makeText(this, hasil, Toast.LENGTH_LONG).show();
    }
}
