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

package local.mocaccino.community.controller.search;

import local.mocaccino.community.model.Contest;
import local.mocaccino.community.service.ContestHibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contest/search")
public class ContestRestSearchController {

    @Autowired
    private ContestHibernateSearchService contestHibernateSearchService;

    @GetMapping
    public ResponseEntity<?> search(
            @RequestParam(value = "query", required = false) String query, Model model
    ) {
        List<Contest> contests = contestHibernateSearchService.contestNameFuzzySearch(query);
        if (contests != null) {
            // TODO
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
