package com.monitor.dto.productionmonitoring;

import com.cloud.model.BaseObject;

import java.io.Serializable;

/**
 * @author gang
 */
public class Productionmonitoringinfo extends BaseObject {

	private static final long serialVersionUID = 1L;

	/**
     * 磷钙矿耗
     */
    private String cpoc;

    /**
     * 磷钙酸耗
     */
    private String cpac;

    /**
     * 磷钙煤耗
     */
    private String ccp;

    /**
     * 普钙电耗
     */
    private String cpc;
    
    /**
     * 磷钙电耗
     */
    private String pcc;

    @Override
    public Serializable realId() {
        return null;
    }
    
    public String getCpoc() {
        return cpoc;
    }

    public void setCpoc(String cpoc) {
        this.cpoc = cpoc;
    }

    public String getCpac() {
        return cpac;
    }

    public void setCpac(String cpac) {
        this.cpac = cpac;
    }

    public String getCcp() {
        return ccp;
    }

    public void setCcp(String ccp) {
        this.ccp = ccp;
    }

    public String getCpc() {
        return cpc;
    }

    public void setCpc(String cpc) {
        this.cpc = cpc;
    }

    public String getPcc() {
        return pcc;
    }

    public void setPcc(String pcc) {
        this.pcc = pcc;
    }
}
