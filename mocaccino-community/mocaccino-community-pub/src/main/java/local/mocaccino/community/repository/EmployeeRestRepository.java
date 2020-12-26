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

package local.mocaccino.community.repository;

import local.mocaccino.community.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface EmployeeRestRepository
		extends JpaRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE NAME LIKE ?1%")
	List<Employee> likeByName(String name);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE SURNAME LIKE ?1%")
	List<Employee> likeBySurname(String surname);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE EMAIL LIKE ?1%")
	List<Employee> likeByEmail(String email);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE USERNAME LIKE ?1%")
	List<Employee> likeByUsername(String username);

	@Query(nativeQuery = true, value = "INSERT INTO EMPLOYEE_CONTEST VALUES(?1%,?2%)")
	void subscribe(Long idEmployee, Long idContest);

	@Query(nativeQuery = true, value = "DELETE FROM EMPLOYEE_CONTEST WHERE ID_EMPLOYEE=?1% AND ID_CONTEST=?2%")
	void debar(Long idEmployee, Long idContest);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE USERNAME=?1%")
	Optional<Employee> findByUsername(String username);
}
