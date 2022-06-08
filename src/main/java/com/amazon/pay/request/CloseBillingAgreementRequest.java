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
package com.amazon.pay.request;

import java.io.Serializable;

/**
 * Container for the parameters to the CloseBillingAgreement operation.
 *
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class CloseBillingAgreementRequest extends DelegateRequest<CloseBillingAgreementRequest> implements Serializable {

    @Override
    protected CloseBillingAgreementRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonBillingAgreementId;

    //optional parameters
    private String closureReason;

    /**
     *
     * @param amazonBillingAgreementId
     *              The billing agreement identifier. This value is retrieved
     *              from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public CloseBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     * @param closureReason
     *              Describes the reason for closing the billing agreement.
     *
     * @return The ClosureReason
     */
    public CloseBillingAgreementRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }

    /**
     * The billing agreement identifier. This value is retrieved
     *              from the Amazon Button, AddressBook, or Wallet widgets.
     * @return AmazonBillingAgreementId specified in request
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     *
     * @return ClosureResason specified in request
     */
    public String getClosureReason() {
        return closureReason;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "CloseBillingAgreementRequest{"
                + "amazonBillingAgreementId=" + amazonBillingAgreementId
                + ", closureReason=" + closureReason
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
