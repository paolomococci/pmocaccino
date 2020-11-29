# greeting-sub

## curl -v -i http://localhost:8080
```
$ curl -v -i http://localhost:8080
* Rebuilt URL to: http://localhost:8080/
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET / HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 302 
HTTP/1.1 302 
< Location: http://localhost:8080/index.html
Location: http://localhost:8080/index.html
< Content-Language: en-US
Content-Language: en-US
< Content-Length: 0
Content-Length: 0
< Date: Sun, 29 Nov 2020 08:16:55 GMT
Date: Sun, 29 Nov 2020 08:16:55 GMT

< 
* Connection #0 to host localhost left intact
```

## curl -v -i http://localhost:8080/index.html
```
$ curl -v -i http://localhost:8080/index.html
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /index.html HTTP/1.1
> Host: localhost:8080
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
< Last-Modified: Sun, 29 Nov 2020 08:16:33 GMT
Last-Modified: Sun, 29 Nov 2020 08:16:33 GMT
< Cache-Control: no-store
Cache-Control: no-store
< Accept-Ranges: bytes
Accept-Ranges: bytes
< Content-Type: text/html
Content-Type: text/html
< Content-Length: 334
Content-Length: 334
< Date: Sun, 29 Nov 2020 08:19:15 GMT
Date: Sun, 29 Nov 2020 08:19:15 GMT

< 
<!-- this file will later be replaced with the actual front end application -->
* Connection #0 to host localhost left intact
<!DOCTYPE html><html lang="en"><head><meta charset="utf-8"><meta http-equiv="X-UA-Compatible" content="IE=edge"><meta name="viewport" content="width=device-width,initial-scale=1"><title>index</title></head><body><section id="app"></section></body></html>
```
