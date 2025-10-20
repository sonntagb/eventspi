package de.dropletinnovations.dropletxpert.keycloak.spi.eventspi;

import de.dropletinnovations.dropletxpert.keycloak.spi.eventspi.persistence.CustomEventEntity;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.models.KeycloakSession;

import jakarta.persistence.EntityManager;
import org.keycloak.connections.jpa.JpaConnectionProvider;

import java.time.Instant;

public class CustomEventListenerProvider implements EventListenerProvider {

    private final KeycloakSession session;

    public CustomEventListenerProvider(KeycloakSession session) { this.session = session; }

    @Override
    public void onEvent(Event event) {
        if (event == null) return;
        if (event.getType() != EventType.LOGIN && event.getType() != EventType.REGISTER) return;

        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        CustomEventEntity e = new CustomEventEntity();
        e.setEventType(event.getType().name());
        e.setRealmId(event.getRealmId());
        e.setClientId(event.getClientId());
        e.setIpAddress(event.getIpAddress());
        e.setChannel(event.getClientId() != null ? event.getClientId() : "unknown");
        e.setEventTime(Instant.now());
        em.persist(e);
    }

    @Override public void onEvent(org.keycloak.events.admin.AdminEvent adminEvent, boolean include) { }
    @Override public void close() { }
}
