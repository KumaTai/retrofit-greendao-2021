...
//使用到了retrofit2和rxjava的寫法
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

public class GoLifeBioService {
    private static GoLifeBioService instance;
    private ServiceConfig config;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private Gson gson;

    public static synchronized GoLifeBioService getInstance() {
        if (instance == null) {
            instance = new GoLifeBioService();
        }
        return instance;
    }

    public GoLifeBioService() {
        config = ServiceConfig.getInstance();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws
                            IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("key", "value")
                                .addHeader("HEADER", "HEADER Value")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(logging)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(config.getGoLifeBiologicUri())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        gson = new Gson();
    }

    public void updateConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(config.getGoLifeBiologicUri())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public Observable<Login> login(String account, String password) {
        return retrofit.create(UserMetadata.class).login(account, password).subscribeOn(Schedulers.io());
    }

    public Observable<User> getUser(long userId) {
        return retrofit.create(UserMetadata.class).getUser(userId).subscribeOn(Schedulers.io());
    }
