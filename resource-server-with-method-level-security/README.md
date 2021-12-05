## Resource server with method level security 

Method level security is a layer added to protect our service end points.  
With this we can use annotations above method name to _allow_ or _deny_ execution of that method based on some conditions.

Let's start by adding method level security to our project continued from 
[___resource-server-with-spring-boot___](https://github.com/bertoxious/keycloak/tree/main/resource-server-with-spring-boot)  

_@EnableGlobalMethodSecurity_ can be added to any java class with _@Configuration_ annotation or with _@EnableWebSecurity_  

_@EnableGlobalMethodSecurity_ annotation allows us to __enable__ certain security annotations.  