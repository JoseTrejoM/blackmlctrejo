package com.yega.mlc.dto.pagos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CardDTO{
 
String  address_city; //
String address_country; //null
String address_line1; //null
String address_line1_check; //null
String address_line2; //null
String address_state; //null
String address_zip; //"23455"
String address_zip_check; //"unchecked"
String brand; //"Visa"
String country; //"US"
String cvc_check; //"unchecked"
String dynamic_last4; //null
Integer exp_month; //4
Integer exp_year; //2023
String funding; //"credit"
String id; //"card_1JerqcLm93TetmkajfH81ERW"
String last4; //"4242"
String name; //"Alex"
String object; //"card"
String tokenization_method; //null


}