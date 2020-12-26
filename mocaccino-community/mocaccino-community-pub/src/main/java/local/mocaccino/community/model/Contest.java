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

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CONTEST",
        uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @AlphaConstraint
    @Size(min = 10, max = 20)
    @Column(name = "NAME", unique = true, nullable = false, columnDefinition = "VARCHAR(21)")
    private String name;

    @AlphaConstraint
    @Size(min = 8, max = 30)
    @Column(name = "TITLE", columnDefinition = "VARCHAR(31)")
    private String title;

    @AlphaConstraint
    @Size(min = 20, max = 50)
    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(51)")
    private String description;

    @FutureOrPresent
    @Column(name = "DATE")
    private Date date;

    @ManyToMany(targetEntity = Employee.class,
            mappedBy = "contests",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    private List<Employee> participants;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public List<Employee> getParticipants() {
        return participants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
