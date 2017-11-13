package com.invoke.api.acl;


import com.invoke.model.api.ApiUser;

import java.util.List;

/**
 * @author sunder
 */
public interface ApiService {
    List<ApiUser> getApiUserList(String status);
}

