/*
 * Copyright 2003-2008 the original author or authors.
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
 *
 * You are receiving this code free of charge, which represents many hours of
 * effort from other individuals and corporations.  As a responsible member 
 * of the community, you are asked (but not required) to donate any 
 * enhancements or improvements back to the community under a similar open 
 * source license.  Thank you. -TMN
 */
package groovyx.net.http;

import static groovyx.net.http.ContentEncoding.Type.GZIP;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/**
 * Content encoding used to handle GZIP responses.
 * @author <a href='mailto:tomstrummer+httpbuilder@gmail.com'>Tom Nichols</a>
 */
public class GZIPEncoding extends ContentEncoding {

	/**
	 * Returns the {@link ContentEncoding.Type#GZIP} encoding string which is 
	 * added to the <code>Accept-Encoding</code> header by the base class.
	 */
	@Override
	public String getContentEncoding() {
		return GZIP.toString();
	}
	
	/**
	 * Wraps the raw entity in a {@link GZIPDecompressingEntity}.
	 */
	@Override
	public HttpEntity wrapResponseEntity( HttpEntity raw ) {
		return new GZIPDecompressingEntity( raw );
	}
	
	/**
	 * Entity used to interpret a GZIP-encoded response
	 * @author <a href='mailto:tomstrummer+httpbuilder@gmail.com'>Tom Nichols</a>
	 */
    protected static class GZIPDecompressingEntity extends HttpEntityWrapper {

        public GZIPDecompressingEntity(final HttpEntity entity) {
            super(entity);
        }
    
        /**
         * returns a {@link GZIPInputStream} which wraps the original entity's
         * content stream
         * @see HttpEntity#getContent()
         */
        @Override
        public InputStream getContent() throws IOException, IllegalStateException {
            return new GZIPInputStream( wrappedEntity.getContent() );
        }

        /**
         * @return -1
         */
        @Override
        public long getContentLength() {
            // length of un-gzipped content is not known
            return -1;
        }
    }
}
