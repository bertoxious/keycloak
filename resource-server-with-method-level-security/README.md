## Resource server with method level security 

Method level security is a layer added to protect our service end points.  
With this we can use annotations above method name to _allow_ or _deny_ execution of that method based on some conditions.

Let's start by adding method level security to our project continued from 
[___resource-server-with-spring-boot___](https://github.com/bertoxious/keycloak/tree/main/resource-server-with-spring-boot)  

_@EnableGlobalMethodSecurity_ can be added to any java class with _@Configuration_ annotation or with _@EnableWebSecurity_  

_@EnableGlobalMethodSecurity_ annotation allows us to __enable__ certain security annotations. Let's add it to our WebSecurity Class.  

```java
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
}
```
and create a delete user mapping with _@Secured()_ annotation added

```java
@Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id){ return "Deleted user with id"+ id;}
```
Let's c if it works  
_Generate Authorization Code_ -> _Exchange it for a access token_ -> _Make a delete request to the mapped url with access token in headers Authorization_.

___If we try to delete it with any other role that is not assigned to the user it will say the request is Forbidden(403) and if we try to delete it without providing the access token in headers Authorization it will say the user is Unauthorized(401)___  
