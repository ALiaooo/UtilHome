package utilhome.aliao.com.utilhome.utils;

import android.os.Bundle;

/**
 * Created by 丽双 on 2015/4/21.
 */
public class ThreadUtil {
    /**
     * 获取当前线程id
     * @return
     */
    public static long getThreadId(){
        Thread t = Thread.currentThread();
        return t.getId();
    }

    /**
     * 获取当前线程信息
     * @return
     */
    public static String getThreadSignature(){
        Thread t = Thread.currentThread();
        long l = t.getId();
        String name = t.getName();
        long p = t.getPriority();
        String gname = t.getThreadGroup().getName();
        return (name + ":(id)"+ l +":(priority)"+ p + ":(group)" + gname);
    }

    /**
     * 打印线程信息
     */
    public static void logThreadSignature(){
        L.d("ThreadUtils",getThreadSignature());
    }

    /**
     * 让当前线程休眠
     * @param secs
     */
    public static void sleepForInSecs(int secs){
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {

            throw new RuntimeException("interrupted", e);
        }
    }

    public static Bundle getStringAsBundle(String message){
        Bundle b = new Bundle();
        b.putString("message",message);
        return b;
    }

    public static String getStringFromBundle(Bundle b){
        return b.getString("message");
    }
}
