package utilhome.aliao.com.utilhome.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

/**
 * Created by 丽双 on 2015/6/26.
 */
public class CacheUtil {
    /**
     * 返回可用内存的最大值，单位为kb
     * @return
     */
    public static int getAvailableMaxMemeryCache(){
        return (int) (Runtime.getRuntime().maxMemory() / 1024);
    }

    /**
     * 返回应用可用的最大内存值，单位为m
     * 如果设置了android:largeHeap为true，则返回虚拟机可用的最大内存
     * @param context
     * @return
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static int getAvailableMaxMemerySize(Context context){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        int memoryClass = am.getMemoryClass();
        if (hasHoneycomb() && isLargeHeap(context)){
            memoryClass = am.getLargeMemoryClass();
        }
        return memoryClass;//单位是M
    }

    private static boolean hasHoneycomb(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;//API11 Android3.0
    }

    private static boolean isLargeHeap(Context context){
        return (context.getApplicationInfo().flags & ApplicationInfo.FLAG_LARGE_HEAP) != 0;
    }
}
