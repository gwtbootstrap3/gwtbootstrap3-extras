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

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.*;
import com.google.gwt.core.ext.linker.EmittedArtifact.Visibility;
import com.google.gwt.core.ext.linker.LinkerOrder.Order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/**
 * Offline linker performs the task of generating a valid cache manifest file
 * when you compile your GWT application.
 * <p/>
 * <p/>
 * Static resources that are needed (outside of the compile unit) require
 * specific inclusion. These files would typically be index.html, css files or
 * any resources not included within the GWT application. These files are
 * included through the cachemanifest_static_files property added to your
 * module.gwt.xml file. The path is relative to manifest, so include a full path
 * if you include resources outside of the apps path.
 * <p/>
 * <pre>
 * {@code
 * <extend-configuration-property name="cachemanifest_static_files" value="/index.html" />
 * }
 * </pre>
 * <p/>
 * To activate the linker, the following configuration is included in your GWT
 * module definition (module.gwt.xml file) as follows:
 * <p/>
 * <pre>
 * {@code
 * <inherits name='org.gwtbootstrap3.extras.cachemanifest.Offline'/>
 * <add-linker name="offline" />
 * }
 * </pre>
 * <p/>
 * Finally, include the cache manifest file within the html page that loads your
 * GWT application, as follows:
 * <p/>
 * <pre>
 * {@code
 *  <!doctype html>
 *  <html manifest="<modulename>/appcache.manifest">
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
    public ArtifactSet link(final TreeLogger logger, final LinkerContext context, final ArtifactSet artifacts) throws UnableToCompleteException {

        final ArtifactSet artifactset = new ArtifactSet(artifacts);

        final HashSet<String> resources = new HashSet<String>();
        for (final EmittedArtifact emitted : artifacts.find(EmittedArtifact.class)) {

            if (skipArtifact(emitted))
                continue;
            resources.add(emitted.getPartialPath());
        }

        final SortedSet<ConfigurationProperty> staticFileProperties = context.getConfigurationProperties();
        for (final ConfigurationProperty configurationProperty : staticFileProperties) {
            final String name = configurationProperty.getName();
            if (CACHEMANIFEST_STATIC_FILES_PROPERTY.equals(name)) {
                for (final String value : configurationProperty.getValues()) {
                    resources.add(value);
                }
            }
        }

        final String manifestString = buildManifestContents(resources);
        if (manifestString != null) {
            final EmittedArtifact manifest = emitString(logger, manifestString, "appcache.manifest");
            artifactset.add(manifest);
        }
        return artifactset;
    }

    private boolean skipArtifact(final EmittedArtifact emitted) {

        if (emitted.getVisibility().matches(Visibility.Private))
            return true;

        final String pathName = emitted.getPartialPath();

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

    private String buildManifestContents(final Set<String> resources) {
        if (resources == null)
            return null;

        final StringBuilder sb = new StringBuilder();
        sb.append("CACHE MANIFEST\n");
        sb.append("# Version: " + (new Date()).getTime() + "." + Math.random() + "\n");
        sb.append("\n");
        sb.append("CACHE:\n");
        for (final String resourcePath : resources) {
            sb.append(resourcePath + "\n");
        }

        sb.append("\n\n");
        sb.append("NETWORK:\n");
        sb.append("*\n");
        return sb.toString();
    }
}