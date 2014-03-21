package org.gwtbootstrap3.extras.cachemanifest;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.AbstractLinker;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.ConfigurationProperty;
import com.google.gwt.core.ext.linker.EmittedArtifact;
import com.google.gwt.core.ext.linker.EmittedArtifact.Visibility;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.LinkerOrder.Order;

/**
 * Offline linker performs the task of generating a valid cache manifest file
 * when you compile your GWT application.
 * <p>
 * 
 * Static resources that are needed (outside of the compile unit) require
 * specific inclusion. These files would typically be index.html, css files or
 * any resources not included within the GWT application. These files are
 * included through the following property added to your module.gwt.xml file:
 * 
 * <pre>
 * {@code
 * <extend-configuration-property name="cachemanifest_static_files" value="index.html" />
 * }
 * </pre>
 * 
 * To activate the linker, the following configuration is included in your GWT
 * module definition (module.gwt.xml file) as follows:
 * 
 * <pre>
 * {@code
 * <inherits name='org.gwtbootstrap3.extras.cachemanifest.Offline'/> 
 * <add-linker name="offline" />
 * }
 * </pre>
 * 
 * Finally, include the cache manifest file within the html page that loads your
 * GWT application, as follows:
 * 
 * <pre>
 * {@code
 *  <!doctype html>
 *  <html manifest="/<modulename>.manifest">
 *  ....
 *  </html>
 * }
 * </pre>
 * 
 * @author Grant Slender
 */

@LinkerOrder(Order.POST)
public class Offline extends AbstractLinker {

	private static final String CACHEMANIFEST_STATIC_FILES_PROPERTY = "cachemanifest_static_files";

	@Override
	public String getDescription() {
		return "Offline Linker";
	}

	@Override
	public ArtifactSet link(TreeLogger logger, LinkerContext context, ArtifactSet artifacts) throws UnableToCompleteException {
		
		ArtifactSet artifactset = new ArtifactSet(artifacts);

		HashSet<String> resources = new HashSet<String>();
		for (EmittedArtifact emitted : artifacts.find(EmittedArtifact.class)) {

			if (skipArtifact(emitted))
				continue;
			resources.add(context.getModuleName() + "/" + emitted.getPartialPath());
		}

		SortedSet<ConfigurationProperty> properties = context.getConfigurationProperties();
		for (ConfigurationProperty configurationProperty : properties) {
			String name = configurationProperty.getName();
			if (CACHEMANIFEST_STATIC_FILES_PROPERTY.equals(name)) {
				for (String value : configurationProperty.getValues()) {
					resources.add(value);
				}
			}
		}

		String manifestString = buildManifestContents(resources);
		if (manifestString != null) {
			EmittedArtifact manifest = emitString(logger, manifestString, context.getModuleName() + ".manifest");
			artifactset.add(manifest);
		}
		return artifactset;
	}

	private boolean skipArtifact(EmittedArtifact emitted) {

		if (emitted.getVisibility().matches(Visibility.Private))
			return true;

		String pathName = emitted.getPartialPath();

		if (pathName.endsWith("symbolMap"))
			return true;
		if (pathName.endsWith(".xml.gz"))
			return true;
		if (pathName.endsWith("rpc.log"))
			return true;
		if (pathName.endsWith("gwt.rpc"))
			return true;
		if (pathName.endsWith("manifest.txt"))
			return true;
		if (pathName.startsWith("rpcPolicyManifest"))
			return true;
		if (pathName.startsWith("soycReport"))
			return true;
		if (pathName.endsWith(".cssmap"))
			return true;

		return false;
	}

	private String buildManifestContents(Set<String> resources) {
		if (resources == null)
			return null;

		StringBuilder sb = new StringBuilder();
		sb.append("CACHE MANIFEST\n");
		sb.append("# Version: " + (new Date()).getTime() + "." + Math.random() + "\n");
		sb.append("\n");
		sb.append("CACHE:\n");
		for (String resourcePath : resources) {
			sb.append(resourcePath + "\n");
		}

		sb.append("\n\n");
		sb.append("NETWORK:\n");
		sb.append("*\n");
		return sb.toString();
	}
}