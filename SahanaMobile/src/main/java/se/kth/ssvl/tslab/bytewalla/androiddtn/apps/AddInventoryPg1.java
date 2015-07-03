package se.kth.ssvl.tslab.bytewalla.androiddtn.apps;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AddInventoryPg1 extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(se.kth.ssvl.tslab.bytewalla.androiddtn.R.layout.add_inventory1);
        
        Button nextPg = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.btnProceed);
        nextPg.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(AddInventoryPg1.this, AddInventoryPg2.class);
						startActivity(i);
					}
        			
        		});
        
        addCategorySpinner();
    }
	
	  // add items into spinner dynamically
	  public void addCategorySpinner() {
	 
		Spinner categSpinner = (Spinner) findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.categSpinner);
		List<String> list = new ArrayList<String>();
		list.add("Shelter");
		list.add("Food Items");
		list.add("Toys");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categSpinner.setAdapter(dataAdapter);
	  }
}
