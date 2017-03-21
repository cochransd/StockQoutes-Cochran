package steve_cochran.stockqoutes_cochran;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Thread.sleep;
import static steve_cochran.stockqoutes_cochran.R.id.editText;

public class MainActivity extends AppCompatActivity {


    public android.view.View tv;
    public TextView txt15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        tv = findViewById( R.id.textView15);
        txt15 = (TextView)findViewById(R.id.textView15);


        TextView txt15 = (TextView) findViewById(R.id.textView15);

        EditText editText = (EditText) findViewById(R.id.editText);

        Thread thread = new Thread(){

            @Override

            public void run() {

                try {
                    while(true) {
                        sleep(1000);
                        TextView txt = (TextView) findViewById(R.id.editText);

                        TextView txt15 = (TextView) findViewById(R.id.textView15);

                        String line = txt.getText().toString();
                        Stock stock = new Stock(line);

                        System.out.println(line);

                        if(stock.getSymbol() != null){
                            System.out.println("FA");

                            update(tv, txt15, stock);
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };



        thread.start();}


    public void update(View v, TextView txt15, Stock stock) {

        txt15.setText(stock.getName().toString());


        Log.d("VIVZ", txt15.toString());

    }
}






    /**
     * Created by Steve Cochran PC on 3/21/2017.
     */



