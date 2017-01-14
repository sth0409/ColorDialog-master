package cn.refactor.sample.colordialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.refactor.lib.colordialog.ColorDialog;
import cn.refactor.lib.colordialog.MyDialog;
import cn.refactor.lib.colordialog.PromptDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPromptDialog(View view) {
        showPromptDlg();
    }


    public void show(View view) {
        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.aaaaa, null);
        MyDialog testDialog=new MyDialog(this,view1);
        testDialog.setAnimationEnable(true);
        testDialog.show();
    }


    private void showPromptDlg() {
        new PromptDialog(this)
                .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                .setAnimationEnable(true)
                .setTitleText(getString(R.string.success))
                .setContentText(getString(R.string.text_data))
                .setPositiveListener(getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog dialog) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void showTextDialog(View view) {
        PromptDialog promptDialog = new PromptDialog(this);

        ColorDialog dialog = new ColorDialog(this);
        dialog.setColor("#8ECB54");
        dialog.setAnimationEnable(true);
        //dialog.setTitle(getString(R.string.operation));
        TextView textView = new TextView(this);
        textView.setText("21324576as4dasdasd");
        TextView textView1 = new TextView(this);
        textView1.setText("21324576as4das斯蒂芬斯蒂芬角色等级开放和三等奖dasd");
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(textView);
        linearLayout.addView(textView1);
        View contentView = View.inflate(this, R.layout.aaaaa, null);
        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.aaaaa, null);
        promptDialog.setContentView(view1);
        dialog.setPositiveListener(getString(R.string.text_iknow), new ColorDialog.OnPositiveListener() {
            @Override
            public void onClick(ColorDialog dialog) {
                Toast.makeText(MainActivity.this, dialog.getPositiveText().toString(), Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    public void showPicDialog(View v) {
        ColorDialog dialog = new ColorDialog(this);
        dialog.setTitle(getString(R.string.operation));
        dialog.setAnimationEnable(true);
        dialog.setAnimationIn(getInAnimationTest(this));
        dialog.setAnimationOut(getOutAnimationTest(this));
        dialog.setContentImage(getResources().getDrawable(R.mipmap.sample_img));
        dialog.setPositiveListener(getString(R.string.delete), new ColorDialog.OnPositiveListener() {
            @Override
            public void onClick(ColorDialog dialog) {
                Toast.makeText(MainActivity.this, dialog.getPositiveText().toString(), Toast.LENGTH_SHORT).show();
            }
        })
                .setNegativeListener(getString(R.string.cancel), new ColorDialog.OnNegativeListener() {
                    @Override
                    public void onClick(ColorDialog dialog) {
                        Toast.makeText(MainActivity.this, dialog.getNegativeText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).show();
    }

    public void showAllModeDialog(View view) {
        ColorDialog dialog = new ColorDialog(this);
        dialog.setTitle(getString(R.string.operation));
        dialog.setAnimationEnable(true);
        dialog.setContentText(getString(R.string.content_text));
        dialog.setContentImage(getResources().getDrawable(R.mipmap.sample_img));
        dialog.setPositiveListener(getString(R.string.delete), new ColorDialog.OnPositiveListener() {
            @Override
            public void onClick(ColorDialog dialog) {
                Toast.makeText(MainActivity.this, dialog.getPositiveText().toString(), Toast.LENGTH_SHORT).show();
            }
        })
                .setNegativeListener(getString(R.string.cancel), new ColorDialog.OnNegativeListener() {
                    @Override
                    public void onClick(ColorDialog dialog) {
                        Toast.makeText(MainActivity.this, dialog.getNegativeText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).show();
    }

    public static AnimationSet getInAnimationTest(Context context) {
        AnimationSet out = new AnimationSet(context, null);
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(150);
        ScaleAnimation scale = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(150);
        out.addAnimation(alpha);
        out.addAnimation(scale);
        return out;
    }

    public static AnimationSet getOutAnimationTest(Context context) {
        AnimationSet out = new AnimationSet(context, null);
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(150);
        ScaleAnimation scale = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(150);
        out.addAnimation(alpha);
        out.addAnimation(scale);
        return out;
    }
}
