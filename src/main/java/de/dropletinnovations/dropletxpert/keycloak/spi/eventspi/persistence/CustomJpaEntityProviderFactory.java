package de.dropletinnovations.dropletxpert.keycloak.spi.eventspi.persistence;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public final class CustomJpaEntityProviderFactory implements JpaEntityProviderFactory {
    public static final String ID = "custom-events-entity-provider";
    @Override public JpaEntityProvider create(KeycloakSession session) { return new CustomJpaEntityProvider(); }
    @Override public void init(org.keycloak.Config.Scope config) { }
    @Override public void postInit(KeycloakSessionFactory factory) { }
    @Override public void close() { }
    @Override public String getId() { return ID; }
}
