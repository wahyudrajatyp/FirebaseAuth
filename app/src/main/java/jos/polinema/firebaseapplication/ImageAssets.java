package jos.polinema.firebaseapplication;

import java.util.ArrayList;
import java.util.List;

public class ImageAssets {


    //private tidak dapat di akses oleh semua class
    //public dapat di akses oleh semua class
    //protected
    //static sifat yang menempel pada class itu sendiri
    //variable ini untuk menyimpan pengelompokan gambar head
    private static List<Integer> atas = new ArrayList<Integer>(){{
        add(R.drawable.atas1);
        add(R.drawable.atas2);
        add(R.drawable.atas3);
        add(R.drawable.atas4);
        add(R.drawable.atas5);
        add(R.drawable.atas6);
        add(R.drawable.atas7);
        add(R.drawable.atas8);
        add(R.drawable.atas9);

    }};
    //variable ini untuk menyimpan pengelompokan gambar bodies
    private static List<Integer> bawah = new ArrayList<Integer>(){{
        add(R.drawable.bawah1);
        add(R.drawable.bawah2);
        add(R.drawable.bawah3);
        add(R.drawable.bawah4);
        add(R.drawable.bawah5);
        add(R.drawable.bawah6);
        add(R.drawable.bawah7);
        add(R.drawable.bawah8);

    }};

    //ini adalah method yang digunakan untuk memanggil/mengambil variable atas
    public static List<Integer> getAtas()
    {
        return atas;
    }
    //ini adalah method yang digunakan untuk memanggil/mengambil variable bawah
    public static List<Integer> getBawah()
    {
        return bawah;
    }

}

