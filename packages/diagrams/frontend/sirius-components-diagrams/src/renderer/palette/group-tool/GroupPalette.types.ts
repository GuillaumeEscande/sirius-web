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

export interface GroupPaletteProps {
  x?: number;
  y?: number;
  isOpened: boolean;
  refElementId: string | null;
  refreshEventPayloadId: string;
  hidePalette: () => void;
}

export interface GroupPaletteState {
  selectedElementIds: string[];
  isMinimalPalette: boolean;
  isDistributeElementToolSectionExpand: boolean;
  lastDistributeElementToolId: string | null;
}

export interface GroupPaletteSectionTool {
  id: string;
  title: string;
  action: () => void;
  icon: JSX.Element;
}
