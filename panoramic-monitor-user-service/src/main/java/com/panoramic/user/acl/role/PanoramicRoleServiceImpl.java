package com.panoramic.user.acl.role;

import com.cloud.core.AbstractService;
import com.panoramic.user.acl.PanoramicRoleService;
import com.panoramic.user.entity.PanoramicRole;
import com.panoramic.user.mapper.PanoramicRoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author sunder
 * on 2017/11/06.
 */
@Service("panoramicRoleService")
@Transactional
public class PanoramicRoleServiceImpl extends AbstractService<PanoramicRole> implements PanoramicRoleService {
    @Resource
    private PanoramicRoleMapper panoramicRoleMapper;

}
