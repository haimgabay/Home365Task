package com.haimgabay.home365task;

import org.json.JSONObject;

public class SinglePropDetails {


    private String id;
    private String created;
    private String address;
    private String status;
    private String plan;
    private String owner;
    private String ownerStatus;
    private JSONObject tenant;
    private String tenantStatus;

    public SinglePropDetails(String id, String created, String address, String status, String plan, String owner, String ownerStatus, JSONObject tenant, String tenantStatus) {
        this.id = id;
        this.created = created;
        this.address = address;
        this.status = status;
        this.plan = plan;
        this.owner = owner;
        this.ownerStatus = ownerStatus;
        this.tenant = tenant;
        this.tenantStatus = tenantStatus;
    }
    @Override
    public String toString() {
        return "SinglePropDetails{" +
                "id='" + id + '\'' +
                ", created='" + created + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", owner=" + owner +
                ", ownerStatus=" + ownerStatus +
                ", tenant=" + tenant.toString() +
                ", tenantStatus=" + tenantStatus +
                '}';
    }
    public String getCreated() {
        return created;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setCreated(String created) {
        this.created = created;
    }

    public String getPropertyName() {
        return address;
    }

    public void setPropertyName(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(String ownerStatus) {
        this.ownerStatus = ownerStatus;
    }

    public JSONObject getTenant() {
        return tenant;
    }

    public void setTenant(JSONObject tenant) {
        this.tenant = tenant;
    }

    public String getTenantStatus() {
        return tenantStatus;
    }

    public void setTenantStatus(String tenantStatus) {
        this.tenantStatus = tenantStatus;
    }


}
