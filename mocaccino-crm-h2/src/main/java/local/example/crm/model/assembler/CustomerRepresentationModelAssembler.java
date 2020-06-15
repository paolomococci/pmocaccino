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

package local.example.crm.model.assembler;

import java.net.URISyntaxException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import local.example.crm.model.controller.rest.CustomerRestController;
import local.example.crm.model.entity.CustomerEntity;

@Component
public class CustomerRepresentationModelAssembler 
		implements RepresentationModelAssembler<CustomerEntity, EntityModel<CustomerEntity>> {

	@Override
	public EntityModel<CustomerEntity> toModel(CustomerEntity customer) {
		try {
			EntityModel<CustomerEntity> entityModelOfCustomer = EntityModel.of(customer, 
					linkTo(methodOn(CustomerRestController.class).read(customer.getId())).withSelfRel(), 
					linkTo(methodOn(CustomerRestController.class).readAll()).withRel("customers"));
			return entityModelOfCustomer;
		} catch (URISyntaxException uriException) {
			uriException.printStackTrace();
		}
		return EntityModel.of(new CustomerEntity());
	}

	@Override
	public CollectionModel<EntityModel<CustomerEntity>> toCollectionModel(
			Iterable<? extends CustomerEntity> customers) {
		return RepresentationModelAssembler.super.toCollectionModel(customers);
	}
}
