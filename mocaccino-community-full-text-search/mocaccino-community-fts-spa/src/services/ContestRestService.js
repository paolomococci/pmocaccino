import axios from 'axios'
import rest from '../../rest-config'

class ContestRestService {

    create(data) {
        return rest.post('rest/contests', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return rest.get('rest/contests');
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
        return rest.get(`rest/contests/search/likeByName?name=${name}`);
    }

    searchByTitle(title) {
        return rest.get(`rest/contests/search/likeByTitle?title=${title}`);
    }

    readListOfEmployee(uri) {
        return rest.get(`${uri}/participants`);
    }
}

export default new ContestRestService();
