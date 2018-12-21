package jos.polinema.firebaseapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;



public class BodyPartFragments extends Fragment {
    //variabel TAG
    public static final String IMAGE_ID_LIST="image_ids";
    public static final String LIST_INDEX="list_index";
    public static final String TAG = "BodyPartFragment";
    private List<Integer> mImageIds;
    private Integer mListIndex;
    //konstraktor
    public BodyPartFragments(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //inisiasi activity sebagai fragments
        View rootView = inflater.inflate(R.layout.activity_body_part_fragments, container, false);
        //mengambil id yang ada di layout fragment
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView_pakaian_layout_fragment);
        //ambil gambar
        if(mImageIds !=null){

            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                //merubah index gambar
                public void onClick(View view) {
                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    //mendapat gambar dari mImageIds pada index
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }else
        {
            //output ketika tidak ada gambar
            Log.v(TAG,"this fragment has a null list of image id");
        }
        return rootView;
    }
    //setter untuk memberi nilai untuk atribut mImageIds
    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }
    //setter untuk memberi nilai untuk mListIndex
    public void setmListIndex(Integer mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    //menyimoan variabel array beserta index
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mImageIds);
        currentState.putInt(LIST_INDEX,mListIndex);
    }
}
