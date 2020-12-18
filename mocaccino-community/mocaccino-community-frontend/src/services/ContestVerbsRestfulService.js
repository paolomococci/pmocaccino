import axios from 'axios'
import restful from '../../restful-config'

class ContestVerbsRestfulService {

    create(data) {
        return restful.post('/contests', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/contests');
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
        return restful.get(`/contests/search/likeByName?name=${name}`);
    }

    searchByTitle(title) {
        return restful.get(`/contests/search/likeByTitle?title=${title}`);
    }
}

export default new ContestVerbsRestfulService();
