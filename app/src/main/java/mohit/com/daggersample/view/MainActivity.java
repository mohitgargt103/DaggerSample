package mohit.com.daggersample.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.net.URL;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mohit.com.daggersample.R;
import mohit.com.daggersample.app.MyApplication;
import mohit.com.daggersample.model.Util;


public class MainActivity extends Activity {

    @BindView(R.id.editTextEmail)
    EditText editTextEmail;

    @BindView(R.id.editTextPassword)
    EditText editTextPassword;


    @BindView(R.id.editTextUrl)
    EditText editTextUrl;


    @BindView(R.id.textView)
    TextView txtResult;

    @Inject
    Util util;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getComponent().inject(this);

    }


    @OnClick({R.id.button, R.id.buttonOne})
    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.button:
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (util.isFieldEmpty(email)) {
                    util.showToast("Please enter the email address");
                    editTextEmail.requestFocus();
                } else if (util.isFieldEmpty(password)) {
                    util.showToast("Please enter the password");
                    editTextPassword.requestFocus();
                } else if (!util.isMailValid(email)) {
                    util.showToast("Please enter valid email address");
                    editTextEmail.requestFocus();
                } else if (!util.isPasswordValid(password)) {
                    util.showToast("Password length must be greater than 8");
                    editTextPassword.requestFocus();
                } else {
                    util.showToast("All Done");
                }
                break;
            case R.id.buttonOne:
                String url = editTextUrl.getText().toString();

                if (util.isUrlValid(url)) {
                    Ion.with(getApplicationContext())
                            .load(url)
                            .asString()
                            .setCallback(new FutureCallback<String>() {
                                @Override
                                public void onCompleted(Exception e, String result) {
                                    if (e == null) {
                                        txtResult.setText(result);
                                    } else {
                                        txtResult.setText(e.toString());
                                    }

                                }
                            });
                } else {
                    util.showToast("Please Enter Correct Url");
                }


                break;
        }


    }


}
