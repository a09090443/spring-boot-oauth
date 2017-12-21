# Spring Boot and Spring Security OAuth2 Demo

# authorization_code
  ## client_id=test
  ## client_secret=secret
  ## user=admin
  ## password=admin
  
  ## URL:http://localhost:8081/auth/oauth/authorize?client_id=test&response_type=code&redirect_uri=http://localhost:8081/auth/api/test1
  
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