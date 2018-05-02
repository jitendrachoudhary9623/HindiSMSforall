package com.hindisms.jitcodez.hindismsforall.Utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Helper {
    ArrayList<String> sms;

    public ArrayList<String> getWhatsappStatus(Context context)
    {
       String filename="ms.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public void fetchData(String filename,Context context)
    {
        String fileContent="";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(filename), "UTF-8"));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                fileContent=fileContent+mLine+"\n";
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        String content[]=fileContent.split("@@@");
        sms=null;
        sms=new ArrayList<>();
        for(int i=0;i<content.length;i++)
        {
            sms.add(content[i]);
        }
        sms.remove(sms.size()-1);
    }

    public ArrayList<String> getFriendSMS(Context context)
    {
        String filename="friend.txt";
       sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getFunnySMS(Context context)
    {
        String filename="funnysms.txt";
         sms=new ArrayList<String>();


        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getInspiringSMS(Context context)
    {
        String filename="ayushya.txt";
        sms=new ArrayList<String>();


        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getBirthdaySMS(Context context)
    {
        String filename="birthday.txt";
        sms=new ArrayList<String>();


        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getGoodluckSMS(Context context)
    {
        String filename="goodluck.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getGoodMorningSMS(Context context)
    {
        String filename="goodmorning.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getMissingYouSMS(Context context)
    {
        String filename="missingyou.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getGoodNightSMS(Context context)
    {
        String filename="night.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getLoveSMS(Context context)
    {
        String filename="prem.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getRomanticSMS(Context context)
    {
        String filename="prem1.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

    public ArrayList<String> getValentineSMS(Context context)
    {
        String filename="valentine.txt";

        sms=new ArrayList<String>();
        fetchData(filename,context);

        return sms;
    }

}
