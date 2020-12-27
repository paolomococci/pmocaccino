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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface EmployeeRestRepository
		extends JpaRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE NAME LIKE :name")
	List<Employee> likeByName(@Param("name") String name);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE SURNAME LIKE :surname")
	List<Employee> likeBySurname(@Param("surname") String surname);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE EMAIL LIKE :email")
	List<Employee> likeByEmail(@Param("email") String email);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE USERNAME LIKE :username")
	List<Employee> likeByUsername(@Param("username") String username);

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE USERNAME = :username")
	Optional<Employee> findByUsername(@Param("username") String username);

	@Transactional
	@Modifying
	@Query(
			nativeQuery = true,
			value = "INSERT INTO EMPLOYEE_CONTEST VALUES(:idEmployee, :idContest)"
	)
	void subscribe(
			@Param("idEmployee") Long idEmployee,
			@Param("idContest") Long idContest
	);

	@Transactional
	@Modifying
	@Query(
			nativeQuery = true,
			value = "DELETE FROM EMPLOYEE_CONTEST WHERE ID_EMPLOYEE = :idEmployee AND ID_CONTEST = :idContest"
	)
	void debar(
			@Param("idEmployee") Long idEmployee,
			@Param("idContest") Long idContest
	);
}
