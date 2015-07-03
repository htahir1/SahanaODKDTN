package se.kth.ssvl.tslab.bytewalla.androiddtn.apps;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import se.kth.ssvl.tslab.bytewalla.androiddtn.DTNService;
import se.kth.ssvl.tslab.bytewalla.androiddtn.R;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.DTNAPIBinder;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.DTNAPICode.dtn_api_status_report_code;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.DTNAPICode.dtn_bundle_payload_location_t;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.DTNAPICode.dtn_bundle_priority_t;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.types.DTNBundleID;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.types.DTNBundlePayload;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.types.DTNBundleSpec;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.types.DTNEndpointID;
import se.kth.ssvl.tslab.bytewalla.androiddtn.applib.types.DTNHandle;
import se.kth.ssvl.tslab.bytewalla.androiddtn.servlib.bundling.BundleDaemon;
public class MissingPersons extends Activity {

	/**
	 * Logging TAG for supporting Android logging mechanism
	 */
	private static String TAG = "MissingPersons";
	
	/**
	 * SendButton reference object
	 */
	private Button sendButton;
	
	/**
	 * CloseButton reference object
	 */
	private Button cancelButton;
	
	/**
	 * Destination EndpointID reference object
	 */
	private EditText DestEIDEditText;
	
	/**
	 * Message Textview reference object
	 */
	private TextView MessageTextView;
	
	/**
	 * DTNAPIBinder object
	 */
	private DTNAPIBinder dtn_api_binder_;

	
	//  Default DTN send parameters 
	/**
	 * Default expiration time in seconds, set to 1 hour
	 */
	private static final int EXPIRATION_TIME = 1*60*60;
	
	/**
	 * Set delivery options to don't flag at all
	 */
	private static final int DELIVERY_OPTIONS = 0;
	
	/**
	 * Set priority to normal sending
	 */
	private static final dtn_bundle_priority_t PRIORITY = dtn_bundle_priority_t.COS_NORMAL;
	 
	/**
	 * The service connection to communicate with DTNService 
	 */
	private ServiceConnection conn_;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(se.kth.ssvl.tslab.bytewalla.androiddtn.R.layout.missing_person_entry);
        bindDTNService();
        addGenderAgeSpinner();
        
        Button cancelBtn = (Button)findViewById(se.kth.ssvl.tslab.bytewalla.androiddtn.R.id.btncancel);
        cancelBtn.setOnClickListener(new OnClickListener()
        		{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(MissingPersons.this, ModuleSelect.class);
						startActivity(i);
					}
        			
        		});        
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
	
	
	/**
	 * bind the DTNService to use the API later
	 */
	private void bindDTNService()
	{
		conn_ = new ServiceConnection() {

			public void onServiceConnected(ComponentName arg0, IBinder ibinder) {
				Log.i(TAG, "DTN Service is bound");
				dtn_api_binder_ = (DTNAPIBinder) ibinder;
			}


			
			public void onServiceDisconnected(ComponentName arg0) {
				Log.i(TAG, "DTN Service is Unbound");
				dtn_api_binder_ = null;
			}

			};

			Intent i = new Intent(MissingPersons.this, DTNService.class);
			bindService(i, conn_, BIND_AUTO_CREATE);	
	}
	/**
	 * send Data to DTNService
	 */
	public void sendData(View view)
	{
		EditText firstNameEditText = (EditText) findViewById(R.id.firstNameMP);
		String firstName = firstNameEditText.getText().toString();
		
		EditText middleNameEditText = (EditText) findViewById(R.id.middleNameMP);
		String middleName = firstNameEditText.getText().toString();
		
		EditText lastNameEditText = (EditText) findViewById(R.id.lastNameMP);
		String lastName = firstNameEditText.getText().toString();
		
		try {
			sendMessage(firstName);
			new AlertDialog.Builder(MissingPersons.this).setMessage(
					"Sent DTN message to DTN Service successfully ")
					.setPositiveButton("OK",  new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {
                            // Write your code here to execute after dialog
                        	Intent i = new Intent(MissingPersons.this, ModuleSelect.class);
    						startActivity(i);
                        }
                    }).show();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DTNOpenFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DTNAPIFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		unbindDTNService();
	}
	private void unbindDTNService()
	{
		unbindService(conn_);
	}
	/**
	 * major function for send message by calling dtnsend API
	 * @throws UnsupportedEncodingException
	 * @throws DTNOpenFailException
	 * @throws DTNAPIFailException
	 */
	private void sendMessage(String data) throws UnsupportedEncodingException, DTNOpenFailException, DTNAPIFailException
	{
		// Getting values from user interface
		String message = "test";
		byte[] message_byte_array = message.getBytes("US-ASCII");
		
		String dest_eid = getString(R.string.sahana_destination_eid);
		//String dest_eid = "dtn://" 
	    //		+ ((WifiManager)getBaseContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getMacAddress().replace(":", "") 
	    	//	+ ".bytewalla.com";
		// Setting DTNBundle Payload according to the values
		DTNBundlePayload dtn_payload = new DTNBundlePayload(dtn_bundle_payload_location_t.DTN_PAYLOAD_MEM);
		dtn_payload.set_buf(message_byte_array);
		
	//	DTNBundlePayload dtn_payload = new DTNBundlePayload(dtn_bundle_payload_location_t.DTN_PAYLOAD_FILE);
		//dtn_payload.set_file(new File("/sdcard/test3MB.zip"));
	//	dtn_payload.set_file(new File("/sdcard/test.htm"));
		   
		// Start the DTN Communication
		DTNHandle dtn_handle = new DTNHandle();
		dtn_api_status_report_code open_status = dtn_api_binder_.dtn_open(dtn_handle);
		if (open_status != dtn_api_status_report_code.DTN_SUCCESS) throw new DTNOpenFailException();
		try
		{
		DTNBundleSpec spec = new DTNBundleSpec();
		
		// set destination from the user input
		spec.set_dest(new DTNEndpointID(dest_eid));
		
		// set the source EID from the bundle Daemon
		spec.set_source(new DTNEndpointID(BundleDaemon.getInstance().local_eid().toString()));
			
		// Set expiration in seconds, default to 1 hour
		spec.set_expiration(EXPIRATION_TIME);
		// no option processing for now
		spec.set_dopts(DELIVERY_OPTIONS);
		// Set prority
		spec.set_priority(PRIORITY);
		
		// Data structure to get result from the IBinder
		DTNBundleID dtn_bundle_id = new DTNBundleID();
		
		dtn_api_status_report_code api_send_result =  dtn_api_binder_.dtn_send(dtn_handle, 
				spec, 
				dtn_payload, 
				dtn_bundle_id);
		
		// If the API fail to execute throw the exception so user interface can catch and notify users
		if (api_send_result != dtn_api_status_report_code.DTN_SUCCESS)
		{
			throw new DTNAPIFailException();
		}
		
		}
		finally
		{
			dtn_api_binder_.dtn_close(dtn_handle);
			
		}
	
		
		
	}
		
}
