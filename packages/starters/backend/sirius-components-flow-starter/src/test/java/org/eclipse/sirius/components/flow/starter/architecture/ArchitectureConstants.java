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
package org.eclipse.sirius.components.flow.starter.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

/**
 * Constants shared across multiple tests.
 *
 * @author frouene
 */
public final class ArchitectureConstants {

    public static final String SIRIUS_COMPONENTS_FLOW_STARTER_ROOT_PACKAGE = "org.eclipse.sirius.components.flow.starter..";

    public static final JavaClasses CLASSES = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages(SIRIUS_COMPONENTS_FLOW_STARTER_ROOT_PACKAGE);

    private ArchitectureConstants() {
        // Prevent instantiation
    }
}