package com.monitor.mapper.scheduling;

import com.cloud.core.Mapper;
import com.monitor.model.scheduling.PanoramicScheduling;
import org.springframework.stereotype.Repository;

/**
 * @author summer
 */
@Repository("panoramicSchedulingMapper")
public interface PanoramicSchedulingMapper extends Mapper<PanoramicScheduling> {
}