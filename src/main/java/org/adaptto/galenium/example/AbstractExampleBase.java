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

import static io.wcm.qa.galenium.util.GaleniumContext.getDriver;
import static io.wcm.qa.galenium.util.InteractionUtil.click;
import static io.wcm.qa.galenium.util.InteractionUtil.clickByPartialText;
import static io.wcm.qa.galenium.util.InteractionUtil.getElementOrFail;

import org.adaptto.galenium.example.constants.Selectors;

import io.wcm.qa.galenium.testcase.AbstractGaleniumBase;
import io.wcm.qa.galenium.util.AemUtil;
import io.wcm.qa.galenium.util.TestDevice;

/**
 * Abstract base class for common functionality needed by multiple tests.
 */
public abstract class AbstractExampleBase extends AbstractGaleniumBase {

  /**
   * @param testDevice test device to use for test
   */
  public AbstractExampleBase(TestDevice testDevice) {
    super(testDevice);
  }

  protected void assertRelativePath(String relativePath) {
    String currentUrl = getDriver().getCurrentUrl();
    assertEquals(currentUrl, getBaseUrl() + relativePath, "relative path should be: '" + relativePath + "'");
  }

  protected void clickConferenceNavLink() {
    clickByPartialText(Selectors.SELECTOR_NAV_LINK, "conference");
  }

  /**
   * Override to provide relative path from base URL to form start URL.
   * @return relative path to append to base URL
   */
  protected abstract String getRelativePath();

  protected String getStartUrl() {
    return getBaseUrl() + getRelativePath();
  }

  @Override
  public String getTestName() {
    return "Example." + super.getTestName();
  }

  protected boolean isMobile() {
    return getDevice().getScreenSize().getWidth() < TestDeviceProvider.CUTOFF_MOBILE_WIDTH;
  }

  protected void loadStartUrl() {
    AemUtil.loginToAuthor(getStartUrl());
  }

  private void navShouldBeVisible() {
    getElementOrFail(Selectors.SELECTOR_NAV);
  }

  protected void openNav() {
    navShouldBeVisible();
    if (isMobile()) {
      click(Selectors.SELECTOR_NAV_MENU_OPENER);
      getElementOrFail(Selectors.SELECTOR_NAV_LINK);
    }
  }

}
