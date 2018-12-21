package jos.polinema.firebaseapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Fragment extends AppCompatActivity {

    @Override//memanggil method yang sama di parent
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        if (savedInstanceState == null) {
            //inisiasi adapter agar fragment aktif
            FragmentManager fragmentManager = getSupportFragmentManager();

            //pertukaran fragment
            //inisiasi object dari BodyPartFragmnet
            BodyPartFragments bodyFragment;
            //objek baru untuk atas
            bodyFragment = new BodyPartFragments();
            bodyFragment.setmImageIds(ImageAssets.getAtas());
            bodyFragment.setmListIndex(0);
            //transaksi fragment atas
            fragmentManager.beginTransaction().add(R.id.atas_container, bodyFragment).commit();


            //objek baru untuk bawah
            bodyFragment = new BodyPartFragments();
            bodyFragment.setmImageIds(ImageAssets.getBawah());
            bodyFragment.setmListIndex(0);
            //transaksi fragment bawah
            fragmentManager.beginTransaction().add(R.id.bawah_container, bodyFragment).commit();


        }
    }
}