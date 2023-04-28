/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import rest.CommentResource;
import rest.StateResource;
import rest.SubjectResource;
import rest.TagResource;
import rest.TicketResource;
import rest.UserResource;
import rest.UserSupportResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(UserResource.class);
        clazzes.add(UserSupportResource.class);
        clazzes.add(TagResource.class);
        clazzes.add(TicketResource.class);
        clazzes.add(SubjectResource.class);
        clazzes.add(StateResource.class);
        clazzes.add(CommentResource.class);
        clazzes.add(OpenApiResource.class);
        return clazzes;
    }

}
