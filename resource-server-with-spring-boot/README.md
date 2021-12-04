## Creating a resource server with spring boot

Create a spring boot project with dependencies:
- Spring Web
- Spring Devtools
- OAuth2 Resource Server

Now let's create a rest controller 

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