package com.yelinaung.onactivityresultsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by Ye Lin Aung on 14/10/27.
 */
public class SecondActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    final String data = getIntent().getExtras().getString("data");

    findViewById(R.id.second_send_data_to_first_btn).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent i = new Intent(SecondActivity.this, FirstActivity.class);
        i.putExtra("from_second", "from second : " + data);
        setResult(RESULT_OK, i);
        finish();
      }
    });

    findViewById(R.id.second_send_data_to_third_btn).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
        i.putExtra("to_third", data);
        startActivityForResult(i, 1);
      }
    });
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (data.getExtras().containsKey("from_third")) {
      if (resultCode == RESULT_OK) {
        Log.i("from third", "from third " + data.getStringExtra("from_third"));
        Intent i = new Intent(SecondActivity.this, FirstActivity.class);
        i.putExtra("from_third", "from third : " + data.getStringExtra("from_third"));
        setResult(RESULT_OK, i);
        finish();
      }
    }
  }
}
