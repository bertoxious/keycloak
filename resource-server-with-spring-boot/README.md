## Creating a resource server with spring boot

Create a spring boot project with dependencies:
- Spring Web
- Spring Devtools
- OAuth2 Resource Server

Now let's create a _Rest controller_ 

```java

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String status(){
        return "Working";
    }
}
```
However when trying to access this url in browser it will ask for a username and password as we have added OAuth2 Resource Server security so in order to access this url the user first needs to be authenticated.

in order to do that we need to add our __Realm__ to our _application.properties_

```properties
spring.security.oauth2.resourceserver.jwt.issuer-uri = http://localhost:8081/auth/realms/{name_of_realm}
# or we can use 
spring.security.oauth2.resourceserver.jwt.jwk-set-uri = http://localhost:8081/auth/realms/{name_of_realm}/protocol/openid-connect/certs
# this url is pointing to public key endpoint
```

Now let's create a _Token Controller_
```java
@RestController
@RequestMapping("/token")
public class TokenController {
    @GetMapping
    public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt){
//        return jwt.getTokenValue();
        return Collections.singletonMap("Principal",jwt);
    }
}
```