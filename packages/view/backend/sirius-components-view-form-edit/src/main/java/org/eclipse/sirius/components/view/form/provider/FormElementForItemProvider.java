/*******************************************************************************
 * Copyright (c) 2023, 2024 Obeo.
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
package org.eclipse.sirius.components.view.form.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.sirius.components.view.form.FormElementFor;
import org.eclipse.sirius.components.view.form.FormFactory;
import org.eclipse.sirius.components.view.form.FormPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.sirius.components.view.form.FormElementFor} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class FormElementForItemProvider extends FormElementDescriptionItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public FormElementForItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addIteratorPropertyDescriptor(object);
            this.addIterableExpressionPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Iterator feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addIteratorPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_FormElementFor_iterator_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_FormElementFor_iterator_feature", "_UI_FormElementFor_type"),
                FormPackage.Literals.FORM_ELEMENT_FOR__ITERATOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Iterable Expression feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    protected void addIterableExpressionPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_FormElementFor_iterableExpression_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_FormElementFor_iterableExpression_feature", "_UI_FormElementFor_type"),
                FormPackage.Literals.FORM_ELEMENT_FOR__ITERABLE_EXPRESSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns FormElementFor.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/FormElementFor.svg"));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected boolean shouldComposeCreationImage() {
        return true;
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((FormElementFor) object).getName();
        return label == null || label.length() == 0 ? this.getString("_UI_FormElementFor_type") : this.getString("_UI_FormElementFor_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(FormElementFor.class)) {
            case FormPackage.FORM_ELEMENT_FOR__ITERATOR:
            case FormPackage.FORM_ELEMENT_FOR__ITERABLE_EXPRESSION:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case FormPackage.FORM_ELEMENT_FOR__CHILDREN:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
     * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createBarChartDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createButtonDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createCheckboxDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createFlexboxContainerDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createImageDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createLabelDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createLinkDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createListDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createMultiSelectDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createPieChartDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createRadioDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createRichTextDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createSelectDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createSplitButtonDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createTextAreaDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createTextfieldDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createTreeDescription()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createFormElementFor()));

        newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.FORM_ELEMENT_FOR__CHILDREN, FormFactory.eINSTANCE.createFormElementIf()));
    }

}
