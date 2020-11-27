import query from '../config/query-config.js'

class ArticleRestQueryService {

  create(article) {
    return query.post("/articles", article);
  }

  read(id) {
    return query.get(`/articles/${id}`);
  }

  readAll() {
    return query.get("/articles")
  }

  update(id, article) {
    return query.put(`/articles/${id}`, article);
  }

  delete(id) {
    return query.delete(`/articles/${id}`);
  }

  find(title) {
    return query.get(`/articles/search/likeByTitle?title=${title}`);
  }

  constructor() {

  }
}

export default new ArticleRestQueryService();
