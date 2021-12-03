package cl.ckelar.android.java.library.hefesto.helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import java.util.concurrent.Callable;

/**
 * Conjunto de funciones que permiten generar AlertsDialog
 *
 * @version 1.0.0
 * @author Gerson Díaz
 * @author Ckelar Software
 * **/
public class AlertsUtil {

    private static final String TAG = AlertsUtil.class.getName();

    /**
     * Función que permite crear un AlertDialog simple y personalizado
     *
     * @param context Contexto de la aplicación
     * @param title Título del AlertDialog
     * @param message Corresponde al mensaje que se requiere desplegar en el AlertDialog
     * @param txtPositiveButton Corresponde al texto del "botón de acción positiva". En caso no tener texto, éste botón no se muestra.
     * @param txtNegativeButton Corresponde al texto del "botón de acción negativa". En caso no tener texto, éste botón no se muestra.
     * @param positiveAction En caso requerir ejecutar alguna acción, se puede ejecutar una función al presionar el botón de acción positiva.
     * @param negativeAction En caso requerir ejecutar alguna acción, se puede ejecutar una función al presionar el botón de acción negativa.
     * **/
    public static AlertDialog.Builder createSimpleDialog(Context context, String title,
                                       String message, String txtPositiveButton,
                                       String txtNegativeButton,
                                       Callable<Void> positiveAction,
                                       Callable<Void> negativeAction) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        if (!txtPositiveButton.isEmpty()) {
            builder.setPositiveButton(txtPositiveButton, (dialog, id) -> {
                try {
                    if (positiveAction != null) {
                        positiveAction.call();
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }
            });
        }
        if (!txtNegativeButton.isEmpty()) {
            builder.setNegativeButton(txtNegativeButton, (dialog, id) -> {
                try {
                    if (negativeAction != null) {
                        negativeAction.call();
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }
            });
        }
        // Create the AlertDialog object and return it
        builder.create().show();
        return builder;

    }

}
