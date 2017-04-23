package steve_cochran.stockqoutes_cochran;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    EditText stockInput;
    TextView output1;
    TextView output2;
    TextView output3;
    TextView output4;
    TextView output5;
    TextView output6;
    String strSTOCK;
    Stock stockData;
    getStockInfo aTask;
    Context ACTIVITY_CONTEXT;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stockInput = (EditText) findViewById(R.id.editText);
        Button getStock = (Button) findViewById(R.id.button);
        output1 = (TextView) findViewById(R.id.output1);
        output2 = (TextView) findViewById(R.id.output2);
        output3 = (TextView) findViewById(R.id.output3);
        output4 = (TextView) findViewById(R.id.output4);
        output5 = (TextView) findViewById(R.id.output5);
        output6 = (TextView) findViewById(R.id.output6);

        ACTIVITY_CONTEXT = this;

        System.out.println("Ok0");


        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        getStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strSTOCK = stockInput.getText().toString();

                System.out.println("Ok1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                aTask = new getStockInfo();
                aTask.execute((Void) null);

                System.out.println("Ok2");

            }
        });

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    }

    //00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

    private class getStockInfo extends AsyncTask<Void, Void, Boolean> {
        protected Boolean doInBackground(Void... params) {
            stockData = new Stock(strSTOCK);
            try {stockData.load();} catch (IOException | IndexOutOfBoundsException e) { e.printStackTrace();}
            return true;


        }

        //Handles everything after the Async task has completed
        protected void onPostExecute(Boolean value) {
            aTask = null;

            System.out.println(stockData.getName());
            System.out.println(stockData.getLastTradePrice());
            System.out.println(stockData.getLastTradeTime());
            System.out.println(stockData.getChange());
            System.out.println(stockData.getName());


            output1.setText(stockData.getSymbol());
            output2.setText(stockData.getName());
            output3.setText(stockData.getLastTradePrice());
            output4.setText(stockData.getLastTradeTime());
            output5.setText(stockData.getChange());
            output6.setText(stockData.getRange());

        }

        @Override
        protected void onCancelled() {
            aTask = null;
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("output1", output1.getText().toString());
        savedInstanceState.putString("output2", output2.getText().toString());
        savedInstanceState.putString("output3", output3.getText().toString());
        savedInstanceState.putString("output4", output4.getText().toString());
        savedInstanceState.putString("output5", output5.getText().toString());
        savedInstanceState.putString("output6", output6.getText().toString());

    }



}





    /**
     * Created by Steve Cochran PC on 3/21/2017.
     */



