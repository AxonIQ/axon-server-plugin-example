# Axon Server Plugin - Example

## How it works
This plugin is written on top of the [axon-server-plugin-api](https://github.com/AxonIQ/axon-server-plugin-api) using two of the provided _Interceptors_.
1. `AppendEventInterceptor` manipulating the event on the way in, adding some piece of information to the metadata of the event;
1. `ReadEventInterceptor` intercepting the event on the way back, trying to read that piece of information from the metadata.

On both operations you should get the event logged as well as an additional message when the metadata of the event contains the `plugin` field we are looking for.

## How to build
_Axon Server Plugins_ are _OSGi_ modules that contains the plugin implementations. It's written with _Java_ and _Maven_. Because of that, a simple `mvn clean verify` is enough to build a jar into the `target` folder that can be uploaded into _Axon Server Plugin Interface_.

## How to run
For testing purposes, a `docker-compose.yml` file with _Axon Server_ is provided and configured. To use it, running `docker compose up` in the same directory of the file is enough to have the needed infrastructure pieces up and running. After building or downloading the plugin, you have to upload it on _Axon Server Plugin Interface_. Once it is uploaded, you have to _Start_ the plugin clicking on the start button.

---

Created with :heart: by [AxonIQ](https://axoniq.io/)