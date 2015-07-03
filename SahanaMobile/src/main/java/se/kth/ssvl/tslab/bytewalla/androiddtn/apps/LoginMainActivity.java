package se.kth.ssvl.tslab.bytewalla.androiddtn.apps;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class LoginMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(se.kth.ssvl.tslab.bytewalla.androiddtn.R.layout.login);
        
        Button newUsr = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.btnNewUsr);
        newUsr.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(LoginMainActivity.this, UserRegistration.class);
						startActivity(i);
					}
        			
        		});
        Button loginBtn = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.btnLogin);
        loginBtn.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(LoginMainActivity.this, ModuleSelect.class);
						startActivity(i);
					}
        			
        		});
    }
}
