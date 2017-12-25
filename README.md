# Spring Boot and Spring Security OAuth2 Demo

# authorization_code
  ## client_id=test
  ## client_secret=secret
  ## user=admin
  ## password=admin
  
  ## URL : http://localhost:8081/auth/oauth/authorize?client_id=test&response_type=code&redirect_uri=http://localhost:8081/auth/api/test1
  
  response result : http://localhost:8081/auth/api/test1?code=vy3UuV
  
  ## get access_token URL : http://localhost:8081/auth/oauth/token?grant_type=authorization_code&code=vy3UuV&redirect_uri=http://localhost:8081/auth/api/test1&client_id=test&client_secret=secret
  
  response result : 
  {
    "access_token": "97eb5a4d-4c11-4ba1-adbc-d7346d7b26ea",
    "token_type": "bearer",
    "refresh_token": "f8896d81-ce51-4ba9-bbf8-17c37c63461b",
    "expires_in": 1799,
    "scope": "read write test"
  }
  
  ## use access_token to request URL : http://localhost:8081/auth/api/test1?access_token=97eb5a4d-4c11-4ba1-adbc-d7346d7b26ea
  
  response result : This is test1
  
# password

  ## client_id=oauth_client
  ## client_secret=secret
  ## user=admin
  ## password=admin
  
  ## URL : http://localhost:8081/auth/oauth/token?grant_type=password&username=admin&password=admin
  
  response result :
  {
    "access_token": "bd0d1c13-ee89-43be-a0cb-a3551656afee",
    "token_type": "bearer",
    "refresh_token": "7478e246-2d2d-43c7-88e4-d8c726351921",
    "expires_in": 60,
    "scope": "read write test"
  }
  
  ## use access_token to request URL : http://localhost:8081/auth/api/test2?access_token=bd0d1c13-ee89-43be-a0cb-a3551656afee
  
  response result : This is test2
  
# refresh token

 ## client_id=oauth_client
 ## client_secret=secret
 ## user=admin
 ## password=admin
  
 ## URL : http://localhost:8081/auth/oauth/token?grant_type=refresh_token&refresh_token="refresh_token"
 
 response result :
 {
    "access_token": "5d516bfb-fa58-4a0b-963f-9f17046a7b97", (new token)
    "token_type": "bearer",
    "refresh_token": "6e96e6d4-c182-4182-bed6-1bb760ac6d4a",
    "expires_in": 1799,
    "scope": "read write test"
}