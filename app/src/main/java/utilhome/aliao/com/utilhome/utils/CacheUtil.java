package utilhome.aliao.com.utilhome.utils;

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
}
