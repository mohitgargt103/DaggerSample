package mohit.com.daggersample.model.Component;

import javax.inject.Singleton;

import dagger.Component;
import mohit.com.daggersample.view.MainActivity;
/**
 * Created by mohit on 9/11/16.
 */


@Singleton
@Component(modules = {DiModule.class})

public interface DiComponent {

    // to update the fields in your activities
    void inject(MainActivity activity);


}
