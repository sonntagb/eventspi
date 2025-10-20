package de.dropletinnovations.dropletxpert.keycloak.spi.eventspi.persistence;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "custom_event_log")
public class CustomEventEntity {

    @Id
    @Column(length = 36, nullable = false)
    private String id;

    @Column(name = "event_type", length = 50, nullable = false)
    private String eventType;

    @Column(name = "realm_id", length = 255)
    private String realmId;

    @Column(name = "client_id", length = 255)
    private String clientId;

    @Column(name = "ip_address", length = 64)
    private String ipAddress;

    @Column(name = "channel", length = 128)
    private String channel;

    @Column(name = "event_time", nullable = false)
    private Instant eventTime;

    public CustomEventEntity() { this.id = UUID.randomUUID().toString(); }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getRealmId() {
        return realmId;
    }

    public void setRealmId(String realmId) {
        this.realmId = realmId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Instant getEventTime() {
        return eventTime;
    }

    public void setEventTime(Instant eventTime) {
        this.eventTime = eventTime;
    }
}
