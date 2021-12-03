package cl.ckelar.android.java.library.hefesto.service;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Conjunto de funciones que permiten interactuar con los Services de Android
 *
 * @version 1.0.0
 * @author Gerson Díaz
 * @author Ckelar Software
 * **/
public class ServiceUtil {
    private final String TAG = ServiceUtil.class.getName();

    /**
     * Permite identificar si el servicio está en ejecución o no
     *
     * @param serviceClass Es la clase del servicio a consultar por su estado de ejecución
     * @param context Contexto de la APP
     *
     * @return true or false (verdadero o falso si es que el servicio se encuentra en ejecución o no)
     * */
    public static boolean isRunning(Class<?> serviceClass, Context context) {
        boolean isRunning = false;

        // Objeto que permite acceder a los servicios en ejecución del dispositivo
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        //region Se recorre los servicios ejecutados en el dispositivo buscando el que necesito para determinar si se encuentra o no en ejecución
        for (ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                isRunning = true;
                break;
            }
        }
        //endregion

        return isRunning;
    }
}
