package com.monitor.api.acl;


import com.monitor.model.api.ApiUser;

import java.util.List;

/**
 * @author sunder
 */
public interface ApiService {
    List<ApiUser> getApiUserList(String status);
}

