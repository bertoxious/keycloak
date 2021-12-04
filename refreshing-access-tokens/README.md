## Refreshing access tokens

Refreshing an access token using refresh token.

1. ___Client Application___ - Will request for an `access token`   
2. ___Authorization Server___ - will respond with an `access token` and `refresh token`  
3. ___Client Application___ - Will send the `refresh token`.
4. ___Authorization Server___ - WIll respond with __new__ `access token` and `refresh token`


 We can also request for an `access token` that __never expires__ 
 ```json
 {
 	"refresh_expires_in": 0,
 	"refresh_token":"uroiquriouu9384914..."
 }
 ```
 in order to do that we need to add to the scope `offline_access`

 ### Requesting an `access token` that __never expires__

 Make a __POST__ request to the authorization server
 ```
 http://localhost:8081/auth/realms/{name_of_realm}/protocol/openid-connect/token
 ```

 Now in the body x-www-form-urlencoded
 |Key | Value |
 | :---: | :---: |
 | username | {user_name} |
 | password | {user's_password} |
 | grant_type | password |
 | client_id | {client_id} |
 | client_secret | {client_secret} |
 | scope | `profile` `offline_access` |

 This would generate an `access token` and `refresh token` that __never expires__.


 ### Refreshing an `access token`

 Make a __POST__ request to the authorization server

 ```
 http://localhost:8081/auth/realms/{name_of_realm}/protocol/openid-connect/token
 ```
 now in body in x-www-form-urlencoded
 | Key | Value |
 | :---: | :---: |
 | grant_type | refresh_token |
 | client_id | {client_secret} |
 | client_secret | {client_secret} |
 | refresh_token | {expired_refresh_token} |

 This would generate a new `access token` and `refresh token`