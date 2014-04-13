package com.example.reallycomplicatedform;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		final TextView statusBarView = (TextView) findViewById(R.id.textView8);
		
		final TextView fullNameView = (TextView) findViewById(R.id.textView2);
		final EditText fullNameText = (EditText) findViewById(R.id.editText1);
		fullNameText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				//get stuff after enter key press
				if ((event.getAction() == KeyEvent.ACTION_DOWN)
						&& (keyCode == KeyEvent.KEYCODE_ENTER)) {
					statusBarView.setText("Hello "+ fullNameText.getText());
					return true;
				}
				return false;
			}
		});
		
		final TextView addressView = (TextView) findViewById(R.id.textView3);
		final EditText addressText = (EditText) findViewById(R.id.editText2);
		
		final TextView cityView = (TextView) findViewById(R.id.textView1);
		final EditText cityText = (EditText) findViewById(R.id.editText3);
		
		final TextView stateView = (TextView) findViewById(R.id.textView7);
		final EditText stateText = (EditText) findViewById(R.id.editText4);
		
		final TextView countryView = (TextView) findViewById(R.id.textView4);
		final AutoCompleteTextView countryText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, COUNTRIES);
		countryText.setAdapter(adapter);
		countryText.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				statusBarView.setText(arg0.getAdapter().getItem(arg2)+" selected!");
			}
		});
		
		final TextView sexView = (TextView) findViewById(R.id.textView5);
		final OnClickListener radioListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				RadioButton rb = (RadioButton) v;
				statusBarView.setText("You are "+rb.getText());
			}
		};
		
		final RadioButton choice1 = (RadioButton) findViewById(R.id.radio0);
		choice1.setOnClickListener(radioListener);
		final RadioButton choice2 = (RadioButton) findViewById(R.id.radio1);
		choice2.setOnClickListener(radioListener);
		final RadioButton choice3 = (RadioButton) findViewById(R.id.radio2);
		choice3.setOnClickListener(radioListener);
		
		final GridLayout bg = (GridLayout) findViewById(R.id.gridlayout);
		final TextView trainingView = (TextView) findViewById(R.id.textView6);
		final ToggleButton adp1Button = (ToggleButton) findViewById(R.id.toggleButton1);
		adp1Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (adp1Button.isChecked()) {
					bg.setBackgroundColor(0xFFF3F3F3);
				} else {
					bg.setBackgroundColor(0xFF000000);
				}
			}
		});
		final ToggleButton adp2Button = (ToggleButton) findViewById(R.id.toggleButton2);
		final ToggleButton adp3Button = (ToggleButton) findViewById(R.id.toggleButton3);
		final ToggleButton adp4Button = (ToggleButton) findViewById(R.id.toggleButton4);
		final ToggleButton adp5Button = (ToggleButton) findViewById(R.id.toggleButton5);
		
		final TextView rateView = (TextView) findViewById(R.id.textView9);
		final RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
        bar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				statusBarView.setText("You rated "+rating);
			}
		});
		
		final TextView timeView = (TextView) findViewById(R.id.textView10);
		final TimePicker timeButton = (TimePicker) findViewById(R.id.timePicker1);
		
		final TextView websiteView = (TextView) findViewById(R.id.textView12);
		final EditText websiteText = (EditText) findViewById(R.id.editText7);
		final Button websiteButton = (Button) findViewById(R.id.button1);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	static final String[] COUNTRIES = new String[] { "Afghanistan", "Albania",
		"Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
		"Antarctica", "Antigua and Barbuda", "Argentina", "Armenia",
		"Aruba", "Australia", "Austria", "Azerbaijan", "Bahrain",
		"Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
		"Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
		"Botswana", "Bouvet Island", "Brazil",
		"British Indian Ocean Territory", "British Virgin Islands",
		"Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cote d'Ivoire",
		"Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
		"Central African Republic", "Chad", "Chile", "China",
		"Christmas Island", "Cocos (Keeling) Islands", "Colombia",
		"Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia",
		"Cuba", "Cyprus", "Czech Republic",
		"Democratic Republic of the Congo", "Denmark", "Djibouti",
		"Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt",
		"El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
		"Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji",
		"Finland", "Former Yugoslav Republic of Macedonia", "France",
		"French Guiana", "French Polynesia", "French Southern Territories",
		"Gabon", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece",
		"Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala",
		"Guinea", "Guinea-Bissau", "Guyana", "Haiti",
		"Heard Island and McDonald Islands", "Honduras", "Hong Kong",
		"Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
		"Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
		"Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
		"Latvia", "Lebanon", "Lesotho", "Liberia", "Libya",
		"Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Madagascar",
		"Malawi", "Malaysia", "Maldives", "Mali", "Malta",
		"Marshall Islands", "Martinique", "Mauritania", "Mauritius",
		"Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia",
		"Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
		"Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
		"New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria",
		"Niue", "Norfolk Island", "North Korea", "Northern Marianas",
		"Norway", "Oman", "Pakistan", "Palau", "Panama",
		"Papua New Guinea", "Paraguay", "Peru", "Philippines",
		"Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
		"Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe",
		"Saint Helena", "Saint Kitts and Nevis", "Saint Lucia",
		"Saint Pierre and Miquelon", "Saint Vincent and the Grenadines",
		"Samoa", "San Marino", "Saudi Arabia", "Senegal", "Seychelles",
		"Sierra Leone", "Singapore", "Slovakia", "Slovenia",
		"Solomon Islands", "Somalia", "South Africa",
		"South Georgia and the South Sandwich Islands", "South Korea",
		"Spain", "Sri Lanka", "Sudan", "Suriname",
		"Svalbard and Jan Mayen", "Swaziland", "Sweden", "Switzerland",
		"Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand",
		"The Bahamas", "The Gambia", "Togo", "Tokelau", "Tonga",
		"Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
		"Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
		"Ukraine", "United Arab Emirates", "United Kingdom",
		"United States", "United States Minor Outlying Islands", "Uruguay",
		"Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam",
		"Wallis and Futuna", "Western Sahara", "Yemen", "Yugoslavia",
		"Zambia", "Zimbabwe" };
}