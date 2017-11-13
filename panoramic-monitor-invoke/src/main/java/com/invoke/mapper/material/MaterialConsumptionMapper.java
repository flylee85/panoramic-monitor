package com.invoke.mapper.material;

import com.cloud.core.Mapper;
import com.invoke.model.dto.MaterialConsumptionDto;
import com.invoke.model.material.MaterialConsumption;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author sunder
 */
@Repository("materialConsumptionMapper")
public interface MaterialConsumptionMapper extends Mapper<MaterialConsumption> {
    @Select("SELECT * FROM hr_material_consumption_mid AS m WHERE m.MAT_CODE = #{matCode} and m.CON_TIME >=#{conTime}")
    List<MaterialConsumptionDto> listByDate(String matCode, Date conTime);
}
