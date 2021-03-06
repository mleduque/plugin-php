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
package com.codenvy.ide.ext.php.client;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.icon.Icon;
import com.codenvy.ide.api.icon.IconRegistry;
import com.codenvy.ide.api.notification.NotificationManager;
import com.codenvy.ide.api.projecttype.wizard.ProjectTypeWizardRegistry;
import com.codenvy.ide.api.projecttype.wizard.ProjectWizard;
import com.codenvy.ide.ext.php.client.wizard.PHPPagePresenter;
import com.codenvy.ide.extension.runner.client.wizard.SelectRunnerPagePresenter;
import com.google.gwt.resources.client.ClientBundle;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import org.vectomatic.dom.svg.ui.SVGResource;

/** @author Vladyslav Zhukovskii */
@Singleton
@Extension(title = "PHP", version = "3.0.0")
public class PHPExtension {
    public interface ParserResource extends ClientBundle {
        @Source("com/codenvy/ide/ext/php/client/image/php.svg")
        SVGResource phpCategoryIcon();
    }

    @Inject
    public PHPExtension(Provider<PHPPagePresenter> phpPagePresenterProvider, Provider<SelectRunnerPagePresenter> runnerPagePresenter,
                        NotificationManager notificationManager, ProjectTypeWizardRegistry projectTypeWizardRegistry,
                        ParserResource parserResource, IconRegistry iconRegistry) {
        ProjectWizard wizard = new ProjectWizard(notificationManager);
        wizard.addPage(phpPagePresenterProvider);
        wizard.addPage(runnerPagePresenter);

        projectTypeWizardRegistry.addWizard("php", wizard);

        iconRegistry.registerIcon(new Icon("php.samples.category.icon", parserResource.phpCategoryIcon()));
    }
}
