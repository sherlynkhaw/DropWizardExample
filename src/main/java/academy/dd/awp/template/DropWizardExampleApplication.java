//Application Class
package academy.dd.awp.template;

import academy.dd.awp.template.health.TemplateHealthCheck;
import academy.dd.awp.template.resources.DropWizardResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardExampleApplication extends Application<DropWizardExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropWizardExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    //used to configure aspects of the application required before the application is run
    @Override
    public void initialize(Bootstrap<DropWizardExampleConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DropWizardExampleConfiguration configuration, Environment environment) {
        //Registering the resource
        final DropWizardResource resource = new DropWizardResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource); //Jersey environment

    }
}


