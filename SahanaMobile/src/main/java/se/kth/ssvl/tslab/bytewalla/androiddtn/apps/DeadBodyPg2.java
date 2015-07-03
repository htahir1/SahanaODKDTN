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

public class DeadBodyPg2 extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(se.kth.ssvl.tslab.bytewalla.androiddtn.R.layout.add_dead_body2);
        
        addcountrySpinner();
        
        Button cancelBtn = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.cancelBtn);
        cancelBtn.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(DeadBodyPg2.this, ModuleSelect.class);
						startActivity(i);
					}
        			
        		});
	}
	
	  public void addcountrySpinner() 
	  {
		Spinner countrySpinner = (Spinner) findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.countrySpinner);
		List<String> clist = new ArrayList<String>();
		
		clist.add("Afghanistan");
		clist.add("Albania");
		clist.add("Algeria");
		clist.add("Andorra");
		clist.add("Angola");
		clist.add("Antigua and Barbuda");
		clist.add("Argentina");
		clist.add("Armenia");
		clist.add("Australia");
		clist.add("Austria");
		clist.add("Azerbaijan");

		ArrayAdapter<String> cdataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, clist);
		cdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		countrySpinner.setAdapter(cdataAdapter);
		 
	  }
}