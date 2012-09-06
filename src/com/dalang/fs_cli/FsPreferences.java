package com.dalang.fs_cli;


import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.util.Log;

public class FsPreferences extends PreferenceActivity implements OnPreferenceChangeListener  {
	
	EditTextPreference updateServerPref;
	EditTextPreference updatePasswordPref;
	EditTextPreference updatePortPref;
	private static final String SERVER_KEY = "server";
	private static final String PASSWORD_KEY = "password";
	private static final String PORT_KEY = "port";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Load the preferences from an XML resource
		addPreferencesFromResource(R.xml.preferences);

		updateServerPref = (EditTextPreference)findPreference(SERVER_KEY);
		updatePasswordPref = (EditTextPreference)findPreference(PASSWORD_KEY);
		updatePortPref = (EditTextPreference)findPreference(PORT_KEY);
		updateServerPref.setOnPreferenceChangeListener(this);  
		updatePasswordPref.setOnPreferenceChangeListener(this);  
		updatePortPref.setOnPreferenceChangeListener(this);  
	}
	
    @Override  
    public boolean onPreferenceChange(Preference preference, Object newValue) {  
 
        if(preference.getKey().equals(SERVER_KEY))  
        {  
            Log.v("Event Socket Setting", "server is changed");  
        }  
        else if(preference.getKey().equals(PASSWORD_KEY))  
        {  
            Log.v("Event Socket Setting", "password is changed");  
        }  
        else if(preference.getKey().equals(PORT_KEY))  
        {  
        	Log.v("Event Socket Setting", "port is changed");  
        }  
        else  
        {  
            //cannot be changed
            return false;  
        }  
        //changing is accepted
        return true;  
    }
}
