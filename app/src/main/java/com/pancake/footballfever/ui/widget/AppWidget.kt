package com.pancake.footballfever.ui.widget

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import com.pancake.footballfever.R
import com.pancake.footballfever.ui.HomeActivity


class AppWidget : AppWidgetProvider() {

    companion object {
        private const val ACTION_WIDGET_UPDATE = "com.pancake.footballfever.ACTION_WIDGET_UPDATE"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)

        if (intent?.action == ACTION_WIDGET_UPDATE) {
            // Handle widget click event
            val launchIntent = Intent(context, HomeActivity::class.java)
            launchIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context?.startActivity(launchIntent)
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val remoteViews = RemoteViews(context.packageName,R.layout.app_widget)

            // Get the matches data from the home screen fragment or your data source
            val matches = getMatchesData()

            if (matches.isNotEmpty()) {
                remoteViews.setTextViewText(R.id.widgetTitle, "Matches Today")
                Log.i("Kamel","Home")
                // TODO: Update the RecyclerView or TextView with match data in the widget layout
            } else {
                remoteViews.setTextViewText(R.id.widgetTitle, "No matches today")
                Log.i("Kamel","away")
            }

            // Open the home screen fragment when the widget is clicked
            val intent = Intent(context, HomeActivity::class.java)
            intent.action = ACTION_WIDGET_UPDATE
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
            remoteViews.setOnClickPendingIntent(R.id.widgetLayout, pendingIntent)

            // Update the widget
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
        }
    }

    private fun getMatchesData(): List<String> {
        return listOf("A7a")

    }


}

//internal fun updateAppWidget(
//    context: Context,
//    appWidgetManager: AppWidgetManager,
//    appWidgetId: Int
//) {
//    val widgetText = context.getString(R.string.appwidget_text)
//
//    val views = RemoteViews(context.packageName, R.layout.app_widget)
//    views.setTextViewText(R.id.widgetTitle, widgetText)
//
//
//    appWidgetManager.updateAppWidget(appWidgetId, views)
//}





