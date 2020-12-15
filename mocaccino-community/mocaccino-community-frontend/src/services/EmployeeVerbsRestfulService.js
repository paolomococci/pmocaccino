import restful from '../../restful-config'

class EmployeeVerbsRestfulService {
    readAll() {
        return restful.get('/employees');
    }
}

export default new EmployeeVerbsRestfulService();
