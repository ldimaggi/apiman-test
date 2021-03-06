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

package io.apiman.test.integration.rest.apis.metrics;

import static org.junit.Assert.assertEquals;

import io.apiman.manager.api.beans.metrics.UsagePerPlanBean;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * @author jkaspar
 */
public class PlanUsageMetricsIT extends AbstractMetricsIT {

    @Test
    public void requestsAfterIntervalAreNotIncluded() throws Exception {
        UsagePerPlanBean metricsBefore = apiVersions.metricsPlanUsage(beforeRecoding, afterRecording);
        recordSuccessfulRequests(1, apiKey_Client1v1);
        recordFailedRequests(2, apiKey_Client1v1);
        TimeUnit.SECONDS.sleep(TIME_DELAY);
        UsagePerPlanBean metricsAfter = apiVersions.metricsPlanUsage(beforeRecoding, afterRecording);

        assertEquals("Unexpected metrics data",
                metricsBefore.getData().get(plan.getId()),
                metricsAfter.getData().get(plan.getId()));
    }

    @Test
    public void sumsOfRequestsForEachPlanAreCorrect() throws Exception {
        UsagePerPlanBean metrics = apiVersions.metricsPlanUsage(beforeRecoding, afterRecording);
        assertEquals("Unexpected metrics data for plan",
                new Long(PLAN1_SUCC + PLAN1_FAIL),
                metrics.getData().get(plan.getId()));

        assertEquals("Unexpected metrics data for plan2",
                new Long(PLAN2_SUCC + PLAN2_FAIL),
                metrics.getData().get(plan2.getId()));
    }
}
