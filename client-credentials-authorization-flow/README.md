## client-credentials authorization flow

These are machine to machine requests i.e. when one application needs to send request to another application. There is __no user involved__ in this flow and there is __no login page__ for user to type in their username and password.

Microservice A -(POST request to Authorization Server)-> Authorization server(Access Token in response) -> Microservice B(access token will be used to access this service by Microservice A)

## Step 1:
Make a __POST__ request to the url
```
http://localhost:8081/auth/realms/{name_of_realm}/protocol/openid-connect/token
```

now in the body x-www-form-urlencoded
|Key | Value|
| :---:  | :---: | 
| grant_type | client_credentials |
| client_id | {client_id} |
| client_secret | {client_secret} |
| scope | email | 

This would generate `access_token` and `refresh_token`.