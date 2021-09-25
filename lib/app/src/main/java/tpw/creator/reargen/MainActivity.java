package tpw.creator.reargen;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout mySwipeRefreshLayout;
    boolean initialLoad = true;

    private final static int FILECHOOSER_RESULTCODE = 1;
    private ValueCallback<Uri[]> mUploadMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullScreen fullScreen = new FullScreen();
        if(fullScreen.setFullScreen()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeContainer);
        ConstraintLayout cl = findViewById(R.id.loadingback);

        Context context = mySwipeRefreshLayout.getContext();


        WebView myWebView = (WebView) findViewById(R.id.webview);
        ProgressBar Pbar = findViewById(R.id.progressBar1);
        ImageView imgLogo = findViewById(R.id.logoimage);
        ConstraintLayout noInternetLayout = findViewById(R.id.no_internet);
        Button reloadBtn = findViewById(R.id.outlinedRefreshButton);


        LoadType loadType = new LoadType();

        myWebView.setWebViewClient(new WebViewClient());

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        WebUrl wu = new WebUrl();

        if(loadType.typeofloading() == "02b20154"){
            myWebView.loadUrl(wu.url());
        }else if(loadType.typeofloading() == "08e10294"){
            myWebView.loadUrl("file:///android_asset/index.html");
        }else{
            myWebView.loadUrl("https://github.com/ThirashaPraween/RearGen");
        }



        DetectConnection dc = new DetectConnection();
        if(!dc.checkInternetConnection(this)){
            System.out.println("No Internet Connection");
            noInternetLayout.setVisibility(ConstraintLayout.VISIBLE);
        }else{
            noInternetLayout.setVisibility(ConstraintLayout.GONE);
        }


        ActiveLoading al = new ActiveLoading();
        LoadingImage li = new LoadingImage();
        ActiveRefresh ar = new ActiveRefresh();

        reloadBtn.setOnClickListener(v -> {
            myWebView.reload();
            if(al.isActiveLoadingScreen()){
                mySwipeRefreshLayout.setRefreshing(false);
            }
        });



        if(ar.isActiveRefresh()){
            mySwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            myWebView.reload();
                            if(al.isActiveLoadingScreen()){
                                mySwipeRefreshLayout.setRefreshing(false);
                            }
                        }
                    }

            );
        }else{
            mySwipeRefreshLayout.setRefreshing(false);
            mySwipeRefreshLayout.setEnabled(false);
        }

        myWebView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (myWebView.getScrollY() == 0) {
                    mySwipeRefreshLayout.setEnabled(true);
                } else {
                    mySwipeRefreshLayout.setEnabled(false);
                }
            }
        });

        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {

                if (mUploadMessage != null) {
                    mUploadMessage.onReceiveValue(null);
                }

                mUploadMessage = filePathCallback;

                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("*/*");

                MainActivity.this.startActivityForResult(Intent.createChooser(i, "File Chooser"), MainActivity.FILECHOOSER_RESULTCODE );

                return true;
            }

            public void onProgressChanged(WebView view, int progress)
            {
                if(al.isActiveLoadingScreen()){
                    if(li.getLoadingLogo()){
                        imgLogo.setVisibility(ImageView.VISIBLE);
                    }else{
                        imgLogo.setVisibility(ImageView.GONE);
                    }
                    if(progress < 100 && Pbar.getVisibility() == ProgressBar.GONE){
                        Pbar.setVisibility(ProgressBar.VISIBLE);
                        cl.setVisibility(RelativeLayout.VISIBLE);
                    }
                    Pbar.setProgress(progress);
                    if(progress == 100) {
                        Pbar.setVisibility(ProgressBar.GONE);
                        cl.setVisibility(RelativeLayout.GONE);
                        mySwipeRefreshLayout.setRefreshing(false);
                        initialLoad = false;
                    }
                }else{
                    if(initialLoad){
                        if(li.getLoadingLogo()){
                            imgLogo.setVisibility(ImageView.VISIBLE);
                        }else{
                            imgLogo.setVisibility(ImageView.GONE);
                        }
                        if(progress < 100 && Pbar.getVisibility() == ProgressBar.GONE){
                            Pbar.setVisibility(ProgressBar.VISIBLE);
                            cl.setVisibility(RelativeLayout.VISIBLE);
                        }
                        Pbar.setProgress(progress);
                        if(progress == 100) {
                            Pbar.setVisibility(ProgressBar.GONE);
                            cl.setVisibility(RelativeLayout.GONE);
                            mySwipeRefreshLayout.setRefreshing(false);
                            initialLoad = false;
                        }

                    }else{
                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }

                if(!dc.checkInternetConnection(context)){
                    noInternetLayout.setVisibility(ConstraintLayout.VISIBLE);
                }else{
                    noInternetLayout.setVisibility(ConstraintLayout.GONE);
                }



            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {


        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == FILECHOOSER_RESULTCODE) {

            if (null == mUploadMessage || intent == null || resultCode != RESULT_OK) {
                return;
            }

            Uri[] result = null;
            String dataString = intent.getDataString();

            if (dataString != null) {
                result = new Uri[]{Uri.parse(dataString)};
            }

            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        }
    }

    @Override
    public void onBackPressed() {
        WebView myWebView = (WebView) findViewById(R.id.webview);
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}