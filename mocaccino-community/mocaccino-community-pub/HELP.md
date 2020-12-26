## for example, to set a reference from employee to company:
```
$ curl -v -i -H "Content-Type:application/hal+json" -d '{"company":"http://localhost:8090/rest/companies/1"}' -X PATCH http://localhost:8090/rest/employees/4
```
## to delete a reference:
```
$ curl -v -i -H "Content-Type:application/hal+json" -d '{"company":""}' -X PATCH http://localhost:8090/rest/employees/3
```
