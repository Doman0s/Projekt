package pl.edu.wszib.power.tool.rental.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "pl.edu.wszib.power.tool.rental.controllers",
        "pl.edu.wszib.power.tool.rental.service",
        "pl.edu.wszib.power.tool.rental.session"
})
public class TestConfiguration {

}
