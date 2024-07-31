package dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class DtoStudy1 {

    //@Data
    //@NoArgsConstructor
    //@AllArgsConstructor
    class ProductDTO {

        private String id;

        private String name;

        private String category;

        /**@JsonProperty("unit_sales")*/
        private Double unitSales;

        private Integer quantity;

        /**@JsonProperty("subtotal_sales")*/
        private Double subtotalSales;

        /**@JsonProperty("media_commission_rate")*/
        private Double mediaCommissionRate;

        private String currency;
    }

    //@Data
    //@NoArgsConstructor
    //@AllArgsConstructor
    class OrderDTO {

        private String orderId;

        /**@JsonProperty("order_time")*/
        private Long orderUnixTime;

        /**@JsonProperty("merchant_id")*/
        private String merchantId;

        /**@JsonProperty("merchant_name")*/
        private String merchantName;

        /**@JsonProperty("total_sales")*/
        private Double totalSales;

        /**@JsonProperty("total_media_commission")*/
        private Double totalMediaCommission;

        private List<dto.ProductDTO> products;

        // 유닉스 타임스탬프를 LocalDateTime 으로 변환
        public LocalDateTime getOrderDate() {
            return LocalDateTime.ofInstant(
                    Instant.ofEpochSecond(orderUnixTime),
                    ZoneOffset.ofHours(0)
            );
        }

        /**
         // 객체를 JSON 문자열로 변환
         public String toJson() throws Exception {
         ObjectMapper mapper = new ObjectMapper();
         return mapper.writeValueAsString(this);
         }
         */

        /**
         // JSON 문자열을 객체로 변환
         public static OrderDTO fromJson(String jsonString) throws Exception {
         ObjectMapper mapper = new ObjectMapper();
         return mapper.readValue(jsonString, OrderDTO.class);
         }
         */
    }
}
