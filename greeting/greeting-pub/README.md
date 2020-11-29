# greeting-pub

```
$ curl -v -i http://localhost:8090/api
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /api HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 29 Nov 2020 08:08:26 GMT
Date: Sun, 29 Nov 2020 08:08:26 GMT

< 
{
  "_links" : {
    "profile" : {
      "href" : "http://localhost:8090/api/profile"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/api/profile
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /api/profile HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 29 Nov 2020 08:09:50 GMT
Date: Sun, 29 Nov 2020 08:09:50 GMT

< 
{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/api/profile"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/api/greeting?name=Paul
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /api/greeting?name=Paul HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 29 Nov 2020 08:10:36 GMT
Date: Sun, 29 Nov 2020 08:10:36 GMT

< 
* Connection #0 to host localhost left intact
{"id":1,"message":"Hi, Paul!"}
$ curl -v -i http://localhost:8090/api/greeting
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /api/greeting HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 29 Nov 2020 08:11:05 GMT
Date: Sun, 29 Nov 2020 08:11:05 GMT

< 
* Connection #0 to host localhost left intact
{"id":2,"message":"Hi, user!"}
```
