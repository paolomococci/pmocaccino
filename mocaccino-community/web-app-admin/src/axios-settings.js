import axios from 'axios'

export default axios.create({
        baseUrl: "http://localhost:8090/rest",
        headers: {"Content-Type": "application/hal+json"}
});
