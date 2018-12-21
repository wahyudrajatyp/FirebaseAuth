package jos.polinema.firebaseapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


    public class MainActivity extends AppCompatActivity {
        private FirebaseAuth mAuth;
        Button btnLogout;
        private GoogleSignInClient mGoogleSignInClient;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button btnApi = (Button) findViewById(R.id.api);
            Button btnfragment = (Button) findViewById(R.id.fragment);

           btnApi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i1 = new Intent(MainActivity.this, CameraApi.class);
                   startActivity(i1);
               }
           });
            btnfragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i2 = new Intent(MainActivity.this, Fragment.class);
                    startActivity(i2);
                }
            });


        }







                }