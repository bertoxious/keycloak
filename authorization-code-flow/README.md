## Authorization Code Grant
This type of authorization flow works when granting a mobile application or a web page to access your facebook or google account.

For this to work the client application (ex: a website) must be capable of handling `uri_redirect` from the __Authorization Server__. and in order to do that the client application must be able to securely store the auth `client_secret` that it will be using when exchanging the `authorization_code` for an __access_token__.

Authorization Code request or Code Grant:

Use this code to generate access token.

```
GET/authorize 
?response_type=code    
&state=hv8hf0h27id
&redirect_uri={Redirect_uri}
&scope={Scope}
&client_id={Client_id}
```

The authorization server returns the same value for state in order to validate.

```
POST https://{authorization-server-url}/token
?grant_type=authorization_code
&code={code}
&redirect_uri={redirect-uri}
&client_id={client_id}
&client_secret={client_secret}\
```
This will return us an access token or json encrypted base64.
![image](https://m.media-amazon.com/images/G/01/mobile-apps/dex/ask-accountlinking/auth-code-grant-flow-sequence._TTH_.png)

[Docker compose for keycloak](https://github.com/bertoxious/keycloak/blob/main/docker-compose.yml)

## STEP 1:
Make a __GET__ Request from __Postman__
```
http://localhost:8081/auth/realms/{name_of_realm}/protocol/openid-connect/auth
```
and in the `params` add 
| Key | Value |
| :---: | :---: |
| response_type | code |
| client_id | {id_of_the_client} |
| state | {random_alphanumeric_number} |
| scope | openid profile |
| redirect_uri | {redirect_url_set_for_client_in_keycloak} |

After this step the authorization server will redirect you to the user authentication page. and after login it will redirect to the __redirect_uri__ 
then it will provide with the `state` same as provided earlier in the __GET__ Request, a `session_state` and the `code` i.e. authorization_code that will be needed to exchange for an access token.

## STEP 2:
Now let's try to exchange this authorization code for an `Access Token`  
So now let's create a new http __POST__ request.  
```
http://localhost:8081/auth/realms/{name_of_the_realm}/protocol/openid-connect/token
```
and in the body x-www-form-urlencoded
| Key | Value |
| :---: | :---: |
| grant_type | authorization_code |
| client_id | {client_id} |
| client_secret | {client_secret} |
| code | {generated_authorization_code} |
| redirect_uri | {redirect_uri} | 

```json
{ 
"error": "invalid_grant",
"error_description": "Code not valid"
}
```
___This error means the code/ authorization code that was generated has expired.___

Otherwise it will generate an `access_token` ,a `refresh_token` and a `id_token`.
