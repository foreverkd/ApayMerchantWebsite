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

import com.amazon.pay.response.model.ConfirmOrderReferenceResponse;

import java.io.Serializable;

/**
 * Response from ConfirmOrderReference service API, as returned by Amazon Pay
 */
public final class ConfirmOrderReferenceResponseData  extends ResponseData implements Serializable {
    
    private String requestId;
    
    public ConfirmOrderReferenceResponseData(ConfirmOrderReferenceResponse confirmOrderReferenceResponse , ResponseData rawResponse) {
        super(rawResponse.getStatusCode(), rawResponse.toXML());
        if(confirmOrderReferenceResponse != null) {
            if(confirmOrderReferenceResponse.getResponseMetadata() != null) {
                this.requestId = confirmOrderReferenceResponse.getResponseMetadata().getRequestId();
            }
        }
    }

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

    /**
     * Returns the string representation of ConfirmOrderReferenceResponseData
     */
    @Override
    public String toString() {
        return "ConfirmOrderReferenceResponseData{" + "requestId=" + requestId + '}';
    }
    
    
}
