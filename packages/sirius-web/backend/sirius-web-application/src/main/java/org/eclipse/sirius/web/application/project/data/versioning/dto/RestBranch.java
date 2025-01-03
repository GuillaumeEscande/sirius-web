/*******************************************************************************
 * Copyright (c) 2024 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.web.application.project.data.versioning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import org.eclipse.sirius.web.application.dto.Identified;

/**
 * REST Branch DTO.
 *
 * @author arichard
 */
public record RestBranch(
        @JsonProperty("@id") UUID id,
        @JsonProperty("@type") String type,
        OffsetDateTime created,
        Identified head,
        String name,
        Identified owningProject,
        Identified referencedCommit) {

    public RestBranch {
        Objects.requireNonNull(id);
        Objects.requireNonNull(type);
        Objects.requireNonNull(created);
        // head can be null
        Objects.requireNonNull(name);
        Objects.requireNonNull(owningProject);
        Objects.requireNonNull(referencedCommit);
    }

    public RestBranch(
            UUID id,
            OffsetDateTime created,
            Identified head,
            String name,
            Identified owningProject,
            Identified referencedCommit) {
        this(id, "Branch", created, head, name, owningProject, referencedCommit);
    }
}
