# lab5-1-ImplicitIntentDemo
## Description: 
lab5-1-ImplicitIntentDemo
## Core code:
```
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        btn_referto=(Button) findViewById(R.id.btn_referto);
        editText_url=(EditText) findViewById(R.id.editText_url);
        btn_referto.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_referto:
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(editText_url.getText().toString()));
                startActivity(Intent.createChooser(intent, "请选择浏览器"));
                break;
        }
    }
    
    <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="http" />
                <data android:scheme="https" />
            </intent-filter>
            
     web_url = findViewById(R.id.web_url);
        webshow = findViewById(R.id.webshow);
        String ureferToUrl = getIntent().getData().toString();
        web_url.setText(ureferToUrl);
        webshow.getSettings().setJavaScriptEnabled(true);
        webshow.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webshow.getSettings().setSupportMultipleWindows(true);
        webshow.getSettings().setBuiltInZoomControls(true);
        webshow.setWebViewClient(new WebViewClient());
        webshow.setWebChromeClient(new WebChromeClient());
        webshow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("browser","motionEvent:" + motionEvent.toString());
                return false;
            }
        });
        webshow.loadUrl(ureferToUrl);

        search_url = findViewById(R.id.search_url);
        search_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = web_url.getText().toString();
                Log.d("browser","url:" + url);      //获取用户输入的网址
                webshow.getSettings().setJavaScriptEnabled(true);
                webshow.loadUrl(url);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_SEARCH || keyCode == KeyEvent.KEYCODE_ENTER){
            String url = web_url.getText().toString();
            Log.d("browser", "url:" + url);
            webshow.getSettings().setJavaScriptEnabled(true);
            webshow.loadUrl(url);
        }
        if((keyCode == KeyEvent.KEYCODE_BACK) && webshow.canGoBack()) {
            webshow.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
```
## Screenshots:<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/lab5-1-ImplicitIntentDemo/blob/master/images/main.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/lab5-1-ImplicitIntentDemo/blob/master/images/referChoose.PNG)<br>
![This picture is stored in the folder of images.](https://github.com/huhuhuu/lab5-1-ImplicitIntentDemo/blob/master/images/myWebview.PNG)<br>
