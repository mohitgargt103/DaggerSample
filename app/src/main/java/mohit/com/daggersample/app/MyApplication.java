package mohit.com.daggersample.app;

import android.app.Application;

import mohit.com.daggersample.model.Component.DaggerDiComponent;
import mohit.com.daggersample.model.Component.DiModule;
import mohit.com.daggersample.model.Component.DiComponent;


public class MyApplication extends Application {
    static MyApplication application;
    private DiComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        myComponent = DaggerDiComponent.builder().diModule(new DiModule()).build();


    }

    public static MyApplication getInstance() {
        return application;
    }

    public DiComponent getComponent() {
        return myComponent;
    }

}