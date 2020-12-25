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

package local.mocaccino.community.model;

import local.mocaccino.community.validator.constraint.AlphaConstraint;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "EMPLOYEE",
		uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME"}))
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@AlphaConstraint
	@Size(min = 3, max = 14)
	@Column(name = "NAME", columnDefinition = "VARCHAR(15)")
	private String name;

	@AlphaConstraint
	@Size(min = 3, max = 20)
	@Column(name = "SURNAME", columnDefinition = "VARCHAR(21)")
	private String surname;

	@Email
	@Size(min = 8, max = 60)
	@Column(name = "EMAIL", columnDefinition = "VARCHAR(61)")
	private String email;

	@AlphaConstraint
	@Size(min = 5, max = 30)
	@Column(name = "PROFESSION", columnDefinition = "VARCHAR(31)")
	private String profession;

	@Size(min = 6, max = 20)
	@Column(name = "USERNAME", unique = true, nullable = false, columnDefinition = "VARCHAR(21)")
	private String username;

	@ManyToOne
	@JoinColumn(name = "ID_COMPANY")
	private Company company;

	@ManyToMany(targetEntity = Contest.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "EMPLOYEE_CONTEST",
			joinColumns = {@JoinColumn(name = "ID_EMPLOYEE")},
			inverseJoinColumns = {@JoinColumn(name = "ID_CONTEST")}
	)
	private List<Contest> contests;
}
