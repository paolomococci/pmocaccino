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

import React from 'react';
import { Card, CardBody, CardTitle, CardSubtitle, CardText, CardLink } from 'reactstrap';

const ContestView = ({contests}) => {

    return(
        <div>
            <h1>list of contest</h1>
            {contests.map((contest) => (
                <div>
                    <Card>
                        <CardBody>
                            <CardTitle>{contest.name}</CardTitle>
                            <CardSubtitle>{contest.title}</CardSubtitle>
                            <CardText>{contest.description}</CardText>
                            <CardLink href="#">update</CardLink>
                            <CardLink href="#">delete</CardLink>
                        </CardBody>
                    </Card>
                </div>
            ))}
        </div>
    );
};

export default ContestView;
