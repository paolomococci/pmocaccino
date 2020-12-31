# How to manage the relationships between entities in this demo

## for example, to set a reference from employee to company:
```
$ curl -v -i -H "Content-Type:application/hal+json" -d '{"company":"http://localhost:8090/rest/companies/1"}' -X PATCH http://localhost:8090/rest/employees/3
```
### to delete a reference:
```
$ curl -v -i -H "Content-Type:application/hal+json" -d '{"company":""}' -X PATCH http://localhost:8090/rest/employees/3
```

## to set a reference from employee to contest, thanks to @PathVariable and @RequestParam:
```
$ curl -v -i  http://localhost:8090/api/references/subscribe/johndoe?contestId=2
```
### to delete the reference just set
```
$ curl -v -i  http://localhost:8090/api/references/debar/johndoe?contestId=2
```

## to set a reference from employee to contest, thanks to @RequestBody:
```
$ curl -v -i -H "Content-Type:application/json" -d '{"employeeId":3,"contestId":2}' http://127.0.0.1:8090/api/references/subscribe
```
### to delete the reference just set
```
$ curl -v -i -H "Content-Type:application/json" -d '{"employeeId":3,"contestId":2}' http://127.0.0.1:8090/api/references/debar
```

## manage the relationships between URIs
```
$ curl -v -i -H "Content-Type:application/json" -d '{"employeeUri":"http://localhost:8090/rest/employees/3","contestUri":"http://127.0.0.1:8090/rest/contests/2"}' -X PATCH http://127.0.0.1:8090/api/references/subscribe
```
### to delete the reference just set
```
$ curl -v -i -H "Content-Type:application/json" -d '{"employeeUri":"http://localhost:8090/rest/employees/3","contestUri":"http://127.0.0.1:8090/rest/contests/2"}' -X PATCH http://127.0.0.1:8090/api/references/debar
```
