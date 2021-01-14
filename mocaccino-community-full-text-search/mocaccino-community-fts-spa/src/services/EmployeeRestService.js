import axios from 'axios'
import rest from '../../rest-config'

class EmployeeRestService {

    create(data) {
        return rest.post('rest/employees', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return rest.get('rest/employees');
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
        return rest.get(`rest/employees/search/likeByName?name=${name}`);
    }

    searchBySurname(surname) {
        return rest.get(`rest/employees/search/likeBySurname?surname=${surname}`);
    }

    searchByEmail(email) {
        return rest.get(`rest/employees/search/likeByEmail?email=${email}`);
    }

    searchByUsername(username) {
        return rest.get(`rest/employees/search/likeByUsername?username=${username}`);
    }

    // reference's methods

    readCompanyMembership(uri) {
        return rest.get(`${uri}/company`);
    }

    updateReferenceToCompany(uri, data) {
        return axios.patch(uri, data);
    }

    deleteCompanyMembership(uri) {
        return axios.patch(uri, {company: null});
    }

    readContestParticipation(uri) {
        return rest.get(`${uri}/contests`);
    }

    updateContestParticipation(data) {
        return axios.patch('http://127.0.0.1:8090/api/references/subscribe', data);
    }

    deleteContestParticipation(data) {
        return axios.patch('http://127.0.0.1:8090/api/references/debar', data);
    }
}

export default new EmployeeRestService();
