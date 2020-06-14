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

package local.example.crm.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import local.example.crm.model.entity.status.ReferentStatus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "referent")
public class ReferentEntity 
		extends TemplateEntity {

	@NotNull
	@NotEmpty
	@Getter
	@Setter
	private String firstName;

	@NotNull
	@NotEmpty
	@Getter
	@Setter
	private String lastName;

	@Email
	@NotNull
	@NotEmpty
	@Getter
	@Setter
	private String email;

	@NotNull
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private ReferentStatus status;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
}
