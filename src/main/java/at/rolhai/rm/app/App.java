package at.rolhai.rm.app;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
    tags = { },
    info = @Info(
        title="Race Manager API",
        version = "1.0.0",
        contact = @Contact(
            name = "Race Manager Developer",
            url = "https://github.com/rolhai",
            email = "rolhai@gmx.net"),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
@ApplicationPath("api")
public class App extends Application {
    
}
