package at.rolhai.rm.app;

import jakarta.enterprise.inject.Produces;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.nio.charset.StandardCharsets;

public class JsonbProducer {

    @Produces
    Jsonb createJsonb() {
        JsonbConfig config = getJsonbConfig();
        return JsonbBuilder.create(config);
    }

    @Produces
    JsonbConfig getJsonbConfig() {
        JsonbConfig config = new JsonbConfig();
        config.withFormatting(true);
        config.withDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", null);
        config.withEncoding(StandardCharsets.UTF_8.toString());
        return config;
    }


}
