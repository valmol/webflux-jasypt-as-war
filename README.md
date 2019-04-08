This is just a simple demo app which shows issue when boot app run as WAR

Demo issues:

- inject properties from yaml config using @Value annotation 
- use Jasypt 


# Boot application

``
mvn spring-boot:run
``

Use http/curl to access endpoint

``
http http://localhost:8080/password
``

Output shall be

``
Type-safe value Password@1
@Value: Password@1
``

# Jetty
``
mvn jetty:run
``

Use http/curl to access endpoint

``
http http://localhost:8087/password
``

Output shall be

``
Type-safe value null
@Value:  empty
``

# Summary

It is only one issue which you meat when you choose deployment as WAR for Boot and WebFlux.
The reason is that WAR mode is not supported for such stack out-of-the-box.
You shall write custom initializer to run boot WebFlux Boot application as WAR.
Because of that Boot auto configuration logic does not work in most cases and you cannot use a lot of features just out-of-the-box, 
i.e. just as described in documentation. 
Some time issues are easy to fix some times it is not that obvious how to fix.

Good luck! 


