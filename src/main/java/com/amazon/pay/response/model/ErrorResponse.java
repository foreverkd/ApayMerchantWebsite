/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.response.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "error",
    "requestId",
    "requestID"
})
@XmlRootElement(name = "ErrorResponse")
public class ErrorResponse {

    @XmlElement(name = "Error", required = true)
    protected List<Error> error;
    @XmlElement(name = "RequestId")
    protected String requestId;
    // Throttled error requests come back with "RequestID" node names instaed of "RequestId"
    @XmlElement(name = "RequestID")
    protected String requestID;

    public ErrorResponse() {
        super();
    }


    public List<Error> getError() {
        if (error == null) {
            error = new ArrayList<Error>();
        }
        return this.error;
    }

    // Regardless of type of error, return the RequestId in a consistent way
    public String getRequestId() {
        if (requestId != null) {
            return requestId;
        } else {
            return requestID;
        }
    }



}
