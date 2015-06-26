package utilhome.aliao.com.utilhome.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Provides application storage paths
 * Created by 丽双 on 2015/6/18.
 */
public class StorageUtil {

    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";

    /**
     * Storage state if the media is present and mounted at its mount point with
     * read/write access.
     */
    public static final String MEDIA_MOUNTED = "mounted";

    private StorageUtil(){
    }

    public static File getCacheDirectory(Context context){
        return getCacheDirectory(context, true);
    }

    /**
     * 获取内存缓存目录
     * @param context
     * @param preferExternal
     * @return
     */
    public static File getCacheDirectory(Context context, boolean preferExternal){
        File appCacheDir = null;
        String externalStorageState;

        externalStorageState = Environment.getExternalStorageState();

        if (preferExternal && MEDIA_MOUNTED.equals(externalStorageState) && hasExternalStoragePermission(context)){
            appCacheDir = getExternamCacheDir(context);
        }
        if (appCacheDir == null){
            appCacheDir = context.getCacheDir();
        }

        if (appCacheDir == null){
            String cacheDirPath = "/data/data/" + context.getPackageName() + "/cache/";
            appCacheDir = new File(cacheDirPath);
        }

        return appCacheDir;
    }

    /**
     * 获取sd卡上的缓存目录
     * @param context
     * @return
     */
    private static File getExternamCacheDir(Context context){

        File dataDir = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File appCacheDir = new File(new File(dataDir, context.getPackageName()), "cache");
        if (!appCacheDir.exists()){
            if (!appCacheDir.mkdirs()){
                L.w("Unable to create external cache directory");
                return null;
            }
            try{
                new File(appCacheDir, ".nomedia").createNewFile();
            }catch (IOException e){
                L.i("Can't create \".nomedia\" file in application external cache directory");
            }
        }

        return appCacheDir;
    }

    private static boolean hasExternalStoragePermission(Context context){
        int perm = context.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION);
        return perm == PackageManager.PERMISSION_GRANTED;
    }

    public static File createReserveDiskCache(Context context){
        File cacheFile = getCacheDirectory(context, false);
        File individualFile = new File(cacheFile, "uil-image");
        if (individualFile.exists() || individualFile.mkdir()){
            cacheFile = individualFile;
        }
        return cacheFile;
    }

}
