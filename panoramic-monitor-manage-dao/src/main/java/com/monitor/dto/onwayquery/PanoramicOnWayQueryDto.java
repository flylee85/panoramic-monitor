/**
 * @author fgh
 * @author fgh
 * @author fgh
 * @author fgh
 * @author fgh
 */
/**
 * @author fgh
 *
 */
package com.monitor.dto.onwayquery;

public class PanoramicOnWayQueryDto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * createtimeGe
     */
    private String createtimeGe;
    /**
     * createtimeLt
     */
    private String createtimeLt;
    /**
     * fields
     */
    private String fields;
    /**
     * orgcode
     */
    private String orgcode;


    /**
     * 获取OrgCode
     *
     * @return orgcode - OrgCode
     */
    public String getOrgCode() {
        return orgcode;
    }

    /**
     * 设置OrgCode
     *
     * @param orgcode OrgCode
     */
    public void setOrgCode(String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * 获取CreateTimeGe
     *
     * @return createtimeGe - CreateTimeGe
     */
    public String getCreateTimeGe() {
        return createtimeGe;
    }

    /**
     * 设置CreateTimeGe
     *
     * @param createtimeGe CreateTimeGe
     */
    public void setCreateTimeGe(String createtimeGe) {
        this.createtimeGe = createtimeGe;
    }

    /**
     * 获取CreateTimeLt
     *
     * @return createtimeLt - CreateTimeLt
     */
    public String getCreateTimeLt() {
        return createtimeGe;
    }

    /**
     * 设置CreateTimeLt
     *
     * @param createtimeLt CreateTimeLt
     */
    public void setCreateTimeLt(String createtimeLt) {
        this.createtimeLt = createtimeLt;
    }


    /**
     * 获取Fields
     *
     * @return fields - Fields
     */
    public String getFields() {
        return fields;
    }

    /**
     * 设置Fields
     *
     * @param fields Fields
     */
    public void setFields(String fields) {
        this.fields = fields;
    }


}