![image](https://www.janua.fr/wp-content/uploads/2017/09/keycloak_logo_480x108.png)
### What is __Keycloak__ ?
It is a tool for __"Identity and Access Management__". Additionally, Keycloak is an open-source tool currently licensed with Apache License 2.0. It is also an upstream project for Red Hat SSO, so if you are looking for something more enterprise-centered, you can check it. IAM typically aims to verify the identity of a user or system which is requesting access to your environment, and evaluates a set of rules which tells what features and assets is that user/system has access to.  

### __Features__ of Keycloak:
- Multiple Protocols Support ([Open ID Connect, OAuth 2.0, SAML 2.0](https://www.okta.com/identity-101/whats-the-difference-between-oauth-openid-connect-and-saml/))
- Single Sign-IN and Single Sign-OUT
- Admin Console
- User Identity and Accesses
- External Identity Source Sync
- Identity Brokering
- Social Identity Providers
- Pages Customization

 ### [Flow of Credentials](https://www.oreilly.com/library/view/getting-started-with/9781449317843/httpatomoreillycomsourceoreillyimages986441.png)

### OAuth 2.0 Client Types:
| Confidential Client  (Can keep client secret safe) | Public Client  (Cannot keep client ID and secret safe) |
| :---  | :--- |
| Secure app running on server | Native Apps on User Device |
| - | Single Page browser based App |
----------------------------------
![image](https://images.velog.io/images/denmark-choco/post/fad1a424-7b3f-41f3-88eb-fb2f9d0d0813/oauth2-flow.png)

### Access Token Types
The token may denote an __identifier__ used to retrieve the authorization information or may self-contain the authorization information in a verifiable manner (i.e a token string consisting of some data and a signature)
- Identifier Type : An alphanumeric character of certain length (ex: ByL56Vd2KzDJDhufzuF7), the length of the string depends upon the type of authorization server.
- Self contain authorization information : A very long alphanumeric string (this contains much more information, which contains all the values in json format encrypted in base64 format)

### Identifier Type Access Token
| Authorization Server |
| :--- | :--- | :--- | :--- |
| Access Token | user_id | scope | expires |
| ByL56Vd2KzDJDhufzuF7 | JWefs12aF | profile,documents | 634917591 | 
