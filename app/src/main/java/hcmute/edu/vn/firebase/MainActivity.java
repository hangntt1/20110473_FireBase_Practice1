package hcmute.edu.vn.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtname, txtage, txtphone, txtheight;
    Button btnsave;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = findViewById(R.id.txtname);
        txtage = findViewById(R.id.txtage);
        txtphone = findViewById(R.id.txtphone);
        txtheight = findViewById(R.id.txtheight);
        btnsave = findViewById(R.id.btnsave);

        Member member = new Member();

        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(txtage.getText().toString().trim());
                Float hit = Float.parseFloat((txtheight.getText().toString().trim()));
                Long phn = Long.getLong(txtphone.getText().toString().trim());
                member.setName(txtname.getText().toString().trim());
                member.setAge(age);
                member.setHt(hit);
                member.setPh(phn);
                reff.child("member!").setValue(member);
                Toast.makeText(MainActivity.this, "data insert successfully", Toast.LENGTH_LONG).show();
            }
        });

    }
}