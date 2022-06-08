/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazon.pay.response.parser;

import com.amazon.pay.response.model.ListOrderReferenceResponse;
import com.amazon.pay.response.model.OrderReference;
import com.amazon.pay.response.model.OrderReferenceList;

import java.io.Serializable;
import java.util.List;

/**
 * Response from ListOrderReference service API, as returned by Amazon Pay
 */
public class ListOrderReferenceResponseData extends ResponseData implements Serializable {

    private String requestId;
    private OrderReferenceList orderReferenceList;
    private String nextPageToken;
    private List<OrderReference> orderReferences;

    /**
     * The requestID that uniquely identifies the service request
     * the caller made.
     *
     * @return  The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

    public OrderReferenceList getOrderReferenceList() {
        return orderReferenceList;
    }

    /**
     * Returns the next page token to be used by the ListOrderReferenceByNextToken API.
     *
     * @return orderReferences
     */
    public String getNextPageToken() {
        return nextPageToken;
    }

    /**
     * Returns a list of order reference objects which encapsulates details about an order.

     * @return orderReferences
     */
    public List<OrderReference> getOrderReferences() {
        return orderReferences;
    }



    public ListOrderReferenceResponseData(ListOrderReferenceResponse response, ResponseData rawResponse){
        super(rawResponse);
        if (response!= null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if (response.getListOrderReferenceResult()!= null) {
                orderReferenceList = response.getListOrderReferenceResult().getOrderReferenceList();
                nextPageToken = response.getListOrderReferenceResult().getNextPageToken();
                if (orderReferenceList != null) {
                    orderReferences = orderReferenceList.getOrderReferences();
                }
            }
        }
    }

    /**
     * Returns the string representation of ListOrderReferenceResponseData
     */
    @Override
    public String toString() {
        return "ListOrderReferenceResponseData{" + "requestId=" + requestId
                + "nextPageToken=" + nextPageToken
                + ", orderReferences=" + orderReferences.toString() + '}';
    }
}
