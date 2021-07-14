package io.axoniq.plugin;

import io.axoniq.axonserver.plugin.interceptor.AppendEventInterceptor;
import io.axoniq.axonserver.plugin.interceptor.ReadEventInterceptor;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * The Activator is referenced on the pom file and what is used as the entry point to have it on AS.
 */
public class PluginActivator implements BundleActivator {

    private final Logger logger = LoggerFactory.getLogger(PluginActivator.class);

    private final Set<ServiceRegistration<?>> registration = new HashSet<>();

    /**
     * Usually only used for registering the plugin.
     *
     * @param bundleContext the context where the plugin runs
     */
    @Override
    public void start(BundleContext bundleContext) {
        logger.info("Starting bundle");
        registration.add(bundleContext.registerService(AppendEventInterceptor.class,
                                                       new InterceptWhenAppending(),
                                                       null));
        registration.add(bundleContext.registerService(ReadEventInterceptor.class,
                                                       new InterceptWhenReading(),
                                                       null));
    }

    /**
     * Used to unregister the plugin. You can also clean up resources if needed.
     *
     * @param bundleContext the context where the plugin runs
     */
    @Override
    public void stop(BundleContext bundleContext) {
        logger.info("Stopping bundle");
        registration.forEach(ServiceRegistration::unregister);
    }
}
