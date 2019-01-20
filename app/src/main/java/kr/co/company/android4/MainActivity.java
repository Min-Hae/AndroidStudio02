/////////// 서브액티비티로부터 문자열 반환받기////////////
package kr.co.company.android4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    static final int GET_STRING = 1;   //변수 설정
    TextView text;                       //text 변수 설정
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);  //activity_main.xml과 연결
        Button button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        //버튼 클릭 이벤트 함수
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //인텐트로 메인액티비티와 서브액티비티를 연결
                Intent in = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(in, GET_STRING);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //만약 requestCode 값과 GET_STRING 값이 같고
        if(requestCode == GET_STRING){
            //resultCode 값과 RESULT_OK값이 같으면
            if(resultCode == RESULT_OK){
                text.setText(data.getStringExtra("INPUT_TEXT")); //문장을 설정한다.
            }
        }
    }


}
