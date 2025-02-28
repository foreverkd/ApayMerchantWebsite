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
package com.amazon.pay.response.parser;

import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.exceptions.AmazonServiceException;
import com.amazon.pay.impl.AmazonPayResponse;
import com.amazon.pay.response.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class Parser {

    public static GetOrderReferenceDetailsResponseData getOrderReferenceDetails(ResponseData rawResponse) throws AmazonServiceException {
        final GetOrderReferenceDetailsResponse response = marshalXML(GetOrderReferenceDetailsResponse.class, rawResponse);
        return new GetOrderReferenceDetailsResponseData(response, rawResponse);
    }

    public static GetOrderReferenceDetailsResponseData getOrderReferenceDetails(AmazonPayResponse amazonPayResponse) throws AmazonServiceException {

        final CheckoutSession checkoutSession = marshalJSON(CheckoutSession.class, amazonPayResponse);
        final OrderReferenceDetails orderReferenceDetails = new OrderReferenceDetails();
        orderReferenceDetails.setAmazonOrderReferenceId(checkoutSession.getCheckoutSessionId());
        final GetOrderReferenceDetailsResponse.GetOrderReferenceDetailsResult result = new GetOrderReferenceDetailsResponse.GetOrderReferenceDetailsResult(orderReferenceDetails);
        final GetOrderReferenceDetailsResponse getOrderReferenceDetailsResponse = new GetOrderReferenceDetailsResponse(result, new ResponseMetadata());
        return new GetOrderReferenceDetailsResponseData(getOrderReferenceDetailsResponse, new ResponseData(amazonPayResponse.getStatus(), amazonPayResponse.getRawResponse()));

    }


    public static SetOrderReferenceDetailsResponseData setOrderReferenceDetails(ResponseData rawResponse) throws AmazonServiceException {
        final SetOrderReferenceDetailsResponse response = marshalXML(SetOrderReferenceDetailsResponse.class, rawResponse);
        return new SetOrderReferenceDetailsResponseData(response, rawResponse);
    }

    public static SetOrderReferenceDetailsResponseData setOrderReferenceDetails(AmazonPayResponse amazonPayResponse) throws AmazonServiceException {

        final CheckoutSession checkoutSession = marshalJSON(CheckoutSession.class, amazonPayResponse);
        final OrderReferenceDetails orderReferenceDetails = new OrderReferenceDetails();
        orderReferenceDetails.setAmazonOrderReferenceId(checkoutSession.getCheckoutSessionId());
        final SetOrderReferenceDetailsResult result = new SetOrderReferenceDetailsResult(orderReferenceDetails);
        final SetOrderReferenceDetailsResponse response = new SetOrderReferenceDetailsResponse(result, new ResponseMetadata());
        return new SetOrderReferenceDetailsResponseData(response, new ResponseData(amazonPayResponse.getStatus(), amazonPayResponse.getRawResponse()));
    }


    public static AuthorizeResponseData getAuthorizeData(ResponseData rawResponse) throws AmazonServiceException {
        final AuthorizeResponse response = marshalXML(AuthorizeResponse.class, rawResponse);
        return new AuthorizeResponseData(response, rawResponse);
    }

    public static GetAuthorizationDetailsResponseData getAuthorizationDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        final GetAuthorizationDetailsResponse response = marshalXML(GetAuthorizationDetailsResponse.class, rawResponse);
        return new GetAuthorizationDetailsResponseData(response, rawResponse);
    }

    public static CaptureResponseData getCapture(ResponseData rawResponse) throws AmazonServiceException {
        final CaptureResponse response = marshalXML(CaptureResponse.class, rawResponse);
        return new CaptureResponseData(response, rawResponse);
    }

    public static GetCaptureDetailsResponseData getCaptureDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        final GetCaptureDetailsResponse response = marshalXML(GetCaptureDetailsResponse.class, rawResponse);
        return new GetCaptureDetailsResponseData(response, rawResponse);
    }

    public static ConfirmOrderReferenceResponseData confirmOrderReference(ResponseData rawResponse) throws AmazonServiceException {
        final ConfirmOrderReferenceResponse response = marshalXML(ConfirmOrderReferenceResponse.class, rawResponse);
        return new ConfirmOrderReferenceResponseData(response, rawResponse);
    }

    public static CloseAuthorizationResponseData closeAuthorizationResponse(ResponseData rawResponse) throws AmazonServiceException {
        final CloseAuthorizationResponse response = marshalXML(CloseAuthorizationResponse.class, rawResponse);
        return new CloseAuthorizationResponseData(response, rawResponse);
    }

    public static CancelOrderReferenceResponseData getCancelOrderReference(ResponseData rawResponse) throws AmazonServiceException {
        final CancelOrderReferenceResponse response = marshalXML(CancelOrderReferenceResponse.class, rawResponse);
        return new CancelOrderReferenceResponseData(response, rawResponse);
    }

    public static CloseOrderReferenceResponseData getCloseOrderReference(ResponseData rawResponse) throws AmazonServiceException {
        final CloseOrderReferenceResponse response = marshalXML(CloseOrderReferenceResponse.class, rawResponse);
        return new CloseOrderReferenceResponseData(response, rawResponse);
    }

    public static RefundResponseData getRefundData(ResponseData rawResponse) throws AmazonServiceException {
        final RefundResponse response = marshalXML(RefundResponse.class, rawResponse);
        return new RefundResponseData(response, rawResponse);
    }

    public static GetRefundDetailsResponseData getRefundDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        final GetRefundDetailsResponse response = marshalXML(GetRefundDetailsResponse.class, rawResponse);
        return new GetRefundDetailsResponseData(response, rawResponse);
    }

    public static GetBillingAgreementDetailsResponseData getBillingAgreementDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        final GetBillingAgreementDetailsResponse response = marshalXML(GetBillingAgreementDetailsResponse.class, rawResponse);
        return new GetBillingAgreementDetailsResponseData(response, rawResponse);
    }

    public static SetBillingAgreementDetailsResponseData getSetBillingAgreementDetailsResponse(ResponseData rawResponse) throws AmazonServiceException {
        final SetBillingAgreementDetailsResponse response = marshalXML(SetBillingAgreementDetailsResponse.class, rawResponse);
        return new SetBillingAgreementDetailsResponseData(response, rawResponse);
    }

    public static ValidateBillingAgreementResponseData getValidateBillingAgreementResponse(ResponseData rawResponse) throws AmazonServiceException {
        final ValidateBillingAgreementResponse response = marshalXML(ValidateBillingAgreementResponse.class, rawResponse);
        return new ValidateBillingAgreementResponseData(response, rawResponse);
    }

    public static ConfirmBillingAgreementResponseData confirmBillingAgreementResponse(ResponseData rawResponse) throws AmazonServiceException {
        final ConfirmBillingAgreementResponse response = marshalXML(ConfirmBillingAgreementResponse.class, rawResponse);
        return new ConfirmBillingAgreementResponseData(response, rawResponse);
    }

    public static AuthorizeOnBillingAgreementResponseData getAuthorizeOnBillingAgreement(ResponseData rawResponse) throws AmazonServiceException {
        final AuthorizeOnBillingAgreementResponse response = marshalXML(AuthorizeOnBillingAgreementResponse.class, rawResponse);
        return new AuthorizeOnBillingAgreementResponseData(response, rawResponse);
    }

    public static CloseBillingAgreementResponseData closeBillingAgreementResponse(ResponseData rawResponse) throws AmazonServiceException {
        final CloseBillingAgreementResponse response = marshalXML(CloseBillingAgreementResponse.class, rawResponse);
        return new CloseBillingAgreementResponseData(response, rawResponse);
    }

    public static GetProviderCreditDetailsResponseData getGetProviderCreditDetails(ResponseData rawResponse) throws AmazonServiceException {
        final GetProviderCreditDetailsResponse response = marshalXML(GetProviderCreditDetailsResponse.class, rawResponse);
        return new GetProviderCreditDetailsResponseData(response, rawResponse);
    }

    public static GetProviderCreditReversalDetailsResponseData getProviderCreditReversalDetails(ResponseData rawResponse) throws AmazonServiceException {
        final GetProviderCreditReversalDetailsResponse response = marshalXML(GetProviderCreditReversalDetailsResponse.class, rawResponse);
        return new GetProviderCreditReversalDetailsResponseData(response, rawResponse);
    }

    public static ReverseProviderCreditResponseData getReverseProviderCreditResponseData(ResponseData rawResponse) throws AmazonServiceException {
        final ReverseProviderCreditResponse response = marshalXML(ReverseProviderCreditResponse.class, rawResponse);
        return new ReverseProviderCreditResponseData(response, rawResponse);
    }

    public static GetServiceStatusResponseData getServiceStatus(
                ResponseData rawResponse) throws AmazonServiceException {
        final GetServiceStatusResponse response = marshalXML(
                GetServiceStatusResponse.class, rawResponse);
        return new GetServiceStatusResponseData(response, rawResponse);
    }

    public static CreateOrderReferenceForIdResponseData createOrderReferenceForId(
                ResponseData rawResponse) throws AmazonServiceException {
        final CreateOrderReferenceForIdResponse response = marshalXML(
                CreateOrderReferenceForIdResponse.class, rawResponse);
        return new CreateOrderReferenceForIdResponseData(response, rawResponse);
    }

    public static ListOrderReferenceResponseData listOrderReference(ResponseData rawResponse) throws AmazonServiceException {
        final ListOrderReferenceResponse response = marshalXML(ListOrderReferenceResponse.class, rawResponse);
        return new ListOrderReferenceResponseData(response, rawResponse);
    }

    public static ListOrderReferenceByNextTokenResponseData listOrderReferenceByNextToken(ResponseData rawResponse) throws AmazonServiceException {
        final ListOrderReferenceByNextTokenResponse response = marshalXML(ListOrderReferenceByNextTokenResponse.class, rawResponse);
        return new ListOrderReferenceByNextTokenResponseData(response, rawResponse);
    }

    public static SetOrderAttributesResponseData setOrderAttributes(ResponseData rawResponse) throws AmazonServiceException {
        final SetOrderAttributesResponse response = marshalXML(SetOrderAttributesResponse.class, rawResponse);
        return new SetOrderAttributesResponseData(response, rawResponse);
    }

    public static GetMerchantAccountStatusResponseData getMerchantAccountStatus(ResponseData rawResponse) throws AmazonServiceException {
        final GetMerchantAccountStatusResponse response = marshalXML(GetMerchantAccountStatusResponse.class, rawResponse);
        return new GetMerchantAccountStatusResponseData(response, rawResponse);
    }

    public static <T> T marshalXML(Class<T> clazz, ResponseData rawResponse) throws AmazonServiceException  {
        try {
            if (rawResponse.getStatusCode() == 200) {
                T responseObject = null;
                final JAXBContext context = JAXBContext.newInstance(clazz);

                // Ignore the namespace only for marshalling purpose
                final String noNamespaceXML = rawResponse.toXML().replaceAll(
                        "xmlns(?:.*?)?=\"http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01\"", "");
                final StringReader reader = new StringReader(noNamespaceXML);
                final Unmarshaller unmarshaller = context.createUnmarshaller();

                final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
                xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
                xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
                final XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
                responseObject = (T) unmarshaller.unmarshal(xmlStreamReader);

                return responseObject;
            } else {
                generateErrorException(rawResponse);
            }
        } catch (JAXBException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.toXML(), e);
        }
        catch (XMLStreamException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.toXML(), e);
        }

        return null;
    }

    public static <T> T marshalJSON(Class<T> clazz, AmazonPayResponse rawResponse) throws AmazonServiceException  {
        try {
            if (rawResponse.getStatus() == 200) {

                return new ObjectMapper().readValue(rawResponse.getRawResponse(), clazz);
            } else {
                generateErrorException(rawResponse);
            }
        } catch (JsonProcessingException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.getRawResponse(), e);
        }

        return null;
    }

    public static void generateErrorException(ResponseData rawResponse) throws AmazonServiceException, JAXBException {
        final JAXBContext context = JAXBContext.newInstance(ErrorResponse.class);

        // Ignore the namespace only for marshalling purpose
        final String noNamespaceXML = rawResponse.toXML().replaceAll(
                "xmlns(?:.*?)?=\"http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01\"", "");
        final StringReader reader = new StringReader(noNamespaceXML);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        try {
            final XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            final ErrorResponse result = (ErrorResponse) unmarshaller.unmarshal(xmlStreamReader);
            throw new AmazonServiceException(result, rawResponse);
        } catch (XMLStreamException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.toXML(), e);
        }
    }

    public static void generateErrorException(AmazonPayResponse rawResponse) throws AmazonServiceException, JsonProcessingException {
        try {
            final ErrorResponse result = new ObjectMapper().readValue(rawResponse.getRawResponse(), ErrorResponse.class);
            throw new AmazonServiceException(result, rawResponse);
        } catch (RuntimeException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.getRawResponse(), e);
        }
    }
}
