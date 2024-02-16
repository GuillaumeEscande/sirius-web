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
package org.eclipse.sirius.web;

import java.util.UUID;

/**
 * Interface used to store some test identifiers.
 *
 * @author sbegaudeau
 */
public interface TestIdentifiers {

    UUID INVALID_PROJECT = UUID.fromString("a2bed581-9661-41bf-9217-2870a9dce67c");

    UUID UML_SAMPLE_PROJECT = UUID.fromString("7ba7bda7-13b9-422a-838b-e45a3597e952");
    UUID SYSML_SAMPLE_PROJECT = UUID.fromString("4164c661-e0cb-4071-b25d-8516440bb8e8");
    UUID ECORE_SAMPLE_PROJECT = UUID.fromString("99d336a2-3049-439a-8853-b104ffb22653");
    UUID ECORE_SAMPLE_DOCUMENT = UUID.fromString("48dc942a-6b76-4133-bca5-5b29ebee133d");
    UUID EPACKAGE_OBJECT = UUID.fromString("3237b215-ae23-48d7-861e-f542a4b9a4b8");
}