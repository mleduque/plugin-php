/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.ide.ext.php.client.wizard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/** @author Vladyslav Zhukovskii */
public class PHPPageViewImpl implements PHPPageView {

    private static PHPPageViewImplUiBinder ourUiBinder = GWT.create(PHPPageViewImplUiBinder.class);
    private final DockLayoutPanel rootElement;

    interface PHPPageViewImplUiBinder extends UiBinder<DockLayoutPanel, PHPPageViewImpl> {
    }

    public PHPPageViewImpl() {
        rootElement = ourUiBinder.createAndBindUi(this);
    }

    @Override
    public void setDelegate(ActionDelegate delegate) {
        // nothing to do
    }

    @Override
    public Widget asWidget() {
        return rootElement;
    }
}
