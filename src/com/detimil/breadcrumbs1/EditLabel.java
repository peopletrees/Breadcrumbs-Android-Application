package com.detimil.breadcrumbs1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditLabel extends Activity {
	

	
	private DatabaseHandler db;
	private int breadcrumbId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_label);
		db = new DatabaseHandler(this);
		
		Bundle extras = getIntent().getExtras();
		breadcrumbId = extras.getInt("breadcrumbId");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_label, menu);
		return true;
	}
	
	
    public void setBreadcrumbLabel(View view) {
    	// Store breadcrumb label in the database
    	EditText editText = (EditText) findViewById(R.id.breadcrumbLabelEditText);
    	String breadcrumbLabel = editText.getEditableText().toString();
    	db.relabelBreadcrumb(breadcrumbId, breadcrumbLabel);
    	
   	    Intent intent = new Intent(this, BreadcrumbMap.class);
   	    startActivity(intent);
    }
    
    public void cancel(View view) {
    	Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);    
    }

}
