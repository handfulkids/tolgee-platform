package io.tolgee.ee

import io.tolgee.configuration.annotations.DocProperty
import io.tolgee.util.isTolgeeOwnedUrl
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "tolgee.ee")
class EeProperties(
  @DocProperty(hidden = true)
  var licenseServer: String = "",
  @DocProperty(hidden = true)
  var reportUsageFixedDelayInMs: Long = 60_000,
  /**
   * Enables scheduled reporting of usage data to Tolgee.
   *
   * In tests, this will be set to false and enabled only for specific tests.
   */
  @DocProperty(hidden = true)
  var scheduledReportingEnabled: Boolean = false,
  /**
   * How often is the license checked with Tolgee Cloud
   */
  @DocProperty(hidden = true)
  var checkPeriodInMs: Long = 1000 * 60 * 5,
) {
  fun isRemoteLicensingEnabled(): Boolean {
    return licenseServer.isNotBlank() && !licenseServer.isTolgeeOwnedUrl()
  }
}
