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

import { SelectionEntry } from '@eclipse-sirius/sirius-components-core';
import { GQLReferenceWidget } from '../ReferenceWidgetFragment.types';

export interface TransferModalProps {
  editingContextId: string;
  widget: GQLReferenceWidget;
  onClose: (selectedElementIds: string[]) => void;
}

export interface TransferModalState {
  leftSelection: SelectionEntry[];
  right: SelectionEntry[];
  rightSelection: SelectionEntry[];
  draggingRightItemId: string | undefined;
}