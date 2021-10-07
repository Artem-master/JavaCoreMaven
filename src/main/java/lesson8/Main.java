package lesson8;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/1day/294021")
                .addQueryParameter("apikey", "jGMDtb9ACqoArbzunistwONsLYYfxV7u")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String respBody = response.body().string();

        System.out.println(response.isSuccessful());
        System.out.println(response.code());
        System.out.println(respBody);
    }
}
