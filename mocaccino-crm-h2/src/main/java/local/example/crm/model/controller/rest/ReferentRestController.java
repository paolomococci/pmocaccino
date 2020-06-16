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

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.crm.model.assembler.ReferentRepresentationModelAssembler;
import local.example.crm.model.entity.ReferentEntity;
import local.example.crm.model.exception.ReferentNotFoundException;
import local.example.crm.model.repository.rest.ReferentRestRepository;

@RepositoryRestController
@RequestMapping(path = "/api/referents")
public class ReferentRestController {

	@Autowired
	ReferentRestRepository referentRestRepository;

	@Autowired
	ReferentRepresentationModelAssembler referentRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ReferentEntity referent) 
			throws URISyntaxException {
		EntityModel<ReferentEntity> entityModelOfReferent;
		entityModelOfReferent = referentRepresentationModelAssembler
				.toModel(referentRestRepository.save(referent));
		return new ResponseEntity<>(entityModelOfReferent, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		ReferentEntity referent = referentRestRepository.findById(id)
				.orElseThrow(() -> new ReferentNotFoundException(id));
		EntityModel<ReferentEntity> entityModelOfReferent;
		entityModelOfReferent = referentRepresentationModelAssembler.toModel(referent);
		return new ResponseEntity<>(entityModelOfReferent, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<ReferentEntity> referents = referentRestRepository.findAll();
		CollectionModel<EntityModel<ReferentEntity>> collectionModelOfReferents;
		collectionModelOfReferents = referentRepresentationModelAssembler
				.toCollectionModel(referents);
		return new ResponseEntity<>(collectionModelOfReferents, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody ReferentEntity referentUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		 ReferentEntity temporaryEntityOfReferent = referentRestRepository.findById(id)
				.map(referent -> {
					referent.setName(referentUpdated.getName());
					return referentRestRepository.save(referent);
				}).orElseGet(() -> {
					return referentRestRepository.save(referentUpdated);
				});
		EntityModel<ReferentEntity> entityModelOfReferent;
		entityModelOfReferent = referentRepresentationModelAssembler
				.toModel(temporaryEntityOfReferent);
		return new ResponseEntity<>(entityModelOfReferent, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody ReferentEntity referentUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		ReferentEntity temporaryEntityOfReferent = referentRestRepository.findById(id)
				.map(referent -> {
					if (referentUpdated.getName() != null) {
						referent.setName(referentUpdated.getName());
					}
					// TODO
					return referentRestRepository.save(referent);
				}).orElseGet(() -> {
					return referentRestRepository.save(referentUpdated);
				});
		EntityModel<ReferentEntity> entityModelOfReferent;
		entityModelOfReferent = referentRepresentationModelAssembler
				.toModel(temporaryEntityOfReferent);
		return new ResponseEntity<>(entityModelOfReferent, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		referentRestRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
