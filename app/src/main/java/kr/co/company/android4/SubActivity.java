package kr.co.company.android4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends Activity {
    EditText edit;    //edit 변수 설정
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);         //sub.xml과 연결
        edit = (EditText)findViewById(R.id.edit);
        Button button_ok = (Button)findViewById(R.id.button_ok);
        //button_ok 버튼 클릭 이벤트 함수
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", edit.getText().toString()); //문장을 넣어준다.
                setResult(RESULT_OK, intent);  //결과 설정
                finish();
            }
        });
        //button_cancel 버튼 클릭 이벤트 함수
        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);  //결과 설정
                finish();
            }
        });

    }

}

