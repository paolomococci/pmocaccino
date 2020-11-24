import restfulQuery from '../axios-settings'

class RestfulQueryService {
  
  create(employee) {
    return restfulQuery.post("/employees", employee);
  }
  
  read(id) {
    return restfulQuery.get("/employees/"+id);
  }
  
  readAll() {
    return restfulQuery.get("/employees");
  }
  
  update(id, employee) {
    return restfulQuery.put("/employees/"+id, employee);
  }
  
  delete(id) {
    return restfulQuery.delete("/employees/"+id);
  }
  
  likeByName(name) {
    return restfulQuery.get("/employees/search/likeByName?name="+name);
  }
  
  likeBySurname(surname) {
    return restfulQuery.get("/employees/search/likeBySurname?surname="+surname);
  }
  
  likeByEmail(email) {
    return restfulQuery.get("/employees/search/likeByEmail?email="+email);
  }
  
  likeByUsername(username) {
    return restfulQuery.get("/employees/search/likeByUsername?username="+username);
  }
}

export default new RestfulQueryService();
