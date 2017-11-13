package com.invoke.api.acl;


import com.invoke.model.api.ApiUser;


public interface ApiMobileService {

    boolean isPartner(Long partnerid);

    void initApiUserList();

    ApiUser getApiUserByAppkey(String appkey);
}
