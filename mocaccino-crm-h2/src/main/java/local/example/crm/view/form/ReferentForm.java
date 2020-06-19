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

package local.example.crm.view.form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

import local.example.crm.model.entity.CustomerEntity;
import local.example.crm.model.entity.ReferentEntity;
import local.example.crm.model.entity.status.ReferentStatus;

public class ReferentForm 
		extends FormLayout {

	private static final long serialVersionUID = 757894659328506777L;

	TextField name, firstName, lastName;
	EmailField email;
	ComboBox<ReferentStatus> status;
	ComboBox<CustomerEntity> customer;
	Button save, delete, cancel;

	Binder<ReferentEntity> referentBinder;

	@Autowired
	public ReferentForm(List<CustomerEntity> customers) {
		super();
		this.name = new TextField();
		this.firstName = new TextField();
		this.lastName = new TextField();
		this.email = new EmailField();
		this.status = new ComboBox<>();
		this.customer = new ComboBox<>();
		this.referentBinder = new BeanValidationBinder<>(ReferentEntity.class);
		this.save = new Button();
		this.delete = new Button();
		this.cancel = new Button();
	}
}
