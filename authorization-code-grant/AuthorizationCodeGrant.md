## Authorization Code Grant
This type of authorization flow works when granting a mobile application or a web page to access your facebook or google account.

For this to work the client application (ex: a website) must be capable of handling `uri_redirect` from the __Authorization Server__. and in order to do that the client application must be able to securely store the auth `client_secret` that it will be using when exchanging the `authorization_code` for an __access_token__.

Authorization Code request or Code Grant:

```html
GET/authorize 
?response_type=code    
&state=hv8hf0h27id
&redirect_uri={Redirect_uri}
&scope={Scope}
&client_id={Client_id}
```