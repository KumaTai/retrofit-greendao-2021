...
// GreenDAO pojo example
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBUserProfile {
    @Id
    Long _id;
    @NotNull
    Long userId;
    @NotNull
    String account;
    String email;
    int bindPermission;
    String name;
    float height;
    float weight;
    int stride;
    int gender;
    Long birthday;
    String photoUrl;
    @Generated(hash = 1123190118)
    public DBUserProfile(Long _id, @NotNull Long userId, @NotNull String account,
            String email, int bindPermission, String name, float height,
            float weight, int stride, int gender, Long birthday, String photoUrl) {
        this._id = _id;
        this.userId = userId;
        this.account = account;
        this.email = email;
        this.bindPermission = bindPermission;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.stride = stride;
        this.gender = gender;
        this.birthday = birthday;
        this.photoUrl = photoUrl;
    }
    @Generated(hash = 627633719)
    public DBUserProfile() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getBindPermission() {
        return this.bindPermission;
    }
    public void setBindPermission(int bindPermission) {
        this.bindPermission = bindPermission;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getHeight() {
        return this.height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public float getWeight() {
        return this.weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getStride() {
        return this.stride;
    }
    public void setStride(int stride) {
        this.stride = stride;
    }
    public int getGender() {
        return this.gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public Long getBirthday() {
        return this.birthday;
    }
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }
    public String getPhotoUrl() {
        return this.photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

}
