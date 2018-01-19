package com.monitor.mapper.sparepartsmaterials;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.monitor.model.sparepartsmaterials.PanoramicSparePartsMaterials;

/**
 * @author xuegang
 */
@Repository("sparePartsMaterialsMapper")
public interface PanoramicSparePartsMaterialsMapper extends Mapper<PanoramicSparePartsMaterials> {
	
	/**
	 * 指定时间的备品备件库存值
	 * @param date
	 * @param nextdate
	 * @return
	 */
	@Select("SELECT\n" + 
			"	sum(inventory_value) as inventoryValue\n" + 
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND ctime >= #{date}\n" +
			"AND ctime <  #{nextdate}"
			)
	PanoramicSparePartsMaterials getSummaryByDate(@Param("date") Timestamp date, @Param("nextdate") Timestamp nextdate);
	
	/**
	 * 指定时间的备品备件库存明细内容
	 * @param date
	 * @param nextdate
	 * @return
	 */
	@Select("SELECT\n" + 
			"	name,\n" +
			"	inventory,\n" +
			"	reference_price as referencePrice,\n" + 
			"	inventory_value as inventoryValue\n" + 
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND ctime >= #{date}\n" +
			"AND ctime <  #{nextdate}\n" +
			"GROUP BY\n" + 
			"	NAME\n" + 
			"ORDER BY\n" + 
			"	inventory_value DESC\n" + 
			"LIMIT 10")
	List<PanoramicSparePartsMaterials> listSummaryByDate(@Param("date") Timestamp date,@Param("nextdate") Timestamp nextdate);
	
	/**
	 * 备品备件中高库存前10列表
	 * @param date
	 * @param nextdate
	 * @return
	 */
	@Select("SELECT\n" + 
			"	NAME ,\n" +
			"	reference_price AS referencePrice ,\n" + 
			"	unit,\n" +
			"	inventory\n" +
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND ctime >= #{date}\n" +
			"AND ctime <  #{nextdate}\n" +
			"ORDER BY\n" + 
			"	inventory desc\n" + 
			"LIMIT 10")
	List<PanoramicSparePartsMaterials> listHighValueByDate(@Param("date") Timestamp date,@Param("nextdate") Timestamp nextdate);
	
	/**
	 * 备品备件中低库存前10列表
	 * @param date
	 * @param nextdate
	 * @return
	 */
	@Select("SELECT\n" + 
			"	NAME ,\n" +
			"	reference_price AS referencePrice ,\n" + 
			"	unit,\n" +
			"	inventory\n" +
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND ctime >= #{date}\n" +
			"AND ctime <  #{nextdate}\n" +
			"AND inventory > 0\n" +
			"ORDER BY\n" + 
			"	inventory\n" + 
			"LIMIT 10")
	List<PanoramicSparePartsMaterials> listLowValueByDate(@Param("date") Timestamp date,@Param("nextdate") Timestamp nextdate);
	
}