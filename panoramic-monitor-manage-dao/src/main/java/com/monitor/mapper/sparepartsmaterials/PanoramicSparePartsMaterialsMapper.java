package com.monitor.mapper.sparepartsmaterials;

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
	 * @return
	 */
	@Select("SELECT\n" + 
			"	sum(inventory_value) as inventoryValue\n" + 
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND DATE_FORMAT(ctime , '%Y-%m-%d') = #{date}")
	PanoramicSparePartsMaterials getSummaryByDate(@Param("date") String date);
	
	/**
	 * 指定时间的备品备件库存明细内容
	 * @param date
	 * @return
	 */
	@Select("SELECT\n" + 
			"	NAME as name,\n" + 
			"	inventory as inventory,\n" + 
			"	reference_price as referencePrice,\n" + 
			"	inventory_value as inventoryValue\n" + 
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND DATE_FORMAT(ctime , '%Y-%m-%d') = #{date}\n" + 
			"GROUP BY\n" + 
			"	NAME\n" + 
			"ORDER BY\n" + 
			"	sum(inventory_value) DESC\n" + 
			"LIMIT 10")
	List<PanoramicSparePartsMaterials> listSummaryByDate(@Param("date") String date);
	
	/**
	 * 备品备件中高库存前10列表
	 * @param date
	 * @return
	 */
	@Select("SELECT\n" + 
			"	NAME AS NAME ,\n" + 
			"	reference_price AS referencePrice ,\n" + 
			"	inventory AS inventory\n" + 
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND DATE_FORMAT(ctime , '%Y-%m-%d') = #{date}\n" + 
			"ORDER BY\n" + 
			"	inventory desc\n" + 
			"LIMIT 10")
	List<PanoramicSparePartsMaterials> listHighValueByDate(@Param("date") String date);
	
	/**
	 * 备品备件中低库存前10列表
	 * @param date
	 * @return
	 */
	@Select("SELECT\n" + 
			"	NAME AS NAME ,\n" + 
			"	reference_price AS referencePrice ,\n" + 
			"	inventory AS inventory\n" + 
			"FROM\n" + 
			"	panoramic_spare_parts_materials\n" + 
			"WHERE\n" + 
			"	delete_flag = 1\n" + 
			"AND f_id = 2\n" + 
			"AND DATE_FORMAT(ctime , '%Y-%m-%d') = #{date}\n" + 
			"ORDER BY\n" + 
			"	inventory\n" + 
			"LIMIT 10")
	List<PanoramicSparePartsMaterials> listLowValueByDate(@Param("date") String date);
	
}