package utilhome.aliao.com.utilhome.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

/**
 * Created by ��˫ on 2015/6/26.
 */
public class CacheUtil {
    /**
     * ���ؿ����ڴ�����ֵ����λΪkb
     * @return
     */
    public static int getAvailableMaxMemeryCache(){
        return (int) (Runtime.getRuntime().maxMemory() / 1024);
    }

    /**
     * ����Ӧ�ÿ��õ�����ڴ�ֵ����λΪm
     * ���������android:largeHeapΪtrue���򷵻���������õ�����ڴ�
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
        return memoryClass;//��λ��M
    }

    private static boolean hasHoneycomb(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;//API11 Android3.0
    }

    private static boolean isLargeHeap(Context context){
        return (context.getApplicationInfo().flags & ApplicationInfo.FLAG_LARGE_HEAP) != 0;
    }
}
