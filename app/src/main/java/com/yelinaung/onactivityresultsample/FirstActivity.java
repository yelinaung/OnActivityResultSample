package com.yelinaung.onactivityresultsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);

    findViewById(R.id.send_data_btn).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent i = new Intent(FirstActivity.this, SecondActivity.class);
        i.putExtra("data", "meow");
        startActivityForResult(i, 1);
      }
    });
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (data.getExtras().containsKey("from_second")) {
      if (resultCode == RESULT_OK) {
        Toast.makeText(FirstActivity.this, data.getStringExtra("from_second"), Toast.LENGTH_SHORT)
            .show();
      }
    }

    if (data.getExtras().containsKey("from_third")) {
      if (resultCode == RESULT_OK) {
        Toast.makeText(FirstActivity.this, data.getStringExtra("from_third"), Toast.LENGTH_SHORT)
            .show();

        Log.i("from third", "from third " + data.getStringExtra("from_third"));
      }
    }
  }
}
