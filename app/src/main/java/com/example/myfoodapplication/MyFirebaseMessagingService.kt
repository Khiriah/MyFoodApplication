package com.example.myfoodapplication

//
//import android.content.ContentValues.TAG
//import android.util.Log
//import com.google.firebase.messaging.FirebaseMessagingService
//import com.google.firebase.messaging.RemoteMessage
//
//class FirebaseMessagingService : FirebaseMessagingService()  {
//
//    override fun onMessageReceived(remoteMessage: RemoteMessage) {
//
//        println("Message recieved!")
//        // ...
//
//        // TODO(developer): Handle FCM messages here.
//        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
//        Log.d(TAG, "From: ${remoteMessage.from}")
//
//        // Check if message contains a data payload.
//        if (remoteMessage.data.isNotEmpty()) {
//            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
//
//            /*        if (// Check if data needs to be processed by long running job // true) {
//                        // For long-running tasks (10 seconds or more) use WorkManager.
//                        scheduleJob()
//                    } else {
//                        // Handle message within 10 seconds
//                        handleNow()
//                    }*/
//        }
//
//        // Check if message contains a notification payload.
//        remoteMessage.notification?.let {
//            Log.d(TAG, "Message Notification Body: ${it.body}")
//        }
//
//        // Also if you intend on generating your own notifications as a result of a received FCM
//        // message, here is where that should be initiated. See sendNotification method below.
//    }
//}
//



//<service android:name=".FirebaseMessagingService"
//android:enabled="true"
//android:exported="true">
//<intent-filter>
//<action android:name="com.google.firebase.MESSAGING_EVENT"/>
//</intent-filter>
//</service>