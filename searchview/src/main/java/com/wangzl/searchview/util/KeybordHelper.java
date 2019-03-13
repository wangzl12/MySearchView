package com.wangzl.searchview.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author wangzl
 * @Date 2019/3/8 16:55
 * @Description TODO
 */
public class KeybordHelper {
    static KeybordHelper instance;

    private KeybordHelper() {
        // construct
    }

    public static KeybordHelper getInstance() {
        if (instance == null) {
            instance = new KeybordHelper();
        }
        return instance;
    }

    /**
     * 弹起软键盘
     *
     * @param editText
     */
    public void openKeyBoard(final Context context, final EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager imm =
                        (InputMethodManager)
                                context
                                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, 0);
                editText.setSelection(editText.getText().length());
            }
        }, 200);


    }

    /**
     * 隐藏软键盘
     *
     * @param editText
     */
    public void hideKeyBoard(Context context, EditText editText) {
        InputMethodManager imm =
                (InputMethodManager)
                        context
                                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }


    public static void searchPoint(Context context,EditText editText){
        InputMethodManager mInputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        editText.findFocus();
        mInputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
    }

    public static void losePoint(Context context,EditText editText){
        InputMethodManager mInputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        editText.setFocusable(false);
        if (mInputMethodManager.isActive()) {
            mInputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

}
