package sg.edu.rp.c346.id22012433.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
EditText inAmt;
EditText inPax;
EditText inDis;
EditText phoneid;
TextView tBill;
TextView perPax;
ToggleButton svsB;
ToggleButton gstB;
RadioButton cash;
RadioButton payN;
Button split;
Button reset;
RadioGroup radioGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inAmt=findViewById(R.id.inAmt);
        inPax=findViewById(R.id.inPax);
        inDis=findViewById(R.id.inDis);
        tBill=findViewById(R.id.tBill);
        perPax=findViewById(R.id.perPay);
        svsB=findViewById(R.id.svsB);
        gstB=findViewById(R.id.gstB);
        cash=findViewById(R.id.cash);
        payN=findViewById(R.id.payN);
        split=findViewById(R.id.split);
        reset= findViewById(R.id.reset);
        radioGroup = findViewById(R.id.radioGroup);
        phoneid=findViewById(R.id.phoneId);
        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inAmt.getText().toString().trim().length() != 0 && inPax.getText().toString().trim().length() != 0){
                    double oriAmt = Double.parseDouble(inAmt.getText().toString());
                   double newInAmt = 0.0;
                    if (!svsB.isChecked() && !gstB.isChecked()) {
                        newInAmt = oriAmt;
                    } else if (svsB.isChecked() && !gstB.isChecked()) {
                        newInAmt = oriAmt * 1.1;
                    } else if (svsB.isChecked() && !gstB.isChecked()) {
                        newInAmt = oriAmt * 1.07;
                    } else {
                        newInAmt = oriAmt * 1.17;
                    }
                    if (inDis.getText().toString().trim().length() != 0) {
                        newInAmt *= 1 - Double.parseDouble(inDis.getText().toString()) / 100;
                    }
                    String way = " in cash";
                    if (radioGroup.getCheckedRadioButtonId() == R.id.payN) {
                        way = " via PayNow to ";
                    }
                    tBill.setText("Total Bill: $" + String.format("%.2f", newInAmt));
                    int numP = Integer.parseInt(inPax.getText().toString());
                    if (numP != 1)
                        perPax.setText("Each Pays: $" + String.format("%.2f", newInAmt / numP) + way);
                    else
                        perPax.setText("Each Pays: $" + newInAmt + phoneid);
                }
            }
        });

    }

    }

