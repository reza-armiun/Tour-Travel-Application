package razarm.tosan.controller.dto;

import java.time.ZonedDateTime;

public class BaseEntityDto {
    protected final String id;


    protected final ZonedDateTime createdAt;
    protected final ZonedDateTime modifiedAt;
    protected final String createdBy;
    protected final String modifiedBy;

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
}
