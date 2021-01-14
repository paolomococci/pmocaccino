import axios from 'axios'
import rest from '../../rest-config'

class CompanyRestService {

    create(data) {
        return rest.post('rest/companies', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return rest.get('rest/companies');
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
        return rest.get(`rest/companies/search/likeByName?name=${name}`);
    }

    readListOfEmployee(uri) {
        return rest.get(`${uri}/employees`);
    }
}

export default new CompanyRestService();
