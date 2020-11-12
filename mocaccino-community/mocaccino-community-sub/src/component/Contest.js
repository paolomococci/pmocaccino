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

import React, {Component} from 'react';
import { Alert } from 'reactstrap';

export default class Contest extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isLoading: true,
            contests: []
        };
    }

    async componentDidMount() {
        const response = await fetch('http://localhost:8000/rest/contests');
        const bodyOfResponse = await response.json();
        this.setState({ contests: bodyOfResponse, isLoading: false });
    }

    render() {
        const {contests, isLoading} = this.state;

        if (isLoading) {
            return (
                <div className="container">
                    <Alert color="primary">loading data, wait please...</Alert>
                </div>
            )
        }

        return (
            <div className="container">
                <h2 className="h2">Contest</h2>
                {
                    contests.map(contest => <div key={contest.id}>contest.name</div>)
                }
            </div>
        )
    }
}
