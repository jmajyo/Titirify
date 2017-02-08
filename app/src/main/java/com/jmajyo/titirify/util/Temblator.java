package com.jmajyo.titirify.util;

import android.content.Context;
import android.os.Vibrator;

public class Temblator {
    public static void tremble(Context context, int milliseconds){
        // Get instance of Vibrator from current Context
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        // Vibrate for 400 milliseconds
        v.vibrate(400);
    }
}
