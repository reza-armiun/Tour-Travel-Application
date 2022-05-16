package razarm.tosan.controller.dto;

import java.time.ZonedDateTime;

public class BaseEntityDto {
    protected  String id;


    protected  ZonedDateTime createdAt;
    protected  ZonedDateTime modifiedAt;
    protected  String createdBy;
    protected  String modifiedBy;

    public BaseEntityDto() {
    }

    public BaseEntityDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public String getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() { //TODO
        if(createdAt == null) return ZonedDateTime.now();
        return createdAt;
    }

    public ZonedDateTime getModifiedAt() { //TODO
        if(modifiedAt == null) return ZonedDateTime.now();
        return modifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
