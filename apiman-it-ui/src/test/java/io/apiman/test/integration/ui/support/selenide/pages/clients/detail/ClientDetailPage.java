/*
 * Copyright 2016 Red Hat Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apiman.test.integration.ui.support.selenide.pages.clients.detail;

import io.apiman.test.integration.ui.support.selenide.Layout;
import io.apiman.test.integration.ui.support.selenide.PageLocation;

/**
 * Created by Jarek Kaspar
 */
@Layout
@PageLocation("/apimanui/api-manager/orgs/{0}/clients/{1}")
public class ClientDetailPage extends AbstractClientDetailPage<ClientDetailPage> {
}
