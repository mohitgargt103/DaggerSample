package mohit.com.daggersample.model;

import android.util.Patterns;
import android.webkit.URLUtil;
import android.widget.Toast;

import mohit.com.daggersample.app.MyApplication;

/**
 * Created by mohit on 9/11/16.
 */
public class Util {
    private static Util ourInstance = new Util();

    public static Util getInstance() {
        return ourInstance;
    }


    public void showToast(String s) {
        Toast.makeText(MyApplication.getInstance(), s, Toast.LENGTH_LONG).show();
    }


    public boolean isFieldEmpty(String s) {
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }


    public boolean isMailValid(String email) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }
        return true;
    }

    public boolean isPasswordValid(String password) {
        if (password.length() <= 8) {
            return false;
        }

        return true;
    }


    public boolean isUrlValid(String url) {
        if (URLUtil.isValidUrl(url)) {
            return true;
        }
        return false;

    }


}
