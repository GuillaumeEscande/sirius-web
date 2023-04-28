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
describe('/projects/:projectId/edit - FormDescriptionEditor', () => {
  beforeEach(() => {
    cy.deleteAllProjects();
    cy.createProjectFromTemplate('studio-template').then((res) => {
      const projectId = res.body.data.createProjectFromTemplate.project.id;
      const view_document_id = 'ea57f74d-bc7b-3a7a-81e0-8aef4ee85770';
      cy.createDocument(projectId, view_document_id, 'ViewDocument').then(() => {
        cy.visit(`/projects/${projectId}/edit`);
      });
    });
    cy.getByTestId('ViewDocument').dblclick();
    cy.getByTestId('View').dblclick();
    cy.getByTestId('View-more').click();
    // create the form description
    cy.getByTestId('treeitem-contextmenu').findByTestId('new-object').click();
    //make sure the data are fetched before selecting
    cy.getByTestId('create-object').should('be.enabled');
    cy.getByTestId('childCreationDescription').click();
    cy.get('[data-value="Form Description"]').click();
    cy.getByTestId('create-object').click();
    // create the form description editor
    cy.getByTestId('New Form Description').click();
    cy.getByTestId('New Form Description-more').click();
    cy.getByTestId('treeitem-contextmenu').findByTestId('new-representation').click();
    cy.getByTestId('create-representation').click();
  });

  it('try to move a toolbar action into another empty group', () => {
    // create another group
    const dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-Group').trigger('dragstart', { dataTransfer });
    cy.getByTestId('Page-DropArea').trigger('drop', { dataTransfer });
    // create a toolbar action in the first group
    cy.get('[data-testid^="Group-ToolbarActions-NewAction-"]').eq(0).click();
    // move the toolbar action from the first group to the second one
    cy.getByTestId('ToolbarAction').trigger('dragstart', { dataTransfer });
    cy.get('[data-testid^="Group-ToolbarActions-DropArea-"]').eq(1).trigger('drop', { dataTransfer });
  });

  it('try to create an empty page', () => {
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').should('have.lengthOf', 1);
    const dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-Page').trigger('dragstart', { dataTransfer });
    cy.getByTestId('PageList-DropArea').trigger('drop', { dataTransfer });
    cy.wait(500); // Wait for representation to refresh
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').should('have.lengthOf', 2);
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(1).click();
    cy.get('[title="Group"]').should('exist');
  });

  it('try to rename a page', () => {
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(0).click();
    cy.getByTestId('Label Expression').click().type('Page Rename{enter}');
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').first().should('have.text', 'Page Rename');
  });

  it('try to move a page', () => {
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(0).click();
    cy.getByTestId('Label Expression').click().type('Page 1{enter}');
    const dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-Page').trigger('dragstart', { dataTransfer });
    cy.getByTestId('PageList-DropArea').trigger('drop', { dataTransfer });
    cy.wait(500); // Wait for representation to refresh
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').should('have.lengthOf', 2);
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(1).click();
    cy.wait(500); // Wait for representation to refresh
    cy.getByTestId('Label Expression').click().type('Page 2{enter}');
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(0).should('have.text', 'Page 1');
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(1).should('have.text', 'Page 2');
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(0).trigger('dragstart', { dataTransfer });
    cy.getByTestId('PageList-DropArea').trigger('drop', { dataTransfer });
    cy.wait(500); // Wait for representation to refresh
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(0).should('have.text', 'Page 2');
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').eq(1).should('have.text', 'Page 1');
  });

  it('try to delete a page', () => {
    const dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-Page').trigger('dragstart', { dataTransfer });
    cy.getByTestId('PageList-DropArea').trigger('drop', { dataTransfer });
    cy.wait(500); // Wait for representation to refresh
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').should('have.lengthOf', 2);
    cy.get('[data-testid^="Page-"]').eq(0).click().type('{del}');
    cy.wait(500); // Wait for representation to refresh
    cy.get('[data-testid^="Page-"]').not('[data-testid="Page-DropArea"]').should('have.lengthOf', 1);
  });

  it('try to add group and widget to a page', () => {
    const dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-BarChart').trigger('dragstart', { dataTransfer });
    cy.get('[data-testid^="Group-Widgets-DropArea-"]').eq(0).trigger('drop', { dataTransfer });
    cy.getByTestId('BarChart').should('exist');
  });

  it('can create a slider widget in a Group', () => {
    // Check that the "Slider" widget is available in the list
    cy.getByTestId('FormDescriptionEditor-Slider').should('exist');
    // Create a slider inside the Group
    const dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-Slider').trigger('dragstart', { dataTransfer });
    cy.get('[data-testid^="Group-Widgets-DropArea-"]').trigger('drop', { dataTransfer });
    cy.get('[title="Slider"]').should('be.visible');
  });

  it('can create a slider widget in a Flexbox Container', () => {
    // Check that the "Slider" widget is available in the list
    cy.getByTestId('FormDescriptionEditor-Slider').should('exist');
    // Create a Flexbox inside the Group
    var dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-FlexboxContainer').trigger('dragstart', { dataTransfer });
    cy.get('[data-testid^="Group-Widgets-DropArea-"]').trigger('drop', { dataTransfer });
    cy.get('[title="FlexboxContainer"]').should('be.visible');
    // Create a slider inside the Flexbox
    dataTransfer = new DataTransfer();
    cy.getByTestId('FormDescriptionEditor-Slider').trigger('dragstart', { dataTransfer });
    cy.get('[data-testid^="FlexboxContainer-Widgets-DropArea-"]').trigger('drop', { dataTransfer });
    cy.get('[title="Slider"]').should('be.visible');
  });
});
