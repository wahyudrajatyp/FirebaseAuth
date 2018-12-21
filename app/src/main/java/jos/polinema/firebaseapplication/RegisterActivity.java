package jos.polinema.firebaseapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;
    private String TAG = "register";
    //EditText email, password;
    //String sEmail, sPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText password = ((EditText) findViewById(R.id.password));
        final EditText email = ((EditText) findViewById(R.id.email));

        //membuat variable untuk menghubungkan edittext dan button yang ada di layout
//        final String email = ((EditText) findViewById(R.id.email)).toString();
//        final String password = ((EditText) findViewById(R.id.password)).toString();
        Button btnregister = (Button) findViewById(R.id.btnregister);

        mAuth = FirebaseAuth.getInstance();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick" + email.getText().toString() + " - " + password.getText().toString());
                register(email.getText().toString(), password.getText().toString());
            }
        });
    }
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null){
//                    Log.d(TAG, "onAuthStateChanged signed_in :" + user.getUid());
//                }
//                else
//                {
//                    Log.d(TAG, "onAuthStateChanged signed_out");
//                }
//            }
//        };

//        btnregister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sPassword = password.getText().toString();
//                sEmail = email.getText().toString();
//                register(sEmail,sPassword);
//            }
//        });
//    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
       FirebaseUser currentUser = mAuth.getCurrentUser();
       updateUI(currentUser);
        //mAuth.addAuthStateListener(mAuthListener);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    private void register(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(RegisterActivity.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                           FirebaseUser user = mAuth.getCurrentUser();
                           updateUI(user);
                            //Toast.makeText(RegisterActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                           // Toast.makeText(RegisterActivity.this, "Success",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
