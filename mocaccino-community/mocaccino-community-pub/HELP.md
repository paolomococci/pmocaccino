## for example, to set a reference from employee to company:
```
$ curl -v -i -H "Content-Type:application/hal+json" -d '{"company":"http://localhost:8090/rest/companies/1"}' -X PATCH http://localhost:8090/rest/employees/4
```

## after generating a new database I have the following entities completely reset:
```
$ curl -v -i http://localhost:8090/rest/companies
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/companies HTTP/1.1
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
< Date: Thu, 24 Dec 2020 07:49:17 GMT
Date: Thu, 24 Dec 2020 07:49:17 GMT

< 
{
  "_embedded" : {
    "companies" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/companies"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/companies"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/companies/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/employees HTTP/1.1
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
< Date: Thu, 24 Dec 2020 07:50:50 GMT
Date: Thu, 24 Dec 2020 07:50:50 GMT

< 
{
  "_embedded" : {
    "employees" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/employees"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/employees"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/employees/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/contests
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/contests HTTP/1.1
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
< Date: Thu, 24 Dec 2020 07:51:33 GMT
Date: Thu, 24 Dec 2020 07:51:33 GMT

< 
{
  "_embedded" : {
    "contests" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/contests"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/contests"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/contests/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```
