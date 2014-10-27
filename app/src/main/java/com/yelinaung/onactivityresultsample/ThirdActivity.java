package com.yelinaung.onactivityresultsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Ye Lin Aung on 14/10/27.
 */
public class ThirdActivity extends Activity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_third);
    final String data = getIntent().getExtras().getString("to_third");

    findViewById(R.id.third_send_data_to_first).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent i = new Intent(ThirdActivity.this, FirstActivity.class);
        i.putExtra("from_third", "from third : " + data);
        setResult(RESULT_OK, i);
        finish();
      }
    });
  }
}
