import axios from 'axios'
import restful from '../../restful-config'

class EmployeeVerbsRestfulService {

    create(data) {
        return restful.post('/employees', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/employees');
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
        return restful.get(`/employees/search/likeByName?name=${name}`);
    }

    searchBySurname(surname) {
        return restful.get(`/employees/search/likeBySurname?surname=${surname}`);
    }

    searchByEmail(email) {
        return restful.get(`/employees/search/likeByEmail?email=${email}`);
    }

    searchByUsername(username) {
        return restful.get(`/employees/search/likeByUsername?username=${username}`);
    }

    // reference's methods

    readCompanyMembership(uri) {
        return restful.get(`${uri}/company`);
    }

    updateReferenceToCompany(uri, data) {
        return axios.patch(uri, data);
    }

    deleteCompanyMembership(uri) {
        return axios.patch(uri, {company: null});
    }

    readContestParticipation(uri) {
        return restful.get(`${uri}/contests`);
    }

    updateContestParticipation(data) {
        return axios.patch('http://127.0.0.1:8090/api/references/subscribe', data);
    }

    deleteContestParticipation(data) {
        return axios.patch('http://127.0.0.1:8090/api/references/debar', data);
    }
}

export default new EmployeeVerbsRestfulService();
