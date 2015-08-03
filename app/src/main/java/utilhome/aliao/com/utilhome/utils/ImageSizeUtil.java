package utilhome.aliao.com.utilhome.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

/**
 * Created by 丽双 on 2015/8/3.
 */
public class ImageSizeUtil {

    /**
     * 获取图片占用的内存大小
     * @param bitmap
     * @return
     */
    public static int getBitmapSize(Bitmap bitmap){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){// API 19  Android 4.4
            return bitmap.getAllocationByteCount();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1){// API 12  Android 3.1
            return bitmap.getByteCount();
        }

        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /**
     * 计算inSampleSize，即原图与显示在屏幕上的图片尺寸的压缩比例，用于图片解码时内存的分配
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int width = options.outWidth;//原图的宽
        int height = options.outHeight;//原图的高
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth){
            //计算出原图宽高和目标宽高的比例——缩小几倍
            int heightRadio = Math.round((float)height / (float)reqHeight);
            int widthRadio = Math.round((float)width / (float)reqWidth);
            //选择宽和高中最小的比例作为inSampleSize的值，可以保证最终图片的宽和高一定都会大于等于目标的宽和高
            inSampleSize = heightRadio < widthRadio ? heightRadio : widthRadio;
        }
        return inSampleSize;
    }


}
