package com.monitor.mapper.permission;


import com.cloud.core.Mapper;
import com.monitor.model.permission.PanoramicPermission;

import org.springframework.stereotype.Repository;

@Repository("permissionMapper")
public interface PanoramicPermissionMapper extends Mapper<PanoramicPermission> {
}