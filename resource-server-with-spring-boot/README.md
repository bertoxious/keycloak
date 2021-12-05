## Creating a resource server with spring boot

Create a spring boot project with dependencies:
- Spring Web
- Spring Devtools
- OAuth2 Resource Server

_My Keycloak server is running on port 8081_ as per [_keycloak docker compose file_](https://github.com/bertoxious/keycloak/blob/main/docker-compose.yml)

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
Now let's make a __POST__ request from postman to the mappped token controller url
```
http://localhost:8080/token
```
with Headers
| Key | Value |
| :---: | :---: |
| Authorization | Bearer + `Access Token` |

This would return us a json file somewhat similar to this
```json
{
    "Principal": {
        "tokenValue": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJKMmZlS2c1U2FzaGZ4bndFNE8wMHBWa2ZORC1TUVVnNzlTRElPbjkxaklnIn0.eyJleHAiOjE2Mzg1OTUxNjEsImlhdCI6MTYzODU5NDg2MSwiYXV0aF90aW1lIjoxNjM4NTkxNTc2LCJqdGkiOiJhMGI3MjM3OC02MDQzLTQ3NDEtOWI4Ny01ZjlkNzk0YmRjY2QiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODEvYXV0aC9yZWFsbXMvYXNoaXNoIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImEyNGQ0ZTMwLTEzYTAtNGQyYS04MTc0LTc5ODcxZTI1NTI0YSIsInR5cCI6IkJlYXJlciIsImF6cCI6Im15Y2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImU1ZjE0YzRkLWNjOGQtNDljNi1iYzI2LTM1ODkzYzY4ZWY3ZiIsImFjciI6IjAiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtYXNoaXNoIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsInNpZCI6ImU1ZjE0YzRkLWNjOGQtNDljNi1iYzI2LTM1ODkzYzY4ZWY3ZiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoidXNlciJ9.JhUO3Vhh4Y04d3GNkmjPXcsThiWtfj7D2esV1g9yWnmbx_4YSDicUZJm5f0O4B82Az98Tp0jWNOpGojhUOew9KH9zii3hoVtIHalVkNiQZjwi-eoJAcgO2Xb6aOVQeh4yCJNStYqwl4IBi2Bm1y88E7rRYbDlyI9HWo5cl0fnZ5ieWpqc_d9rqQjWYKwKTu-naEb7bHiRE0LuWomGhjwJSj32WkDSvWpSqbJf7ORm3Y4XVKEvcx2adS-xwPJzX_QtGZ0E9FJl_RKsPkIWdzncpO5Dw2LQh8rhQISgWCEd7jXW1Zq3F_Cp7k0JiwFQ9NTuDSyW5P-VjN0_4PbxhI4wQ",
        "issuedAt": "2021-12-04T05:14:21Z",
        "expiresAt": "2021-12-04T05:19:21Z",
        "headers": {
            "kid": "J2feKg5SashfxnwE4O00pVkfND-SQUg79SDIOn91jIg",
            "typ": "JWT",
            "alg": "RS256"
        },
        "claims": {
            "sub": "a24d4e30-13a0-4d2a-8174-79871e25524a",
            "resource_access": {
                "account": {
                    "roles": [
                        "manage-account",
                        "manage-account-links",
                        "view-profile"
                    ]
                }
            },
            "email_verified": false,
            "iss": "http://localhost:8081/auth/realms/ashish",
            "typ": "Bearer",
            "preferred_username": "user",
            "sid": "e5f14c4d-cc8d-49c6-bc26-35893c68ef7f",
            "aud": [
                "account"
            ],
            "acr": "0",
            "realm_access": {
                "roles": [
                    "offline_access",
                    "uma_authorization",
                    "default-roles-ashish"
                ]
            },
            "azp": "myclient",
            "auth_time": 1638591576,
            "scope": "openid profile email",
            "exp": "2021-12-04T05:19:21Z",
            "session_state": "e5f14c4d-cc8d-49c6-bc26-35893c68ef7f",
            "iat": "2021-12-04T05:14:21Z",
            "jti": "a0b72378-6043-4741-9b87-5f9d794bdccd"
        },
        "id": "a0b72378-6043-4741-9b87-5f9d794bdccd",
        "audience": [
            "account"
        ],
        "subject": "a24d4e30-13a0-4d2a-8174-79871e25524a",
        "issuer": "http://localhost:8081/auth/realms/ashish",
        "notBefore": null
    }
}
```
## Resource Server - ___Scope Based Access Control___
_Scope_ is a mechanism in OAuth 2.0 to limit an application's access to user account. An application can request one or more scopes, this information is then presented to the user in the consent screen and the access token issued to the application will be limited to the scopes granted.

Let's create a class by the name of _WebSecurity_ extending the _WebSecurityConfigureAdapter_  
```java
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/status/check").hasAuthority("SCOPE_profile")
        .anyRequest().authenticated().and().oauth2ResourceServer().jwt();
    }
}
```
Now let's create an access token by first making __GET__ request 
```
http://localhost:8081/auth/realms/ashish/protocol/openid-connect/auth?client_id=myclient&response_type=code&scope=openid profile&redirect_uri=http://localhost:8083/callback&state=hasdifasdf
```
and then exchange the code generated to pass on with the __POST__ request
```
http://localhost:8081/auth/realms/ashish/protocol/openid-connect/token
```
with the following values in body 
``` json
[{"key":"grant_type","value":"authorization_code","equals":true,"description":null,"enabled":true},{"key":"client_id","value":"myclient","equals":true,"description":null,"enabled":true},{"key":"client_secret","value":"ef0ba39c-aaf6-4cc0-9b20-9cd95a945e3e","equals":true,"description":null,"enabled":true},{"key":"code","value":"fd27fddc-f2ca-46c5-bd0a-3603d32961ea.0a346926-e9f1-4e51-bb8b-a0c28a91bc81.975286e8-cfe0-490d-9601-be8e2e63a079","equals":false,"description":null,"enabled":true},{"key":"redirect_uri","value":"http://localhost:8083/callback","equals":true,"description":null,"enabled":true}]
```
and then make a get request to the _User Controller_ in the _Resource Server_
```
http://localhost:8080/users/status/check
```
along with following key and value in headers
| Key | Value |
| :---: | :---: |
| Authorization | Bearer + `Access Token` |

___Spring Security Roles and Authorities___
| Role | Priviliges or Authorities |
| :---: | :---: |
| User  | <ul><li>view profile</li><li>view other users</li><li>edit own profile</li></ul>  |
| Admin | <ul><li>view profile</li><li>view other users</li><li>edit own profile</li><li>edit profile of other users</li><li>delete other users</li></ul>  |
| SuperAdmin | <ul><li>view profile</li><li>view other users</li><li>edit own profile</li><li>edit profile of other users</li><li>delete other users</li><li>edit/delete other admins</li></ul>  |

Now from the keycloak create a role and assign that role to the user.
in my case i have created a role by the name of _developer_ and assigned that role to the user by the name _user_ and create a _RoleConverter_ class inside our __security__ package.
```java
public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
        if(realmAccess == null || realmAccess.isEmpty()){
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> returnValue = ((List<String>) realmAccess.get("roles"))
                .stream().map(roleName -> "ROLE_"+roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return returnValue;
    }
}
```
and let's add that converter to our _Web Security_ class  
```java
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/status/check")
//                .hasAuthority("SCOPE_profile")
                .hasRole("developer") //will check for the specific role
//                .hasAnyRole("role_one", "role_two") // will check for any role and we can provide as many roles
        .anyRequest().authenticated().and().oauth2ResourceServer().jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter);
    }
}
```
_Generate Authorization Code_ -> _Exchange it for an Access Token_ -> _Pass it through an Authorization Header to TokenController URL_ -> It will work.
