package se.kth.ssvl.tslab.bytewalla.androiddtn.apps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddInventoryPg2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(se.kth.ssvl.tslab.bytewalla.androiddtn.R.layout.add_inventory2);
		
        Button cancelBtn = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.cancelButton);
        cancelBtn.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(AddInventoryPg2.this, ModuleSelect.class);
						startActivity(i);
					}
        			
        		});

	}

}
