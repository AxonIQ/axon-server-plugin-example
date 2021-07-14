package io.axoniq.plugin;

import io.axoniq.axonserver.grpc.MetaDataValue;
import io.axoniq.axonserver.grpc.event.Event;
import io.axoniq.axonserver.plugin.ExecutionContext;
import io.axoniq.axonserver.plugin.interceptor.AppendEventInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterceptWhenAppending implements AppendEventInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(InterceptWhenAppending.class);

    @Override
    public Event appendEvent(Event event, ExecutionContext executionContext) {
        logger.info("appendEvent: {}", event);

        return Event.newBuilder(event)
                    .putMetaData("plugin", MetaDataValue.newBuilder()
                                                        .setTextValue("Hello from plugin!")
                                                        .build())
                    .build();
    }
}
