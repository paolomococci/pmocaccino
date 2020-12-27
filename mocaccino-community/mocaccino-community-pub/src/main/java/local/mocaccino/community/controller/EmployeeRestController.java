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

package local.mocaccino.community.controller;

import local.mocaccino.community.model.Contest;
import local.mocaccino.community.model.Employee;
import local.mocaccino.community.reference.EmployeeToContestReference;
import local.mocaccino.community.repository.ContestRestRepository;
import local.mocaccino.community.repository.EmployeeRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/references")
public class EmployeeRestController {

    @Autowired
    EmployeeRestRepository employeeRestRepository;

    @Autowired
    ContestRestRepository contestRestRepository;

    @GetMapping("/subscribe/{username}")
    public ResponseEntity<?> subscribeByUsername(
            @PathVariable(value = "username") @NotBlank @Size(min = 6, max = 20) String username,
            @RequestParam(value = "contestId") @Min(1) String contestId
    ) {
        try {
            Optional<Employee> employee = employeeRestRepository
                    .findByUsername(username);
            Optional<Contest> contest = contestRestRepository
                    .findById(Long.parseUnsignedLong(contestId));
            if (employee.isPresent() && contest.isPresent()) {
                employeeRestRepository.subscribe(employee.get().getId(), contest.get().getId());
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/debar/{username}")
    public ResponseEntity<?> debarByUsername(
            @PathVariable(value = "username") @NotBlank @Size(min = 6, max = 20) String username,
            @RequestParam(value = "contestId") @Min(1) String contestId
    ) {
        try {
            Optional<Employee> employee = employeeRestRepository
                    .findByUsername(username);
            Optional<Contest> contest = contestRestRepository
                    .findById(Long.parseUnsignedLong(contestId));
            if (employee.isPresent() && contest.isPresent()) {
                employeeRestRepository.debar(
                        employee.get().getId(),
                        contest.get().getId()
                );
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(
            @RequestBody EmployeeToContestReference reference
    ) {
        try {
            if (reference.isValid()) {
                Optional<Employee> employee = employeeRestRepository
                        .findById(reference.getEmployeeId());
                Optional<Contest> contest = contestRestRepository
                        .findById(reference.getContestId());
                if (employee.isPresent() && contest.isPresent()) {
                    employeeRestRepository.subscribe(employee.get().getId(), contest.get().getId());
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/debar")
    public ResponseEntity<?> debar(
            @RequestBody EmployeeToContestReference reference
    ) {
        try {
            if (reference.isValid()) {
                Optional<Employee> employee = employeeRestRepository
                        .findById(reference.getEmployeeId());
                Optional<Contest> contest = contestRestRepository
                        .findById(reference.getContestId());
                if (employee.isPresent() && contest.isPresent()) {
                    employeeRestRepository.debar(employee.get().getId(), contest.get().getId());
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
