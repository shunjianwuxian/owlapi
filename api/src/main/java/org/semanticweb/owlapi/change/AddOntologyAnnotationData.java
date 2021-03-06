/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, The University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.semanticweb.owlapi.change;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLOntology;

/** Represents the specific non-ontology data required by an
 * {@link AddOntologyAnnotation} change. <br>
 * Instances of this class are immutable.
 * 
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics
 *         Research Group, Date: 27/04/2012
 * @since 3.5 */
public final class AddOntologyAnnotationData extends
        OntologyAnnotationChangeData {
    private static final long serialVersionUID = 30406L;

    /** Constructs an {@link AddOntologyAnnotationData} object that describes an
     * {@link AddOntologyAnnotation} change for the {@link OWLAnnotation}
     * specified by the {@code annotation} parameter.
     * 
     * @param annotation
     *            The {@link OWLAnnotation} that is the focus of some change.
     *            Not {@code null}.
     * @throws NullPointerException
     *             if {@code annotation} is {@code null}. */
    public AddOntologyAnnotationData(OWLAnnotation annotation) {
        super(annotation);
    }

    @Override
    public AddOntologyAnnotation createOntologyChange(OWLOntology ontology) {
        return new AddOntologyAnnotation(ontology, getAnnotation());
    }

    @Override
    public <O, E extends Exception> O accept(
            OWLOntologyChangeDataVisitor<O, E> visitor) throws E {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddOntologyAnnotationData)) {
            return false;
        }
        AddOntologyAnnotationData other = (AddOntologyAnnotationData) obj;
        return getAnnotation().equals(other.getAnnotation());
    }
}
