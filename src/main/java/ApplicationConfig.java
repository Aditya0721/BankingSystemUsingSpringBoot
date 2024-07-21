import org.login.LoginConfig;
import org.registration.RegistrationConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LoginConfig.class, RegistrationConfig.class})
public class ApplicationConfig {

}
