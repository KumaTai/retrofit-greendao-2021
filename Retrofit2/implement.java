...
//實作範例 - login flow

public class EmailLoginFragment extends Fragment{

...
    
    private void login(String account, String password) {
        
        ...

        mLoginSubscription = mService.login(account, password)
                .flatMap(login -> {
                    boolean isSuccess = login.getStatus().equals("1");
                    if (isSuccess) {
                        LoginInfo info = login.getContent();
                        if (info == null) {
                            return Observable.just(0l);
                        } else {
                            return Observable.just(userId);
                        }
                    } else {
                        return Observable.just(0l);
                    }
                })
                .flatMap(uId -> fetchUser(uId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        //do something
                    }

                    @Override
                    public void onError(Throwable e) {
                        //do something
                    }

                    @Override
                    public void onNext(Long userId) {
                        //do something
                    }
                });
    }

    private Observable<Long> fetchUser(long userId) {
        if (userId > 0) {
            return UserHandler.fetchUser(getContext(), userId)
                    .flatMap(user -> Observable.just(userId));
        } else {
            return Observable.just(userId);
        }
    }

}