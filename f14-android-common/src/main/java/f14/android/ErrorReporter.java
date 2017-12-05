package f14.android;

import android.content.Context;
import android.content.Intent;

import f14.common.ExHelper;

/**
 * Created by f14shm4n on 22.11.2017.
 */

/**
 *
 */
public final class ErrorReporter {

    /**
     *
     * @param context
     * @param intentClass
     * @param e
     */
    public static void sendErrorReport(Context context, Class<?> intentClass, Exception e) {
        Intent resultIntent = new Intent(context, intentClass);
        resultIntent.putExtra("EX_DATA", e.toString());
        resultIntent.putExtra("EX_STACK", ExHelper.stackTraceToString(e));
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(resultIntent);

//                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(BTBackgroundService.this)
//                        .setSmallIcon(R.drawable.appicon)
//                        .setContentTitle("Error")
//                        .setContentText(e.getMessage());
//
//                Intent resultIntent = new Intent(BTBackgroundService.this, ExActivity.class);
//                resultIntent.putExtra("EX_DATA", e.toString());
//                resultIntent.putExtra("EX_STACK", ExHelper.stackTraceToString(e));
//
//                TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//                stackBuilder.addParentStack(ExActivity.class);
//                stackBuilder.addNextIntent(resultIntent);
//
//                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//
//                mBuilder.setContentIntent(resultPendingIntent);
//
//                ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(1, mBuilder.build());

    }
}
