## PKCE Enhanced Authorization Code
- __Proof__
- __Key__
- __for__
- __Code__
- __Exchange__

This authorization code flow is mostly used by native and javascript apps and it provides an additional level of security for applications that cannot keep its Auth __client__ and __secrety key__ safe (ex : Single page Javascript Application as any developer knowing how to preview javascript can open the page source code and see the Auth __client__ and __secret key__).
As javascipt page cannot guarantee the confidentiality of Auth client and secret key, thus it cannot use secret key and as an alternative it makes use of its own secret key which it will need to generate in a way that the authorization server can verify, so this process is called __Proof Key for Code Exchange__. It is similar to [authorization-code-flow](https://github.com/bertoxious/keycloak/tree/main/authorization-code-grant) except that now the client application will need to generate a couple of additional request parameters i.e. `code_challenge` and `code_challenge_method`.

There is a special way of generating the code challenge value. To derive `code_challenge` value the client application will need to first generate the `code_verifier` value. The `code_challenge_method` value will need to be configured in the authorization server for the auth-client-application and the __recommended value__ for this is `S256` (known as SHA256).
or it can be `plain`.

## Code Verifier:
- cryptographic random string
- alphanumeric
- minimum length of 43 characters
- maximum length of 128 characters
- url safe and base64 encoded

## Code Challenge:
`code_challenge = BASE64URL-ENCODE(SHA256(ASCII(code_verifier)))`

## Step 1:
Make a __GET__ request to the url 

```
http://localhost:8081/auth/realms/{name_of_realm}/protocol/openid-connect/auth
```

Add these values to the params

| Key | Value |
| :---: | :---: |
| client_id | {client_id} |
| response_type | code |
| scope | openid |
| redirect_uri | {redirect_url} |
| state | {random_alphanumeric_string} |
| code_challenge_method | 