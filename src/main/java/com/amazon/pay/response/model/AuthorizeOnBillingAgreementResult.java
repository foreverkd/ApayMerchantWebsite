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
package com.amazon.pay.response.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authorizationDetails",
    "amazonOrderReferenceId"
})
@XmlRootElement(name = "AuthorizeOnBillingAgreementResult")
public class AuthorizeOnBillingAgreementResult {

    @XmlElement(name = "AuthorizationDetails", required = true)
    protected AuthorizationDetails authorizationDetails;
    @XmlElement(name = "AmazonOrderReferenceId", required = true)
    protected String amazonOrderReferenceId;

    public AuthorizeOnBillingAgreementResult() {
        super();
    }


    public AuthorizationDetails getAuthorizationDetails() {
        return authorizationDetails;
    }

    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }


}
