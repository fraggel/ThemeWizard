package es.fraggel.themewizard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs =context.getSharedPreferences("ThemeWizard", Context.MODE_PRIVATE);
        boolean correo = prefs.getBoolean("primera", true);
        if(correo){
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean("primera", false);
            edit.commit();

            Intent intentone = new Intent(context.getApplicationContext(), ThemeWizard.class);
            intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentone);
        }
    }
}
