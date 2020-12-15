import axios from 'axios'
import restful from '../../restful-config'

class CompanyVerbsRestfulService {

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/companies');
    }

    update(uri, data) {
        return axios.post(uri, data);
    }

    delete(uri) {
        return axios.delete(uri);
    }

    searchByName(name) {
        return restful.get(`/companies/search/likeByName?name=${name}`);
    }
}

export default new CompanyVerbsRestfulService();
