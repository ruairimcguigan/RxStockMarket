package market.stock.demo.rx.rxstockmarket.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import market.stock.demo.rx.rxstockmarket.utils.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YahooServiceGeneratorFactory {

    private String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22YHOO%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeysd";

    // note: advisable to turn off logging for production applications to get better performance
    HttpLoggingInterceptor interceptor
            = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

   // OkHttp client that the Retrofit will use
   OkHttpClient client
           = new OkHttpClient.Builder().addInterceptor(interceptor).build();


    Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build();

    /**
     * This call will take the interface that we have created and turn it into a
     * fully-functioning object using a bit of Java Reflection magic and proxies.
     * @return
     */
    public YahooService create(){
        return retrofit.create(YahooService.class);
    }
}
