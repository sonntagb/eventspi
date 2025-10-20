package de.dropletinnovations.dropletxpert.keycloak.spi.eventspi.persistence;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

import java.util.Collections;
import java.util.List;

public final class CustomJpaEntityProvider implements JpaEntityProvider {
    @Override public List<Class<?>> getEntities() {
        return Collections.singletonList(CustomEventEntity.class);
    }
    @Override public String getChangelogLocation() {
        return "META-INF/eventspi-changelog.xml";
    }
    @Override public String getFactoryId() { return CustomJpaEntityProviderFactory.ID; }
    @Override public void close() { }
}

