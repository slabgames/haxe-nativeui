package org.haxe.extension;


import android.app.Activity;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.widget.Toast;
import android.app.ProgressDialog;

import android.net.Uri;
import android.content.Intent;

import java.lang.Runnable;

//import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class Nativeui extends Extension {
	private static ProgressDialog dialog;
	

	public static void makeToast(final String msg) {
		Extension.mainActivity.runOnUiThread(new Runnable() {
			public void run() {
				Toast.makeText(Extension.mainContext, msg, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public static void showProgressDialog(final String msg, final boolean cancelable) {
		Extension.mainActivity.runOnUiThread(new Runnable() {
			public void run() {
				if(dialog!=null) 
				{
					dialog.dismiss();
					dialog = null;
				}
				dialog = ProgressDialog.show(Extension.mainActivity, "", msg, true, cancelable);
			}
		});
	}
	
	public static void hideProgressDialog()
	{
		Extension.mainActivity.runOnUiThread(new Runnable() {
			public void run() {
				if(dialog!=null) 
				{
					dialog.dismiss();
					dialog = null;
				}
			}
		});
	}

	public static void openUrl(final String url )
	{
		Extension.mainActivity.runOnUiThread(new Runnable() {
			public void run() {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));

				// Always use string resources for UI text. This says something like "Share this photo with"
				String title = "Complete Action Using";
				// Create and start the chooser
				Intent chooser = Intent.createChooser(intent, title);
				Extension.mainContext.startActivity(chooser);
			}
		});
	}
	
	
	
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		
		return true;
		
	}
	
	
	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {
		
	// 	AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
    //     @Override
    //     protected String doInBackground(Void... params) {
    //         AdvertisingIdClient.Info idInfo = null;
    //         try {
    //             idInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
    //         } catch (GooglePlayServicesNotAvailableException e) {
    //             e.printStackTrace();
    //         } catch (GooglePlayServicesRepairableException e) {
    //             e.printStackTrace();
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //         String advertId = null;
    //         try{
    //             advertId = idInfo.getId();
    //         }catch (NullPointerException e){
    //             e.printStackTrace();
    //         }

    //         return advertId;
    //     }

    //     @Override
    //     protected void onPostExecute(String advertId) {
    //         Toast.makeText(getApplicationContext(), advertId, Toast.LENGTH_SHORT).show();
    //     }

    // };
    // task.execute();
		
	}
	
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	
}