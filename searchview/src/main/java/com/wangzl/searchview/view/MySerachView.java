package com.wangzl.searchview.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.wangzl.searchview.util.KeybordHelper;
import com.wangzl.searchview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangzl
 * @Date 2019/3/12 18:03
 * @Description TODO
 */
public class MySerachView extends FrameLayout {
    private WheelView myWheelView;
    private EditText etChoose;
    private ImageView mySearchImg;
    private Context context;
    private String editStr;
    private List<String> mOptionsItems = new ArrayList<>();

    public MySerachView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public MySerachView init() {
        LayoutInflater.from(getContext()).inflate(R.layout.my_search_view, this, true);
        myWheelView = findViewById(R.id.my_wheelview);
        etChoose = findViewById(R.id.et_choose);
        mySearchImg = findViewById(R.id.iv_search);
        KeybordHelper.getInstance().losePoint(context, etChoose);
        initViews();
        etChoose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                KeybordHelper.getInstance().searchPoint(context, etChoose);
            }
        });
        mySearchImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                KeybordHelper.getInstance().losePoint(context, etChoose);
                if (TextUtils.isEmpty(etChoose.getText().toString().trim())) {
                    editStr = mOptionsItems.get(myWheelView.getCurrentItem());
                } else {
                    editStr = etChoose.getText().toString().trim();
                }
                //TODO 在此执行需要查询的操作及跳转
//                Toast.makeText(context, editStr, Toast.LENGTH_SHORT).show();
                if (null != searchListener) {
                    searchListener.onClick(v);
                }
            }
        });
        return this;
    }

    private void initViews() {
        myWheelView.setCyclic(false);
        myWheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        myWheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                etChoose.setText(mOptionsItems.get(index));
                etChoose.setTextColor(getResources().getColor(R.color.finacial_text_title_color));
            }
        });

        myWheelView.setDividerColor(R.color.viewfinder_laser);
        myWheelView.setCurrentItem(5);
        myWheelView.setTextSize(20);

        myWheelView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                KeybordHelper.getInstance().losePoint(context, etChoose);
                return false;
            }
        });


        etChoose.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    etChoose.setHint(getResources().getString(R.string.input_you_want));
                    etChoose.setBackgroundResource(R.drawable.selected_edittext_bg);
                } else {
                    etChoose.setHint(getResources().getString(R.string.input_you_want));
                    etChoose.setBackgroundResource(R.drawable.unselected_edittext_bg);
                }
            }
        });
    }

    public void setData(List<String> optionsItems) {
        mOptionsItems = optionsItems;
        init();
    }

    private View.OnClickListener searchListener;

    public void setOnClickListenerOnSearch(View.OnClickListener searchListener) {
        this.searchListener = searchListener;
    }

    public String chooseData() {
        return editStr;
    }
}
