package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    private int i;

    @Override
    public void onReceive(Context context, Intent intent){
        //get the SMS message passed in
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "SMS from";
        if (bundle != null){
            //receive the SMS message received
            msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (int i = 0; i<msgs.length; i++){
                str +=msgs[i].getDisplayMessageBody().toString();
            }
            //get the message body
            str += msgs[i].getMessageBody().toString();
        }
        //display the new SMS message
        Toast.makeText(context, str,Toast.LENGTH_SHORT).show();
        Log.d("SMSReceiver",str);
    }
}
