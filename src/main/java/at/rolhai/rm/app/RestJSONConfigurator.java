package at.rolhai.rm.app;

import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RestJSONConfigurator implements ContextResolver<Jsonb> {

    @Inject
    JsonbConfig config;

    @Override
    public Jsonb getContext(Class<?> type) {
        return JsonbBuilder
                .newBuilder()
                .withConfig(config)
                .build();
    }
}
