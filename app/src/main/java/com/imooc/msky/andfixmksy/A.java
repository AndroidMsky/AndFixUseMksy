package com.imooc.msky.andfixmksy;

import android.app.Application;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

/**
 * Created by lmt on 17/1/12.
 */

public class A extends Application {


    static PatchManager patchManager;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("AAA","APPLICATION");
        //String appversion=getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        patchManager = new PatchManager(this);
        patchManager.init("1.0");//current version
        patchManager.loadPatch();




    }

    public  static void load(){

        try {
            Log.d("AAA","want to");
            patchManager.addPatch("/sdcard/zhibo8/aa.apatch");
            Log.d("AAA","success");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("AAA","fail");
        }
    }

    public  static void remove(){
        patchManager.removeAllPatch();

    }

}
