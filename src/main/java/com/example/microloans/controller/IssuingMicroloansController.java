package com.example.microloans.controller;

import com.example.microloans.model.request.PaymentConfirmRequestModel;
import com.example.microloans.model.responce.PaymentConfirmResponseModel;
import com.example.microloans.model.responce.AccCheckResponseModel;
import com.example.microloans.service.IssuingMicroloansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j

@RestController

@Tag(name="Запросы для обращения к заглушке", description = "доступ к эндпоинтам")
public class IssuingMicroloansController {

    @Autowired
    private IssuingMicroloansService issuingMicroloansService;

    @PostMapping(path = "/v2/payment")
    @Operation (summary = "Проверить информацию о задолженностях по карте клиента")
    @Parameter (name = "BankCode", description = "Значение кода банка", required = true, in = ParameterIn.HEADER)
    public ResponseEntity<PaymentConfirmResponseModel> PaymentConfirmation(@RequestBody PaymentConfirmRequestModel request,
                                                                           @RequestHeader("BankCode") String bankCode) {
        PaymentConfirmResponseModel paymentConfirmResponseModel = issuingMicroloansService.buildPaymentConfirm(request, bankCode);

        HttpHeaders httpHeaders = new HttpHeaders();

        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        log.info("Payment confirmation received");
        return ResponseEntity.ok()
                .header("ProcessingTime", timeStamp) // как в ТЗ (с опечаткой "TIme")
                .body(paymentConfirmResponseModel);


    }


    @GetMapping(path="/v2/checkAccount")
    @Operation (summary = "Подтвердить платеж")
    public ResponseEntity<?> getAccauntCheck(@RequestParam("acc") String accNumber, @RequestParam("days") int countDays)
    {

        AccCheckResponseModel accCheckResponseModel = issuingMicroloansService.getAccCheck(accNumber, countDays);

        log.info("Accaunt Check received");

        return new ResponseEntity<>(accCheckResponseModel, HttpStatus.ACCEPTED);
    }

    @Value("${stub.delay.delete:1}") // значение по умолчанию = 1
    private long deleteDelaySeconds;


    @DeleteMapping("/v1/transactions/cleare/{id}")
    @Operation (summary = "Удалить транзакцию процессинга")
    public ResponseEntity<String> deleteTransaction(@PathVariable String id) {

        try {
            Thread.sleep(deleteDelaySeconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("delete Transaction received");

        return ResponseEntity
                .status(200) // или HttpStatus.OK
                .contentType(MediaType.TEXT_PLAIN)
                .body("deleted success" + " потрачено" + deleteDelaySeconds + " seconds");

    }

}
