## OAuth Social Login Using Google, Facebook, Github and Okta
Create a new Spring Boot Application with the following dependencies:
- Spring Web
- Spring Boot Devtools
- Thymeleaf
- OAuth2 Client

___Added properties for google, facebook and okta authentication in _Application.properties_ file___
```java
# Redirect to Google for authentication
spring.security.oauth2.client.registration.google.client-id=992179403281-jgh356j1886hiod2vactoljmnaj3ejg5.apps.googleusercontent.com
spring.security.oauth2.client.registration.google.client-secret=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

# Redirect to facebook for authentication
#spring.security.oauth2.client.registration.facebook.client-id=
#spring.security.oauth2.client.registration.facebook.client-secret=

# Redirect to github for authentication
#spring.security.oauth2.client.registration.github.client-id=
#spring.security.oauth2.client.registration.github.client-secret=

# Redirect to github for authentication
spring.security.oauth2.client.registration.okta.client-id= 0oa2yyjqb09u2rxnJ5d7
spring.security.oauth2.client.registration.okta.client-secret= gxxjWcIxAKD74dHr9amc9utOczoyv8qq_xi0jmK8
spring.security.oauth2.client.registration.okta.client-scope= openid,profile

spring.security.oauth2.client.provider.okta.issuer-uri= https://dev-95405384.okta.com/oauth2/default
```
