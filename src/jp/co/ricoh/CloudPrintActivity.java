package jp.co.ricoh;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CloudPrintActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button) findViewById(R.id.button);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                	Intent printIntent = new Intent(CloudPrintActivity.this, PrintDialogActivity.class);
                    EditText editText = (EditText) findViewById(R.id.editText1);
                	String uriToPrint = editText.getText().toString();
                	printIntent.setDataAndType(Uri.parse(uriToPrint), "url");
                	printIntent.putExtra("title", "MyCloudPrint");
                	startActivity(printIntent);
                } catch (ActivityNotFoundException e) {
                    // このインテントに応答できるアクティビティがインストールされていない場合
                    Toast.makeText(CloudPrintActivity.this,
                        "ActivityNotFoundException", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}