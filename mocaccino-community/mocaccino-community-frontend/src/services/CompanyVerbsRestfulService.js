import axios from 'axios'
import restful from '../../restful-config'

class CompanyVerbsRestfulService {

    create(data) {
        return restful.post('/companies', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/companies');
    }

    update(uri, data) {
        return axios.put(uri, data);
    }

    partialUpdate(uri, data) {
        return axios.patch(uri, data);
    }

    delete(uri) {
        return axios.delete(uri);
    }

    searchByName(name) {
        return restful.get(`/companies/search/likeByName?name=${name}`);
    }

    readListOfEmployee(uri) {
        return restful.get(`${uri}/employees`);
    }
}

export default new CompanyVerbsRestfulService();
