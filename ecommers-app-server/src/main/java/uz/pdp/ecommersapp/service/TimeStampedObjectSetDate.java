package uz.pdp.ecommersapp.service;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class TimeStampedObjectSetDate {
    @Column(name = "insert_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTimestamp;

    @Column(name = "update_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date    updateTimestamp;

    @SuppressWarnings("unused")
    @PrePersist
    private void onInsert() {
        this.insertTimestamp = new Date();
        this.updateTimestamp = this.insertTimestamp;
    }

    @SuppressWarnings("unused")
    @PreUpdate
    private void onUpdate() {
        this.updateTimestamp = new Date();
    }


    public Date getInsertTimestamp() {
        return this.insertTimestamp;
    }


    public Date getUpdateTimestamp() {
        return this.updateTimestamp;
    }
}
