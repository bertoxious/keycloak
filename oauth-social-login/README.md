## OAuth Social Login Using Google, Facebook, Github and Okta
Create a new Spring Boot Application with the following dependencies:
- Spring Web
- Spring Boot Devtools
- Thymeleaf
- OAuth2 Client


_Urls to create generate account for creating apps for authentication in [__Google__](https://console.developers.google.com), [__Facebook__](https://developers.facebooks.com), [__Github__](https://developer.github.com) and [__Okta__](https://developer.okta.com/)these apps will return `client_id` and `secret_id` to deploy authentication._ 


___Added properties for google, facebook and okta authentication in `Application.properties` file___
```java
# Redirect to Google for authentication
spring.security.oauth2.client.registration.google.client-id= PASTE GOOGLE CLIENT ID HERE_
spring.security.oauth2.client.registration.google.client-secret= PASTE GOOGLE CLIENT SECRET HERE_

# Redirect to facebook for authentication
#spring.security.oauth2.client.registration.facebook.client-id= PASTE FACEBOOK CLIENT ID HERE_
#spring.security.oauth2.client.registration.facebook.client-secret= PASTE FACEBOOKS CLIENT SECRET HERE_

# Redirect to github for authentication
#spring.security.oauth2.client.registration.github.client-id= PASTE GITHUB CLIENT ID HERE_
#spring.security.oauth2.client.registration.github.client-secret= PASTE GITHUB CLIENT SECRET HERE_

# Redirect to github for authentication
spring.security.oauth2.client.registration.okta.client-id=  PASTE OKTA CLIENT ID HERE
spring.security.oauth2.client.registration.okta.client-secret=  PASTE OKTA CLIENT SECRET HERE
spring.security.oauth2.client.registration.okta.client-scope= openid,profile

spring.security.oauth2.client.provider.okta.issuer-uri= THIS WILL BE MAILED TO YOU ONCE YOU HAVE CREATED THE OKTA DEVELOPERS ACCOUNT
```
