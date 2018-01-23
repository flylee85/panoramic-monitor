package com.monitor.mapper.productofflinemeasurement;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.cloud.core.Mapper;
import com.monitor.model.productofflinemeasurement.PanoramicProductOfflineMeasurement;

/**
 * 
 * @author gang
 *
 */
@Repository("productOfflineMeasurementMapper")
public interface PanoramicProductOfflineMeasurementMapper extends Mapper<PanoramicProductOfflineMeasurement> {
	

    /**
     * 查询当前产品下线
     * @return
     */
    @Select("SELECT\n" + 
    		"	code,name\n" + 
    		"FROM\n" + 
    		"	panoramic_product_offline_measurement\n" + 
    		"WHERE\n" + 
    		" delete_flag = 1\n" + 
    		"AND f_id = 2\n" +
    		"GROUP BY code,name" +
    		"")
    List<PanoramicProductOfflineMeasurement> listProductOfflineCategory();
    
    /**
     * 时间段内数据统计
     * @param code
     * @param dateBefore
     * @param dateEnd
     * @return
     */
    PanoramicProductOfflineMeasurement selectSummaryConsumptionByCondition(
    		@Param("code") String code,
    		@Param("dateBefore") String dateBefore,
    		@Param("dateEnd") String dateEnd);
}