package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button start_btn,q1_btn,q2_btn,q3_btn,q4_btn,q5_btn,q6_btn,q7_btn,q8_btn,q9_btn,q10_btn,q11_btn,q12_btn,finish_btn,again_btn;
    private EditText edit;
    private CheckBox check_wel;
    private RadioGroup radioGroup_q1,radioGroup_q2,radioGroup_q3,radioGroup_q7,radioGroup_q8,radioGroup_q9,radioGroup_q10,radioGroup_q11,radioGroup_q12;
    private List<CheckBox> list_q4=new ArrayList<CheckBox>();
    private List<CheckBox> list_q5=new ArrayList<CheckBox>();
    private CharSequence str_q1,str_q2,str_q3,str_q7,str_q8,str_q9,str_q10,str_q11,str_q12;
    private String str_q4,str_q5,str_q6;
    private TextView answer_q1,answer_q2,answer_q3,answer_q4,answer_q5,answer_q6,answer_q7,answer_q8,answer_q9,answer_q10,answer_q11,answer_q12;
    private int access=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }
    public void Click_wel(View view){
        check_wel=findViewById(R.id.welcome);
        if(check_wel.isChecked()) setContentView(R.layout.question_one);
        else{
            Toast.makeText(this,"Please check it",Toast.LENGTH_LONG).show();
        }
    }
    public void Click_q1(View view){
        //访问次数+1
        access++;
        int flag=0;
        radioGroup_q1=findViewById(R.id.q1);
        if(radioGroup_q1.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q1=findViewById(radioGroup_q1.getCheckedRadioButtonId());
            str_q1=radioButton_q1.getText();
            setContentView(R.layout.question_two);
        }
    }
    public void Click_q2(View view){
        radioGroup_q2=findViewById(R.id.q2);
        if(radioGroup_q2.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q2=findViewById(radioGroup_q2.getCheckedRadioButtonId());
            str_q2=radioButton_q2.getText();
            setContentView(R.layout.question_three);
        }
    }
    public void Click_q3(View view){
        radioGroup_q3=findViewById(R.id.q3);
        if(radioGroup_q3.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q3=findViewById(radioGroup_q3.getCheckedRadioButtonId());
            str_q3=radioButton_q3.getText();
            setContentView(R.layout.question_four);
        }
    }
    public void Click_q4(View view){
        int flag=0;
        list_q4.add((CheckBox)findViewById(R.id.q4_1));
        list_q4.add((CheckBox)findViewById(R.id.q4_2));
        list_q4.add((CheckBox)findViewById(R.id.q4_3));
        list_q4.add((CheckBox)findViewById(R.id.q4_4));
        list_q4.add((CheckBox)findViewById(R.id.q4_5));
        list_q4.add((CheckBox)findViewById(R.id.q4_6));
        list_q4.add((CheckBox)findViewById(R.id.q4_7));
        for(CheckBox checkBox:list_q4){
            if(checkBox.isChecked())
            {
                if(checkBox.getText().toString().indexOf("Bussiness")>-1)checkBox.setText("Bussiness functions");
                if(checkBox.getText().toString().indexOf("Data")>-1)checkBox.setText("Data functions");
                flag=1;
            }
//            if(checkBox.getText().toString().indexOf("Business")>0)checkBox.setText("Business functions");
//            if(checkBox.getText().toString().indexOf("Data")>0)checkBox.setText("Data functions");
        }
        if(flag==0){
            Toast.makeText(this,"Please choose at least one",Toast.LENGTH_LONG).show();
        }
        else{
            str_q4="";
            for(CheckBox checkBox :list_q4){
                if(checkBox.isChecked()){
                    str_q4=str_q4+checkBox.getText()+",";
                }
            }
            setContentView(R.layout.question_five);
        }
    }
    public void Click_q5(View view){
        int flag=0;
        list_q5.add((CheckBox)findViewById(R.id.q5_1));
        list_q5.add((CheckBox)findViewById(R.id.q5_2));
        list_q5.add((CheckBox)findViewById(R.id.q5_3));
        list_q5.add((CheckBox)findViewById(R.id.q5_4));
        list_q5.add((CheckBox)findViewById(R.id.q5_5));
        list_q5.add((CheckBox)findViewById(R.id.q5_6));
        list_q5.add((CheckBox)findViewById(R.id.q5_7));
        for(CheckBox checkBox:list_q5){
            if(checkBox.isChecked()){
                if(checkBox.getText().toString().indexOf("Bussiness")>-1)checkBox.setText("Bussiness functions");
                if(checkBox.getText().toString().indexOf("Data")>-1)checkBox.setText("Data functions");
                flag=1;
            }
        }
        if(flag==0){
            Toast.makeText(this,"Please choose at least one",Toast.LENGTH_LONG).show();
        }
        else{
            str_q5="";
            for(CheckBox checkBox :list_q5){
                if(checkBox.isChecked()){
                    str_q5=str_q5+checkBox.getText()+",";
                }
            }
            setContentView(R.layout.question_six);
        }
    }
    public void Click_q6(View view){
        edit = (EditText) findViewById(R.id.q6_edit);
        str_q6=edit.getText().toString();
        setContentView(R.layout.question_seven);
    }
    public void Click_q7(View view){
        radioGroup_q7=findViewById(R.id.q7);
        if(radioGroup_q7.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q7=findViewById(radioGroup_q7.getCheckedRadioButtonId());
            str_q7=radioButton_q7.getText();
            setContentView(R.layout.question_eight);
        }
    }
    public void Click_q8(View view){
        radioGroup_q8=findViewById(R.id.q8);
        if(radioGroup_q8.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q8=findViewById(radioGroup_q8.getCheckedRadioButtonId());
            str_q8=radioButton_q8.getText();
            setContentView(R.layout.question_nine);
        }
    }
    public void Click_q9(View view){
        radioGroup_q9=findViewById(R.id.q9);
        if(radioGroup_q9.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q9=findViewById(radioGroup_q9.getCheckedRadioButtonId());
            str_q9=radioButton_q9.getText();
            setContentView(R.layout.question_ten);
        }
    }
    public void Click_q10(View view){
        radioGroup_q10=findViewById(R.id.q10);
        if(radioGroup_q10.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q10=findViewById(radioGroup_q10.getCheckedRadioButtonId());
            str_q10=radioButton_q10.getText();
            setContentView(R.layout.question_eleven);
        }
    }
    public void Click_q11(View view){
        radioGroup_q11=findViewById(R.id.q11);
        if(radioGroup_q11.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q11=findViewById(radioGroup_q11.getCheckedRadioButtonId());
            str_q11=radioButton_q11.getText();
            setContentView(R.layout.question_twelve);
        }
    }
    public void Click_q12(View view){
        radioGroup_q12=findViewById(R.id.q12);
        if(radioGroup_q12.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please choose one",Toast.LENGTH_LONG).show();
        }
        else{
            RadioButton radioButton_q12=findViewById(radioGroup_q12.getCheckedRadioButtonId());
            str_q12=radioButton_q12.getText();
            setContentView(R.layout.finish_survey);
        }
    }
    public void Click_finish(View view){
        setContentView(R.layout.report);
        answer_q1=findViewById(R.id.answer_q1);
        answer_q2=findViewById(R.id.answer_q2);
        answer_q3=findViewById(R.id.answer_q3);
        answer_q4=findViewById(R.id.answer_q4);
        answer_q5=findViewById(R.id.answer_q5);
        answer_q6=findViewById(R.id.answer_q6);
        answer_q7=findViewById(R.id.answer_q7);
        answer_q8=findViewById(R.id.answer_q8);
        answer_q9=findViewById(R.id.answer_q9);
        answer_q10=findViewById(R.id.answer_q10);
        answer_q11=findViewById(R.id.answer_q11);
        answer_q12=findViewById(R.id.answer_q12);
        answer_q1.setText(str_q1);
        answer_q2.setText(str_q2);
        answer_q3.setText(str_q3);
        answer_q4.setText(str_q4);
        answer_q5.setText(str_q5);
        answer_q6.setText(str_q6);
        answer_q7.setText(str_q7);
        answer_q8.setText(str_q8);
        answer_q9.setText(str_q9);
        answer_q10.setText(str_q10);
        answer_q11.setText(str_q11);
        answer_q12.setText(str_q12);
    }
    public void Click_again(View view){
        for(CheckBox checkBox :list_q4) {
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
            }
        }
        for(CheckBox checkBox :list_q5) {
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
            }
        }
        setContentView(R.layout.question_one);
    }
    public void Click_save2sdk(View view){
        /*
         *保存在SD卡上
         */
        File sdFile=getExternalFilesDir(null);
        File saveData=new File(sdFile,"data_"+access+".json");
//        String str=getExternalFilesDir(null).getAbsolutePath();
        try {
            FileOutputStream out=new FileOutputStream(saveData);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("question_1", str_q1);
            jsonObject.put("question_2", str_q2);
            jsonObject.put("question_3", str_q3);
            jsonObject.put("question_4", str_q4);
            jsonObject.put("question_5", str_q5);
            jsonObject.put("question_6", str_q6);
            jsonObject.put("question_7", str_q7);
            jsonObject.put("question_8", str_q8);
            jsonObject.put("question_9", str_q9);
            jsonObject.put("question_10", str_q10);
            jsonObject.put("question_11", str_q11);
            jsonObject.put("question_12", str_q12);
            String json = jsonObject.toString();
            out.write(json.getBytes());
            out.flush();
            out.close();
            Toast.makeText(this,"Saved successfully",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    public void Click_save2app(View view){
        /*
         *保存在app上
         */
        File appDir = new File(Environment.getDataDirectory() + "/data/mg.studio.android.survey");
        File saveData=new File(appDir,"data_"+access+".json");
//        String str=getExternalFilesDir(null).getAbsolutePath();
        try {
            FileOutputStream out=new FileOutputStream(saveData);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("question_1", str_q1);
            jsonObject.put("question_2", str_q2);
            jsonObject.put("question_3", str_q3);
            jsonObject.put("question_4", str_q4);
            jsonObject.put("question_5", str_q5);
            jsonObject.put("question_6", str_q6);
            jsonObject.put("question_7", str_q7);
            jsonObject.put("question_8", str_q8);
            jsonObject.put("question_9", str_q9);
            jsonObject.put("question_10", str_q10);
            jsonObject.put("question_11", str_q11);
            jsonObject.put("question_12", str_q12);
            String json = jsonObject.toString();
            out.write(json.getBytes());
            out.flush();
            out.close();
            Toast.makeText(this,"Saved successfully",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
