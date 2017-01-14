package cn.refactor.lib.colordialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

/**
 * Created by 没心没肺的小卷羊 on 2017/1/14.
 */

public class MyDialog extends Dialog {

    private View mDialogView;

    private AnimationSet mAnimIn, mAnimOut;
    private boolean mIsShowAnim;

    public MyDialog(Context context) {
        this(context, 0);
    }

    public MyDialog(Context context, int theme) {
        super(context, R.style.color_dialog);
        init();
    }

    private void callDismiss() {
        super.dismiss();
    }

    private void init() {
        mAnimIn = AnimationLoader.getInAnimation(getContext());
        mAnimOut = AnimationLoader.getOutAnimation(getContext());
        initAnimListener();
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getContext().getText(titleId));
    }


    public MyDialog(Context context, View view) {
        this(context, 0);
        this.view = view;
    }

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = view;
        setContentView(contentView);
        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startWithAnimation(mIsShowAnim);
    }

    @Override
    public void dismiss() {
        dismissWithAnimation(mIsShowAnim);
    }

    private void startWithAnimation(boolean showInAnimation) {
        if (showInAnimation) {
            mDialogView.startAnimation(mAnimIn);
        }
    }

    private void dismissWithAnimation(boolean showOutAnimation) {
        if (showOutAnimation) {
            mDialogView.startAnimation(mAnimOut);
        } else {
            super.dismiss();
        }
    }

    private void initAnimListener() {
        mAnimOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        callDismiss();
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public MyDialog setAnimationEnable(boolean enable) {
        mIsShowAnim = enable;
        return this;
    }

    public MyDialog setAnimationIn(AnimationSet animIn) {
        mAnimIn = animIn;
        return this;
    }

    public MyDialog setAnimationOut(AnimationSet animOut) {
        mAnimOut = animOut;
        initAnimListener();
        return this;
    }
}
