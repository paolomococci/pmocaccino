import restful from '../../restful-config'

class CompanyVerbsRestfulService {
    readAll() {
        return restful.get('/companies');
    }
}

export default new CompanyVerbsRestfulService();
