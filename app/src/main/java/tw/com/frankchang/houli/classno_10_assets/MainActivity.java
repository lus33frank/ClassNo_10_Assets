package tw.com.frankchang.houli.classno_10_assets;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView imgShow;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviewer();
    }

    private void findviewer(){
        imgShow = (ImageView) findViewById(R.id.imageView);
        tvShow = (TextView) findViewById(R.id.textView);
    }

    public void imgOnClick(View v){
        try {
            InputStream is = getAssets().open("Cat_Egg.jpg");
            Bitmap jpg_bitmap = BitmapFactory.decodeStream(is);
            imgShow.setImageBitmap(jpg_bitmap);
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void txtOnClick(View v){
        try {
            InputStream is = getAssets().open("TNR.txt");
            byte[] txt_byte = new byte[is.available()];
            is.read(txt_byte);
            is.close();
            tvShow.setText(new String(txt_byte, "big5"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

