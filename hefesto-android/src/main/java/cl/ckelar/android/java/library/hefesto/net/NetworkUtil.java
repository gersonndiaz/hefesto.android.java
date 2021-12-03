package cl.ckelar.android.java.library.hefesto.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Conjunto de funciones que permiten acceder a la información de conectividad del dispositivo
 *
 * @version 1.0.0
 * @author Gerson Díaz
 * @author Ckelar Software
 * **/
public class NetworkUtil {

    private static final String TAG = NetworkUtil.class.getName();

    /**
     * Comprueba si el dispositivo se encuentra conectado a Internet
     *
     * @param context
     * @return Obtiene verdadero o Falso dependiendo si el dispositivo está conectado
     * **/
    public static boolean isOnline(Context context) {

        boolean connected = false;

        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            throw e;
        }
    }
}
