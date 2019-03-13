# MySearchView
MySearchView

带搜索功能的滚动输入框

# 添加依赖

项目根目录的build.gradle添加
```
buildscript {
    
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

app模块下添加依赖

```
	dependencies {
	        implementation 'com.github.wangzl12:MySearchView:v1.0'
	}
```

# 使用方法
## 1.布局文件中
```
<com.wangzl.searchview.view.MySerachView
        android:id="@+id/my_search_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
## 2.类文件中
```
public class MainActivity extends AppCompatActivity {
    private MySerachView mySerachView;
    private List<String> mOptionsItems = new ArrayList<>();//传给view的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySerachView =  findViewById(R.id.my_search_view);

        mOptionsItems.add("简书-创作你的创作1");
        mOptionsItems.add("双肩包刷金宝2");
        mOptionsItems.add("简书-创作你的创作3");
        mOptionsItems.add("item34");
        mOptionsItems.add("简书-创作你的创作5");
        mOptionsItems.add("item56");
        mOptionsItems.add("简书-创作你的创作7");
        mOptionsItems.add("item7");
        mOptionsItems.add("简书-创作你的创作");
        mOptionsItems.add("item9");
        mOptionsItems.add("简书-创作你的创作");
        mOptionsItems.add("item11");

        mySerachView.setData(mOptionsItems); //给view设置数据
        mySerachView.invalidate();   //刷新view


        mySerachView.setOnClickListenerOnSearch(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chooseStr = mySerachView.chooseData(); //获得输入或选中的数据
                Toast.makeText(MainActivity.this,chooseStr+"",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
```
