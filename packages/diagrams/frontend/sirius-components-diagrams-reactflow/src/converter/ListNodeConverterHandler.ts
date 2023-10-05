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
import { Node, XYPosition } from 'reactflow';
import { GQLNodeDescription } from '../graphql/query/nodeDescriptionFragment.types';
import {
  GQLNode,
  GQLNodeStyle,
  GQLRectangularNodeStyle,
  GQLViewModifier,
} from '../graphql/subscription/nodeFragment.types';
import { BorderNodePositon } from '../renderer/DiagramRenderer.types';
import { ListNodeData } from '../renderer/node/ListNode.types';
import { convertLabelStyle } from './convertDiagram';
import { AlignmentMap } from './convertDiagram.types';
import { IConvertEngine, INodeConverterHandler } from './ConvertEngine.types';

const defaultPosition: XYPosition = { x: 0, y: 0 };

const toListNode = (
  gqlNode: GQLNode<GQLRectangularNodeStyle>,
  gqlParentNode: GQLNode<GQLNodeStyle> | null,
  nodeDescription: GQLNodeDescription | undefined,
  isBorderNode: boolean
): Node<ListNodeData> => {
  const {
    targetObjectId,
    targetObjectLabel,
    targetObjectKind,
    descriptionId,
    insideLabel,
    id,
    state,
    style,
    labelEditable,
  } = gqlNode;

  const data: ListNodeData = {
    targetObjectId,
    targetObjectLabel,
    targetObjectKind,
    descriptionId,
    style: {
      backgroundColor: style.color,
      borderColor: style.borderColor,
      borderRadius: style.borderRadius,
      borderWidth: style.borderSize,
      borderStyle: style.borderStyle,
    },
    label: undefined,
    isBorderNode: isBorderNode,
    borderNodePosition: isBorderNode ? BorderNodePositon.WEST : null,
    faded: state === GQLViewModifier.Faded,
    labelEditable,
    nodeDescription,
    defaultWidth: gqlNode.defaultWidth,
    defaultHeight: gqlNode.defaultHeight,
  };

  if (insideLabel) {
    const labelStyle = insideLabel.style;
    data.label = {
      id: insideLabel.id,
      text: insideLabel.text,
      iconURL: labelStyle.iconURL,
      isHeader: insideLabel.isHeader,
      displayHeaderSeparator: insideLabel.displayHeaderSeparator,
      style: {
        display: 'flex',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        padding: '8px 16px',
        textAlign: 'center',
        ...convertLabelStyle(labelStyle),
      },
    };

    const alignement = AlignmentMap[insideLabel.insideLabelLocation];
    if (alignement.isPrimaryVerticalAlignment) {
      if (alignement.primaryAlignment === 'TOP') {
        if (data.label.displayHeaderSeparator) {
          data.label.style.borderBottom = `${style.borderSize}px ${style.borderStyle} ${style.borderColor}`;
        }
        data.style = { ...data.style, display: 'flex', flexDirection: 'column', justifyContent: 'flex-start' };
      }
      if (alignement.secondaryAlignment === 'CENTER') {
        data.style = { ...data.style, alignItems: 'stretch' };
        data.label.style = { ...data.label.style, justifyContent: 'center' };
      }
    }
  }

  const node: Node<ListNodeData> = {
    id,
    type: 'listNode',
    data,
    position: defaultPosition,
    hidden: state === GQLViewModifier.Hidden,
  };

  if (gqlParentNode) {
    node.parentNode = gqlParentNode.id;
  }

  return node;
};

export class ListNodeConverterHandler implements INodeConverterHandler {
  canHandle(gqlNode: GQLNode<GQLNodeStyle>) {
    return gqlNode.style.__typename === 'RectangularNodeStyle' && gqlNode.childrenLayoutStrategy?.kind === 'List';
  }

  handle(
    convertEngine: IConvertEngine,
    gqlNode: GQLNode<GQLRectangularNodeStyle>,
    parentNode: GQLNode<GQLNodeStyle> | null,
    isBorderNode: boolean,
    nodes: Node[],
    nodeDescriptions: GQLNodeDescription[]
  ) {
    const nodeDescription = nodeDescriptions.find((description) => description.id === gqlNode.descriptionId);
    nodes.push(toListNode(gqlNode, parentNode, nodeDescription, isBorderNode));
    convertEngine.convertNodes(gqlNode.borderNodes ?? [], gqlNode, nodes, nodeDescriptions);
    convertEngine.convertNodes(gqlNode.childNodes ?? [], gqlNode, nodes, nodeDescriptions);
  }
}
