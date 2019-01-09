package com.tmobile.ct.codeless.service.accessor.request;

import com.tmobile.ct.codeless.service.HttpRequest;
import com.tmobile.ct.codeless.service.accessor.response.ResponseAccessor;
import com.tmobile.ct.codeless.service.httpclient.QueryParam;

/**
 * The Class QueryParamsModifier.
 *
 * @author Rob Graff
 */
public class QueryParamsModifier implements RequestModifier<QueryParam> {

	/** The key. */
	private String key;
	
	/** The response accessor. */
	private ResponseAccessor responseAccessor;

	/**
	 * Instantiates a new query params modifier.
	 *
	 * @param key the key
	 * @param responseAccessor the response accessor
	 */
	public QueryParamsModifier(String key, ResponseAccessor responseAccessor) {
		this.key = key;
		this.responseAccessor = responseAccessor;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.accessor.request.RequestModifier#modify(com.tmobile.ct.codeless.service.HttpRequest)
	 */
	@Override
	public void modify(HttpRequest request) {
		request.getQueryParams().put(key, new QueryParam(key, responseAccessor.getActual()));
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.accessor.request.RequestModifier#setResponseAccessor(com.tmobile.ct.codeless.service.accessor.response.ResponseAccessor)
	 */
	@Override
	public void setResponseAccessor(ResponseAccessor responseAccessor) {
		this.responseAccessor = responseAccessor;
	}
}