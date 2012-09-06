package com.dalang.fs_cli;

import android.content.SharedPreferences;

public class FsSetting {
	private SharedPreferences mPrefs;
	
	private String mServer;
	private String mPassword;
	private int mPort;
	private static final String SERVER_KEY = "server";
	private static final String PASSWORD_KEY = "password";
	private static final String PORT_KEY = "port";
	    
	public FsSetting(SharedPreferences prefs) {
        readPrefs(prefs);
    }
	
    public void readPrefs(SharedPreferences prefs) {
    	mPrefs = prefs;
    	
        mServer = readStringPref(SERVER_KEY, "127.0.0.1");
        mPassword = readStringPref(PASSWORD_KEY, "ClueCon");
        mPort = readIntPref(PORT_KEY, 8021);
        
        //mPrefs = null;  // we leak a Context if we hold on to this
    }
    
    private int readIntPref(String key, int defaultValue) {
        int val;
        try {
            val = Integer.parseInt(
                mPrefs.getString(key, Integer.toString(defaultValue)));
        } catch (NumberFormatException e) {
            val = defaultValue;
        }
        return val;
    }

    private String readStringPref(String key, String defaultValue) {
        return mPrefs.getString(key, defaultValue);
    }

    private boolean readBooleanPref(String key, boolean defaultValue) {
        return mPrefs.getBoolean(key, defaultValue);
    }
    
    public String getServer() {
        return mServer;
    }
    
    public String getPassword() {
        return mPassword;
    }
    
    public int getPort() {
        return mPort;
    }

}
