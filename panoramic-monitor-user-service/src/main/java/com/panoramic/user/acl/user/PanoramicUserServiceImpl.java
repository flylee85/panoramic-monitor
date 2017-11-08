package com.panoramic.user.acl.user;

import com.cloud.core.AbstractService;
import com.panoramic.user.acl.PanoramicUserService;
import com.panoramic.user.entity.PanoramicUser;
import com.panoramic.user.mapper.PanoramicUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by @author sunder on 2017/11/07.
 */
@Service
@Transactional
public class PanoramicUserServiceImpl extends AbstractService<PanoramicUser> implements PanoramicUserService {
    @Resource
    private PanoramicUserMapper panoramicUserMapper;

}
