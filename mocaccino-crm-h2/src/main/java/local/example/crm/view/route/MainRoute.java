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

package local.example.crm.view.route;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route("")
@RouteAlias("main")
@PageTitle("main page")
public class MainRoute 
		extends AppLayout {

	private static final long serialVersionUID = -6602780017976528238L;

	@SuppressWarnings("unused")
	private Tabs tabs;
	@SuppressWarnings("unused")
	private Map<Tab, Component> workspace;
	@SuppressWarnings("unused")
	private Label title;

	@Autowired
	public MainRoute() {
		super();
		this.title = new Label("mocaccino crm");
		this.workspace = new HashMap<>();
		this.tabs = new Tabs();
	}
}
