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
 * Container for the parameters to the ValidateBillingAgreement operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class ValidateBillingAgreementRequest extends DelegateRequest<ValidateBillingAgreementRequest> implements Serializable {

    @Override
    protected ValidateBillingAgreementRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonBillingAgreementId;

    /**
     *
     * @param amazonBillingAgreementId The billing agreement identifier.
     * This value is retrieved from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public ValidateBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     *
     * @return AmazonBillingAgreementId
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
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
        return "ValidateBillingAgreementRequest{"
                + "amazonBillingAgreementId=" + amazonBillingAgreementId
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
