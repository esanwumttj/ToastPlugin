package com.toast.toast;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class ToastPlugin extends CordovaPlugin {
    public static String TOAST="Toast";
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
         if (TOAST.equals(action)) {
        //如果传过来的参数是 Toast 执行此方法
            Log.i(TOAST, "message:"+data.getString(0)+",length:"+data.getInt(1));
            toast(data.getString(0), data.getInt(1), callbackContext);
        }
        return false;
    }

     public synchronized void toast(final String message, final int length,
            CallbackContext callbackContext) {
          final CordovaInterface cordova = this.cordova;
              Runnable runnable = new Runnable() {
                  public void run() {
       Toast.makeText(cordova.getActivity(), message,0).show();
                  }
              };
             this.cordova.getActivity().runOnUiThread(runnable);
    }
}
