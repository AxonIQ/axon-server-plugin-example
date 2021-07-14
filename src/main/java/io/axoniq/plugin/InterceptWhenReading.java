package io.axoniq.plugin;

import io.axoniq.axonserver.grpc.MetaDataValue;
import io.axoniq.axonserver.grpc.event.Event;
import io.axoniq.axonserver.plugin.ExecutionContext;
import io.axoniq.axonserver.plugin.interceptor.ReadEventInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterceptWhenReading implements ReadEventInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(InterceptWhenReading.class);

    @Override
    public Event readEvent(Event event, ExecutionContext executionContext) {
        logger.info("readEvent: {}", event);
        MetaDataValue helloFromPlugin = event.getMetaDataMap().get("plugin");

        if (helloFromPlugin != null) {
            logger.info("This event was modified by the plugin: " + helloFromPlugin.getTextValue());
        }

        return event;
    }
}
