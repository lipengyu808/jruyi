/*
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
package org.jruyi.io.ssl;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.jruyi.io.ISslContextParameters;
import org.jruyi.io.IoConstants;

@Service
@Component(name = IoConstants.FID_SSL, createPid = false)
@Property(name = IoConstants.FILTER_ID, value = IoConstants.FID_SSL)
public final class SslFilter extends AbstractSslFilter {

	@Reference(name = "sslcp", bind = "bindSslContextParameters", unbind = "unbindSslContextParameters", updated = "updatedSslContextParameters")
	private ISslContextParameters m_sslcp;

	protected void bindSslContextParameters(ISslContextParameters sslcp) {
		m_sslcp = sslcp;
	}

	protected void unbindSslContextParameters(ISslContextParameters sslcp) {
		m_sslcp = null;
	}

	@Modified
	@Override
	protected void modified(Map<String, ?> properties) throws Exception {
		super.modified(properties);
	}

	@Override
	protected ISslContextParameters sslcp() {
		return m_sslcp;
	}
}
