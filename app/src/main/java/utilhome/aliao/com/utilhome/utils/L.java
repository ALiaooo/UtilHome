package utilhome.aliao.com.utilhome.utils;

import android.util.Log;

/**
 * Created by ALiao on 2014/12/25.
 * desc:Log工具类
 */
public class L {

    private static final boolean DEBUG = true;
    private static final String TAG = "happy";

    public static void v(String msg){
        if (DEBUG) Log.v(TAG, msg);
    }
    public static void d(String msg){
        if (DEBUG) Log.d(TAG, msg);
    }
    public static void i(String msg){
        if (DEBUG) Log.i(TAG, msg);
    }
    public static void e(String msg){
        if (DEBUG) Log.e(TAG, msg);
    }

    public static void v(String tag, String msg){
        if (DEBUG) Log.v(tag, msg);
    }
    public static void d(String tag, String msg){
        if (DEBUG) Log.d(tag, msg);
    }
    public static void i(String tag, String msg){
        if (DEBUG) Log.i(tag, msg);
    }
    public static void e(String tag, String msg){
        if (DEBUG) Log.e(tag, msg);
    }
}
