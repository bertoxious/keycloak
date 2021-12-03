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

| ___Confidential Client___  (Can keep client secret safe) | ___Public Client___  (Cannot keep client ID and secret safe) |
| :---  | :--- |
| Secure app running on server | Native Apps on User Device |
| - | Single Page browser based App |
----------------------------------
![image](https://images.velog.io/images/denmark-choco/post/fad1a424-7b3f-41f3-88eb-fb2f9d0d0813/oauth2-flow.png)

### Access Token Types

The token may denote an __identifier__ used to retrieve the authorization information or may self-contain the authorization information in a verifiable manner (i.e a token string consisting of some data and a signature)
- Identifier Type : An alphanumeric character of certain length (ex: ByL56Vd2KzDJDhufzuF7), the length of the string depends upon the type of authorization server.
- Self contain authorization information : A very long alphanumeric string (this contains much more information, which contains all the values in json format encrypted in base64 format). Separated into a __Header__, __Payload__ and __Signature__ containing __Type of token, Algorithm__ , __Information__ and __Raw Material to Validate Access Token__ respectively.

### Identifier Type Access Token

| ___Access Token___ | ___user_id___ | ___scope___ | ___expires___ |
| :--- | :--- | :--- | :--- |
| ByL56Vd2KzDJDhufzuF7 | JWefs12aF | profile,documents | 634917591 | 

### Open ID Connect
It comes as an __additional layer__ on the top of `OAuth 2.0` and it is an identity layer that provides the client application with an Identity information about the user. The __Authorization Server__ performing the same is called as __Identity Provider__.
| ___OAuth 2.0___ | ___OAuth 2.0 + Open ID Connect___ |
| :--- | :--- |
| Access Token | ID Token + Access Token |

### Claim : 
___claims are name/value pairs that contain information about a user, as well meta-information about the OIDC service.___
| ___Scope___ | ___Purpose___ |
| :--- | :--- |
| profile | reqeusts access to default profile claims |
| email | requests access to email and verified claims |
| address | requests access to address claim |
| phone | requests access to phone number and phone number verified claims |

___Default Profile Claims___
- name
- family_name
- given_name
- middle_name
- nickname
- preferred_username
- profile
- picture
- website
- gender
- birthdate
- zoneinfo
- locale
- updated_at
