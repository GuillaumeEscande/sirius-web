/*******************************************************************************
 * Copyright (c) 2023 Obeo.
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
package org.eclipse.sirius.web.sample.papaya.view;

import java.util.Optional;

import org.eclipse.sirius.components.domain.Domain;
import org.eclipse.sirius.components.domain.Entity;
import org.eclipse.sirius.components.view.NodeDescription;
import org.eclipse.sirius.components.view.ViewFactory;
import org.eclipse.sirius.web.sample.papaya.PapayaDomainProvider;

/**
 * Used to help creating the Papaya view.
 *
 * @author sbegaudeau
 */
public class PapyaViewBuilder {
    private final Domain domain = new PapayaDomainProvider().getDomain();

    public Entity entity(String name) {
        return this.domain.getTypes().stream().filter(entity -> name.equals(entity.getName())).findFirst().orElse(null);
    }

    public String domainType(Entity entity) {
        // @formatter:off
        return Optional.ofNullable(entity)
                .map(Entity::eContainer)
                .filter(Domain.class::isInstance)
                .map(Domain.class::cast)
                .map(Domain::getName)
                .map(domainName -> domainName + "::" + entity.getName())
                .orElse("");
        // @formatter:on
    }

    public NodeDescription createNodeDescription(String entityName) {
        var domainType = this.domainType(this.entity(entityName));
        var nodeDescription = ViewFactory.eINSTANCE.createNodeDescription();
        nodeDescription.setName("Node " + domainType);
        nodeDescription.setDomainType(domainType);
        return nodeDescription;
    }
}