package io.tolgee.util

import java.net.URI

fun String?.isTolgeeOwnedUrl(): Boolean {
  if (this.isNullOrBlank()) {
    return false
  }

  val normalized = this.trim().lowercase()
  val host = runCatching { URI(normalized).host?.lowercase() }.getOrNull()

  if (host != null) {
    return host == "tolgee.io" || host.endsWith(".tolgee.io")
  }

  return normalized.contains("://tolgee.io") || normalized.contains("://app.tolgee.io")
}
