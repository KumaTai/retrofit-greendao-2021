...
import xx.golife.pojo.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface UserMetadata {
    @FormUrlEncoded
    @POST("oauth/login")
    Observable<Login> login(@Field("account") String account,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("oauth/resetPass")
    Observable<Common> resetPass(@Field("account") String account,
                                 @Field("password") String password);

    @FormUrlEncoded
    @POST("user/getUser")
    Observable<User> getUser(@Field("userid") Long userId);
}
