package com.panoramic.user.acl.permission;

import com.cloud.core.AbstractService;
import com.panoramic.user.acl.PanoramicPermissionService;
import com.panoramic.user.entity.PanoramicPermission;
import com.panoramic.user.mapper.PanoramicPermissionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 *sunmer
 * 2017/11/08.
 */
@Service
@Transactional
public class PanoramicPermissionServiceImpl extends AbstractService<PanoramicPermission> implements PanoramicPermissionService {
    @Resource
    private PanoramicPermissionMapper panoramicPermissionMapper;

}
