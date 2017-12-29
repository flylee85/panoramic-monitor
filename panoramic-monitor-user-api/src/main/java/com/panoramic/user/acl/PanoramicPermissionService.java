package com.panoramic.user.acl;


import org.springframework.transaction.annotation.Transactional;

import com.cloud.core.Service;
import com.cloud.core.ServiceException;
import com.monitor.model.permission.PanoramicPermission;

/**
*@author summer
* 2017/11/08.
*/

@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public interface PanoramicPermissionService extends Service<PanoramicPermission> {

}
