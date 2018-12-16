package kr.tjit.a20181216_02_loginsingup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class SignUpActivity extends BaseActivity {

    CheckBox allCheckBox;
    CheckBox moneyCheckBox;
    CheckBox agreementCheckBox;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allCheckBox.isChecked() && moneyCheckBox.isChecked() && agreementCheckBox.isChecked()) {
                    //다음화면으로 이동해야 함

                    Log.d("약관동의", "모두 동의해야 함.");

                    Intent intent = new Intent(mContext, SignUpStep2Activity.class);
                    startActivity(intent);

                }
                else {
                    //사용자에게 모두 동의하셔야 가입이 가능합니다. 안내메시지.
                    //Toast를 이용

                    Toast.makeText(mContext, "모두 동의하셔야 가입이 가능합니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        allCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //isChecked : true => 눌리는 상황
                //isChecked : false => 해제되는 상황
                if (isChecked) {
                    //전체동의가 눌렸다면 해야되는 일
                    moneyCheckBox.setChecked(true);
                    agreementCheckBox.setChecked(true);
                }
                else {
                    //전체동의가 해제되면 해야되는 일
                    moneyCheckBox.setChecked(false);
                    agreementCheckBox.setChecked(false);
                }
            }

        });




    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        allCheckBox = findViewById(R.id.allCheckBox);
        moneyCheckBox = findViewById(R.id.moneyCheckBox);
        agreementCheckBox = findViewById(R.id.agreementCheckBox);
        nextBtn = findViewById(R.id.nextBtn);




    }
}
