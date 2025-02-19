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
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditDetails", propOrder = {
    "amazonProviderCreditId",
    "sellerId",
    "providerId",
    "providerSellerId",
    "creditReferenceId",
    "creditAmount",
    "creditReversalAmount",
    "creditReversalIdList",
    "creationTimestamp",
    "creditStatus"
})
public class ProviderCreditDetails {

    @XmlElement(name = "AmazonProviderCreditId", required = true)
    protected String amazonProviderCreditId;
    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "ProviderSellerId", required = false)
    protected String providerSellerId;
    @XmlElement(name = "CreditReferenceId", required = true)
    protected String creditReferenceId;
    @XmlElement(name = "CreditAmount", required = true)
    protected Price creditAmount;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;
    @XmlElement(name = "CreditReversalIdList", required = true)
    protected IdList creditReversalIdList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CreditStatus", required = true)
    protected Status creditStatus;

    public ProviderCreditDetails() {
        super();
    }

    /**
     * @return the amazonProviderCreditId
     */
    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    /**
     * @return the sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @return the providerId
     */
    public String getProviderId() {
        return providerId;
    }
    
    /**
     * @return the providerSellerId
     * (applicable while processing ProviderCreditNotification only)
     */
    public String getProviderSellerId() {
        return providerSellerId;
    }

    /**
     * @return the Credit Reference ID
     */
    public String getCreditReferenceId() {
        return creditReferenceId;
    }

    /**
     * @return the Credit Amount
     */
    public Price getCreditAmount() {
        return creditAmount;
    }

    /**
     * @return the Credit Reversal Amount
     */
    public Price getCreditReversalAmount() {
        return creditReversalAmount;
    }

    /**
     * @return the Credit Reversal ID List
     */
    public IdList getCreditReversalIdList() {
        return creditReversalIdList;
    }

    /**
     * @return the Creation Time Stamp
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * @return the Credit Status
     */
    public Status getCreditStatus() {
        return creditStatus;
    }

    /**
     * String representation of providerCreditDetails
     */
    @Override
    public String toString() {
        return "ProviderCreditDetails{" + "amazonProviderCreditId=" + amazonProviderCreditId + ", sellerId=" 
                + sellerId + ", providerId=" + providerId + ", creditReferenceId=" + creditReferenceId 
                + ", creditAmount=" + creditAmount + ", creditReversalAmount=" + creditReversalAmount 
                + ", creditReversalIdList=" + creditReversalIdList + ", creationTimestamp=" + creationTimestamp 
                + ", creditStatus=" + creditStatus + '}';
    }
}
