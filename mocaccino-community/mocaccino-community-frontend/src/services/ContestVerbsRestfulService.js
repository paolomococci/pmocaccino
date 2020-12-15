import restful from '../../restful-config'

class ContestVerbsRestfulService {
    readAll() {
        return restful.get('/contests');
    }
}

export default new ContestVerbsRestfulService();
