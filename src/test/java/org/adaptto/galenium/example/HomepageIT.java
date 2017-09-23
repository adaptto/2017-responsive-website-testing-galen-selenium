/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2017 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.adaptto.galenium.example;

import static io.wcm.qa.galenium.util.VerificationUtil.verify;

import org.adaptto.galenium.example.constants.Paths;
import org.adaptto.galenium.example.constants.Selectors;
import org.adaptto.galenium.example.verifications.LogoVerification;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import io.wcm.qa.galenium.listeners.RetryAnalyzer;
import io.wcm.qa.galenium.util.TestDevice;
import io.wcm.qa.galenium.util.VerificationUtil;
import io.wcm.qa.galenium.verification.CssClassVerification;
import io.wcm.qa.galenium.verification.CurrentUrlVerification;
import io.wcm.qa.galenium.verification.InvisibilityVerification;
import io.wcm.qa.galenium.verification.LinkTargetVerification;
import io.wcm.qa.galenium.verification.NoCssClassVerification;
import io.wcm.qa.galenium.verification.PageTitleVerification;
import io.wcm.qa.galenium.verification.VisibilityVerification;

public class HomepageIT extends AbstractExampleBase {

  private static final String CSS_CLASS_NAVLINK_ACTIVE = "navlink-active";
  @Factory(dataProviderClass = TestDeviceProvider.class, dataProvider = "devices")
  public HomepageIT(TestDevice testDevice) {
    super(testDevice);
  }

  @Override
  protected String getRelativePath() {
    return Paths.PATH_TO_HOMEPAGE;
  }

  @Test(groups = "dev", retryAnalyzer = RetryAnalyzer.class)
  public void verificationTest() {
    loadStartUrl();
    verify(
        new CurrentUrlVerification("Homepage"),
        new PageTitleVerification("Homepage"),
        new LogoVerification(),
        new VisibilityVerification(Selectors.SELECTOR_STAGE));
    if (isMobile()) {
      verify(
          new InvisibilityVerification(Selectors.SELECTOR_NAV_LINK_HOME),
          new InvisibilityVerification(Selectors.SELECTOR_NAV_LINK_CONFERENCE));
    }
    else {
      verify(
          new CssClassVerification(Selectors.SELECTOR_NAV_LINK_HOME, CSS_CLASS_NAVLINK_ACTIVE),
          new NoCssClassVerification(Selectors.SELECTOR_NAV_LINK_CONFERENCE, CSS_CLASS_NAVLINK_ACTIVE));
    }
    VerificationUtil.verify(new LinkTargetVerification(Selectors.SELECTOR_LOGO));
  }
}
