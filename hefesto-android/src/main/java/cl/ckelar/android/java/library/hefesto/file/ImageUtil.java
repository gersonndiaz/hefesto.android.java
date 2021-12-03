package cl.ckelar.android.java.library.hefesto.file;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.Log;

import cl.ckelar.android.java.library.hefesto.helpers.AlertsUtil;

/**
 * Conjunto de funciones que permiten manipular imágenes
 *
 * @version 1.0.0
 * @author Gerson Díaz
 * @author Ckelar Software
 * **/
public class ImageUtil {

    private static final String TAG = ImageUtil.class.getName();

    /**
     * Obtiene una imagen escalada al tamaño de pantalla del dispositivo
     *
     * @see Context
     * @see Bitmap
     *
     * @param context Contexto de la aplicación
     * @param bitmap Corresponde a la imagen a manipular
     * @param maxWidth Define el ancho máximo de la imagen
     * @return Retorna la imagen escalada al tamaño según pantalla
     * **/
    public static Bitmap bitmapResizeScreenLayout(Context context, Bitmap bitmap, int maxWidth) {

        float scale;
        int newSize;
        Bitmap bm = null;

        try {
            // Para pantallas small (small screens are at least 426dp x 320dp)
            if ((context.getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK) ==
                    Configuration.SCREENLAYOUT_SIZE_SMALL) {

                //width = width / 2;
                Log.e(TAG, "Pantalla Tamaño Small.");

            /*scale = (float) maxWidth / bitmap.getHeight();
            newSize = Math.round(bitmap.getWidth() * scale);
            bm = Bitmap.createScaledBitmap(bitmap, newSize, maxWidth, true);*/
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float ratioBitmap = (float) width / (float) height;

                int finalHeight = (int) ((float)maxWidth / ratioBitmap);

                bm = Bitmap.createScaledBitmap(bitmap, maxWidth, finalHeight, true);

            }

            // Para pantallas normal (normal screens are at least 470dp x 320dp)
            if ((context.getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK) ==
                    Configuration.SCREENLAYOUT_SIZE_NORMAL) {

                //width = width / 2;
                Log.e(TAG, "Pantalla Tamaño Normal.");

            /*scale = (float) maxWidth / bitmap.getHeight();
            newSize = Math.round(bitmap.getWidth() * scale);
            bm = Bitmap.createScaledBitmap(bitmap, newSize, maxWidth, true);*/
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float ratioBitmap = (float) width / (float) height;

                int finalHeight = (int) ((float)maxWidth / ratioBitmap);

                bm = Bitmap.createScaledBitmap(bitmap, maxWidth, finalHeight, true);

            }

            // Para pantallas large (large screens are at least 640dp x 480dp)
            if ((context.getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK) ==
                    Configuration.SCREENLAYOUT_SIZE_LARGE) {

                //float mw = (float) (maxWidth * 0.7);
                //maxWidth = Math.round(mw);
                Log.e(TAG, "Pantalla Tamaño Large.");

            /*scale = (float) maxWidth / bitmap.getHeight();
            newSize = Math.round(bitmap.getWidth() * scale);
            bm = Bitmap.createScaledBitmap(bitmap, newSize, maxWidth, true);*/
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float ratioBitmap = (float) width / (float) height;

                int finalHeight = (int) ((float)maxWidth / ratioBitmap);

                bm = Bitmap.createScaledBitmap(bitmap, maxWidth, finalHeight, true);

            }

            // Para pantallas xlarge (xlarge screens are at least 960dp x 720dp)
            if ((context.getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK) ==
                    Configuration.SCREENLAYOUT_SIZE_XLARGE) {

                //float mw = (float) (maxWidth * 0.7);
                //maxWidth = Math.round(mw);
                Log.e(TAG, "Pantalla Tamaño XLarge.");

            /*scale = (float) maxWidth / bitmap.getHeight();
            newSize = Math.round(bitmap.getWidth() * scale);
            bm = Bitmap.createScaledBitmap(bitmap, newSize, maxWidth, true);*/
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float ratioBitmap = (float) width / (float) height;

                int finalHeight = (int) ((float)maxWidth / ratioBitmap);

                bm = Bitmap.createScaledBitmap(bitmap, maxWidth, finalHeight, true);

            }

        }
        catch (Exception e) {
            Log.e(TAG, e.toString());
            throw e;
        }

        return bm;

    }
}
