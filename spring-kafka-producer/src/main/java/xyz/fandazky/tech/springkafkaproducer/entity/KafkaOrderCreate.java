/**
 * dana.id
 * Copyright (c) 2017‐2020 All Rights Reserved.
 */
package xyz.fandazky.tech.springkafkaproducer.entity;

import java.io.Serializable;

public class KafkaOrderCreate implements Serializable {

    private String orderId;

    private String merchantId;

    /**
     * Getter method for property orderId.
     *
     * @return property value of orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Setter method for property orderId.
     *
     * @param orderId value to be assigned to property orderId
     */

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter method for property merchantId.
     *
     * @return property value of merchantId
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Setter method for property merchantId.
     *
     * @param merchantId value to be assigned to property merchantId
     */

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "KafkaOrderCreate{" +
                "orderId='" + orderId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                '}';
    }
}