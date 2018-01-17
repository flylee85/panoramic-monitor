package com.monitor.dto.productionmonitoring;

import com.cloud.model.BaseObject;

import java.io.Serializable;

/**
 * @author gang
 */
public class Productionmonitoringinfo extends BaseObject {

    /**
     * 磷钙矿耗
     */
    private double cpoc;

    /**
     * 磷钙酸耗
     */
    private double cpac;

    /**
     * 磷钙煤耗
     */
    private double ccp;

    /**
     * 普钙电耗
     */
    private double cpc;
    /**
     * 磷钙电耗
     */
    private double pcc;

    @Override
    public Serializable realId() {
        return null;
    }
}
