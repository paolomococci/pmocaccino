# article-crud-pub

```
$ curl -v -i http://localhost:8090/rest
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest HTTP/1.1
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
< Date: Thu, 26 Nov 2020 04:56:15 GMT
Date: Thu, 26 Nov 2020 04:56:15 GMT

< 
{
  "_links" : {
    "articles" : {
      "href" : "http://localhost:8090/rest/articles{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/profile
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/profile HTTP/1.1
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
< Date: Thu, 26 Nov 2020 05:02:50 GMT
Date: Thu, 26 Nov 2020 05:02:50 GMT

< 
{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/profile"
    },
    "articles" : {
      "href" : "http://localhost:8090/rest/profile/articles"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/profile/articles
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/profile/articles HTTP/1.1
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
< Content-Type: application/alps+json
Content-Type: application/alps+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 26 Nov 2020 05:03:29 GMT
Date: Thu, 26 Nov 2020 05:03:29 GMT

< 
{
  "alps" : {
    "version" : "1.0",
    "descriptor" : [ {
      "id" : "article-representation",
      "href" : "http://localhost:8090/rest/profile/articles",
      "descriptor" : [ {
        "name" : "title",
        "type" : "SEMANTIC"
      }, {
        "name" : "description",
        "type" : "SEMANTIC"
      }, {
        "name" : "published",
        "type" : "SEMANTIC"
      } ]
    }, {
      "id" : "get-articles",
      "name" : "articles",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "page",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The page to return."
        }
      }, {
        "name" : "size",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The size of the page to return."
        }
      }, {
        "name" : "sort",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The sorting criteria to use to calculate the content of the page."
        }
      } ],
      "rt" : "#article-representation"
    }, {
      "id" : "create-articles",
      "name" : "articles",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#article-representation"
    }, {
      "id" : "patch-article",
      "name" : "article",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#article-representation"
    }, {
      "id" : "get-article",
      "name" : "article",
      "type" : "SAFE",
      "descriptor" : [ ],
      "rt" : "#article-representation"
    }, {
      "id" : "update-article",
      "name" : "article",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#article-representation"
    }, {
      "id" : "delete-article",
      "name" : "article",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#article-representation"
    }, {
      "name" : "likeByTitle",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "title",
        "type" : "SEMANTIC"
      } ]
    } ]
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/articles
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/articles HTTP/1.1
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
< Date: Thu, 26 Nov 2020 05:04:30 GMT
Date: Thu, 26 Nov 2020 05:04:30 GMT

< 
{
  "_embedded" : {
    "articles" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/articles"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/articles"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/articles/search"
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
$ curl -v -i http://localhost:8090/rest/articles/search
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/articles/search HTTP/1.1
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
< Date: Thu, 26 Nov 2020 05:09:14 GMT
Date: Thu, 26 Nov 2020 05:09:14 GMT

< 
{
  "_links" : {
    "likeByTitle" : {
      "href" : "http://localhost:8090/rest/articles/search/likeByTitle{?title}",
      "templated" : true
    },
    "self" : {
      "href" : "http://localhost:8090/rest/articles/search"
    }
  }
* Connection #0 to host localhost left intact
}
```
