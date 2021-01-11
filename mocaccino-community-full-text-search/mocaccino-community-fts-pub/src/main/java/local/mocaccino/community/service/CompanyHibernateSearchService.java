/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.mocaccino.community.service;

import local.mocaccino.community.model.Company;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CompanyHibernateSearchService {

    @Autowired
    private final EntityManager entityManager;

    public CompanyHibernateSearchService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void initHibernateSearch() {
        SearchSession searchSession = Search.session(entityManager);
        try {
            searchSession.massIndexer(Company.class).startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<Company> companyNameFuzzySearch(String termToSearchFor) {
        SearchSession searchSession = Search.session(entityManager);
        SearchResult<Company> companySearchResult = searchSession.search(Company.class)
                .where(
                        find -> find.match().field("name").matching(termToSearchFor)
                ).fetchAll();
        return companySearchResult.hits();
    }
}
