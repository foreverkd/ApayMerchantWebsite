/**
 * Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

/**
 * This represents the SetOrderAttributesResult node parsed
 * from the Amazon Pay SetOrderAttributes API response.
 *
 *   &lt;SetOrderAttributesResult&gt;
 *     &lt;OrderReferenceDetails&gt;
 *       ...
 *     &lt;/OrderReferenceDetails&gt;
 *   &lt;/SetOrderAttributesResult&gt;
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "orderReferenceDetails"
})
@XmlRootElement(name = "SetOrderAttributesResult")
public class SetOrderAttributesResult {

    @XmlElement(name = "OrderReferenceDetails")
    protected OrderReferenceDetails orderReferenceDetails;

    public SetOrderAttributesResult() {
        super();
    }

    public OrderReferenceDetails getOrderReferenceDetails() {
        return orderReferenceDetails;
    }
}
