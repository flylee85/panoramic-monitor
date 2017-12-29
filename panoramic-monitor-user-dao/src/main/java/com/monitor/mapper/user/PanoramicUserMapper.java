package com.monitor.mapper.user;


import com.cloud.core.Mapper;
import com.monitor.dto.user.PanoramicUserInfo;
import com.monitor.model.user.PanoramicUser;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface PanoramicUserMapper extends Mapper<PanoramicUser> {
	
    @Select("select login_name as loginname,head_url as headurl,email,password from panoramic_user where login_name = #{login_name}")
    PanoramicUserInfo findByUser(@Param("login_name") String login_name);
}