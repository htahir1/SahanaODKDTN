package se.kth.ssvl.tslab.bytewalla.androiddtn.apps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ModuleSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(se.kth.ssvl.tslab.bytewalla.androiddtn.R.layout.activity_module_select);
		
		Button loginBtn = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.missingPeopleReg);
        loginBtn.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(ModuleSelect.this, MissingPersons.class);
						startActivity(i);
					}
        			
        		});
        
        Button victimBtn = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.disasterVictimBtn);
        victimBtn.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(ModuleSelect.this, DeadBodyPg1.class);
						startActivity(i);
					}
        			
        		});
        
        Button inventBtn = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.inventoryMgmtBtn);
        inventBtn.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(ModuleSelect.this, AddInventoryPg1.class);
						startActivity(i);
					}
        			
        		});
	}
}
