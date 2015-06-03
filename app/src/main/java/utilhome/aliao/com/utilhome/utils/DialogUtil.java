package utilhome.aliao.com.utilhome.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

/**
 * Created by ÀöË« on 2015/6/3.
 */
public class DialogUtil {

    public static AlertDialog.Builder dialogBuilder(Context context, String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (msg != null){
            builder.setMessage(msg);
        }

        if (title != null){
            builder.setTitle(title);
        }
        return builder;
    }

    public static AlertDialog.Builder dialogBuilder(Context context, int titleResId, int msgResId) {
        String title = titleResId > 0 ? context.getResources().getString(titleResId) : null;
        String msg = msgResId > 0 ? context.getResources().getString(msgResId) : null;
        return dialogBuilder(context, title, msg);
    }


    public static AlertDialog.Builder dialogBuilder(Context context, int title, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (view != null) {
            builder.setView(view);
        }
        if (title > 0) {
            builder.setTitle(title);
        }
        return builder;
    }

}
