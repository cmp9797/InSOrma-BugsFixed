package com.example.quiz1.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.example.quiz1.FurnitureDetailActivity;
import com.example.quiz1.models.SmsModel;

public class MySmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                Object[] pdus = (Object[])bundle.get("pdus");
                SmsMessage[] message = new SmsMessage[pdus.length];

                for(int i=0; i< pdus.length; i++){
                    String format = bundle.getString("format");
                    message[i] = SmsMessage.createFromPdu((byte[])pdus[i], format);
                }

                FurnitureDetailActivity.items.add(new SmsModel(
                        message[0].getOriginatingAddress(),
                        message[0].getMessageBody()
                ));
//
//                FurnitureDetailActivity.smsAdapter.notifyDataSetChanged();

            }
        }
    }
}