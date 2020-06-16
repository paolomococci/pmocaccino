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

package local.example.crm.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.example.crm.model.entity.CustomerEntity;
import local.example.crm.model.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<CustomerEntity> findAll() {
		return customerRepository.findAll();
	}

	public Map<String, Integer> getReferentsNumberForCustomer() {
		HashMap<String, Integer> referentsNumberForCustomer = new HashMap<>();
		this.findAll().forEach(
				customer -> referentsNumberForCustomer
					.put(customer.getName(), customer.getReferents().size())
		);
		return referentsNumberForCustomer;
	}
}
