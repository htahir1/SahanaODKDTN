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

public class DeadBodyPg1 extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(se.kth.ssvl.tslab.bytewalla.androiddtn.R.layout.add_dead_body1);
        
        
        Button nextPg = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.btnproceed);
        nextPg.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(DeadBodyPg1.this, DeadBodyPg2.class);
						startActivity(i);
					}
        		});
        addGenderAgeSpinner();
    }
	
	  public void addGenderAgeSpinner() 
	  {
			 
		Spinner genderSpinner = (Spinner) findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.SpinnerGender);
		List<String> glist = new ArrayList<String>();
		glist.add("Male");
		glist.add("Female");
		ArrayAdapter<String> gdataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, glist);
		gdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		genderSpinner.setAdapter(gdataAdapter);
		 
		Spinner ageSpinner = (Spinner) findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.SpinnerAge);
		List<String> alist = new ArrayList<String>();
		alist.add("21 and Under");
		alist.add("22-34");
		alist.add("35-44");
		alist.add("45-54");
		alist.add("55-64");
		ArrayAdapter<String> adataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, alist);
		adataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		ageSpinner.setAdapter(adataAdapter);
		
	  }
}
