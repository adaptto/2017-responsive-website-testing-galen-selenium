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
package org.adaptto.galenium.example.constants;

import io.wcm.qa.galenium.selectors.Selector;
import io.wcm.qa.galenium.selectors.SelectorFactory;

/**
 * Selectors for use throughout project.
 */
public final class Selectors {

  public static final Selector SELECTOR_LOGO = SelectorFactory.fromCss("Logo", "#top");
  public static final Selector SELECTOR_NAV = SelectorFactory.fromCss("nav");
  public static final Selector SELECTOR_NAV_LINK = SelectorFactory.fromCss("a.navlink-main");
  public static final Selector SELECTOR_NAV_LINK_CONFERENCE = SelectorFactory.fromCss(
      "Navlink Conference",
      ".navlist-main a.navlink-main[href$='" + Paths.PATH_TO_CONFERENCE_PAGE + "'");
  public static final Selector SELECTOR_NAV_LINK_HOME = SelectorFactory.fromCss(
      "Navlink Home",
      ".navlist-main a.navlink-main[href$='" + Paths.PATH_TO_HOMEPAGE + "'");
  public static final Selector SELECTOR_NAV_MENU_OPENER = SelectorFactory.fromCss("a.menu-opener");
  public static final Selector SELECTOR_STAGE = SelectorFactory.fromCss("Stage", "#stage");

  private Selectors() {
    // do not instantiate
  }
}
