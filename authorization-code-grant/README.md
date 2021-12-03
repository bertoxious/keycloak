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

Make a GET Request from __Postman__
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
