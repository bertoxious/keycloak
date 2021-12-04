## Password grant authorization flow

It should only be used if the application does not support redirect otherwise if it's a web or mobile application and it does support redirects then it is recommended to use the [authorizaton-code-grant-flow](https://github.com/bertoxious/keycloak/tree/main/authorization-code-flow) or [PKCE-enhanced-authorization-code-flow](https://github.com/bertoxious/keycloak/tree/main/pkce-enhanced-authorization-code-flow).  

Resource Owner(User) -(Username and Password)-> Client Application -(POST Request containing username and password to the authorization server for an access token)-> Authorization Server( Respond with an access token)  

## Steps to follow:
Make a POST request to the authorization server url :
```
http://localhost:8081//auth/realms/{name_of_realm}/protocol/openid-connect/token
```

now in the body x-www-form-urlencoded
| Key | Value |
| :---: | :---: |
| grant_type | password |
| username | {user_name} |
| password | {user's_password} |
| client_id | {client_id} |
| client_secret | {client_secret} |
| scope | profile | 

This would generate the `access_token` and `refresh_token`.
