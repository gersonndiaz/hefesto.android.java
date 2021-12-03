package cl.ckelar.android.java.library.hefesto.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import cl.ckelar.android.java.library.hefesto.R;

/**
 * Conjunto de funciones que ofrecen diferentes acciones
 *
 * @version 1.0.0
 * @author Gerson Díaz
 * @author Ckelar Software
 * **/
public class Utils {

    private static final String TAG = Utils.class.getName();

    /**
     * Obtiene el nombre de la versión actual de la app
     * @see Context
     * @param context
     * @return Retorna el nombre de la versión actual de la app
     * **/
    public static String getVersionName(Context context) {
        String versionName = "";

        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
            //versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e.toString());
            versionName = "S/N";
        }

        return versionName;
    }

    /**
     * Comprueba si una app está instalada por medio del nombre del paquete
     *
     * @param appPackageName Nombre del paquete
     * @param context Contexto de la app
     *
     * @return true o false dependiendo si se encuentra o no instalada
     * **/
    public static boolean isAppInstalled(String appPackageName, Context context) {

        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(appPackageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "isAppInstalled(String appPackageName, Context context): " + e);
            Toast.makeText(context,context.getString(R.string.lbl_app_not_installed),Toast.LENGTH_LONG).show();
            return false;
        }
    }

    /**
     * Abre Google Play en una aplicación específica utilizando el nombre del paquete de la aplicación
     *
     * @param appPackageName Nombre del paquete
     * @param context Contexto de la app
     * **/
    public static void openGooglePlay(String appPackageName, Context context) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        } catch (Exception e) {
            Log.e(TAG, "openGooglePlay(String appPackageName, Context context): " + e);
            String errMsg = context.getString(R.string.lbl_googleplay_error_open);
            errMsg = errMsg.replace("@appPackage", appPackageName);
            Toast.makeText(context, errMsg,Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Inicia aplicación específica utilizando el nombre del paquete de la aplicación
     *
     * @param appPackageName Nombre del paquete
     * @param context Contexto de la app
     * **/
    public static void openAppByPackageName(String appPackageName, Context context) {
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(appPackageName);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "openAppByPackageName(String appPackageName, Context context): " + e);

            String errMsg = context.getString(R.string.lbl_app_error_open);
            errMsg = errMsg.replace("@appPackage", appPackageName);
            Toast.makeText(context, errMsg,Toast.LENGTH_LONG).show();
        }
    }
}
