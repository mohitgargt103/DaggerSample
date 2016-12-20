package mohit.com.daggersample.model.Component;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mohit.com.daggersample.model.Util;

/**
 * Created by mohit on 9/11/16.
 */
@dagger.Module
public class DiModule {

    @Provides
    @Singleton
    public Util getUtil() {
        return Util.getInstance();
    }


}
