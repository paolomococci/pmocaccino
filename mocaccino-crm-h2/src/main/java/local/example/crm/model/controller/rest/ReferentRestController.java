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

package local.example.crm.model.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.crm.model.assembler.ReferentRepresentationModelAssembler;
import local.example.crm.model.repository.rest.ReferentRestRepository;

@RepositoryRestController
@RequestMapping(path = "/api/referents")
public class ReferentRestController {

	@Autowired
	ReferentRestRepository referentRestRepository;

	@Autowired
	ReferentRepresentationModelAssembler referentRepresentationModelAssembler;
}
