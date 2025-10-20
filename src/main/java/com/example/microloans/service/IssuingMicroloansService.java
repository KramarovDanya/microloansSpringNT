package com.example.microloans.service;

import com.example.microloans.model.request.PaymentConfirmRequestModel;
import com.example.microloans.model.responce.AccCheckResponseModel;
import com.example.microloans.model.responce.ContactModel;
import com.example.microloans.model.responce.DeptModel;
import com.example.microloans.model.responce.PaymentConfirmResponseModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class IssuingMicroloansService {
    private static final Random RANDOM = new Random();

    public PaymentConfirmResponseModel buildPaymentConfirm(PaymentConfirmRequestModel paymentConfirmRequestModel, String bankCode)
    {


        //созадние моедли ответа
        PaymentConfirmResponseModel paymentConfirmResponseModel = new PaymentConfirmResponseModel();

        ////////заполнение модели ответа////////
        paymentConfirmResponseModel.setTransaction_id(paymentConfirmRequestModel.getTransaction_id());

        paymentConfirmResponseModel.setBank_bik(1234567891);

        paymentConfirmResponseModel.setStatus("accepted");

        int telecomCount = calculateDigitSum(bankCode);
        List<String> telecom = new ArrayList<String>();
        for (int i = 0; i < telecomCount; i++) {
            telecom.add(generateTelecomeString(6));
        }

        ContactModel contact = new ContactModel();
        contact.setName("HL pay company");
        contact.setTelecom(telecom);


        List<ContactModel> contactList = new ArrayList<>();
        contactList.add(contact);
        paymentConfirmResponseModel.setContact(contactList);

        return paymentConfirmResponseModel;
    }

    private String generateTelecomeString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(RANDOM.nextInt(chars.length())));
        }
        return sb.toString();
    }

    private int calculateDigitSum(String bankCode) {
        return bankCode.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();
    }

    public AccCheckResponseModel getAccCheck (String accNumber, int days){

        AccCheckResponseModel accCheckResponseModel = new AccCheckResponseModel();

        accCheckResponseModel.setAccount(accNumber);

        accCheckResponseModel.setVip_client(endsWithEvenDigit(accNumber));

        accCheckResponseModel.setBlocked(false);

        String inn = accNumber + "111";

        accCheckResponseModel.setInn(inn);

        List<DeptModel> depts = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            DeptModel dept = new DeptModel();
            dept.setSum(1000);
            dept.setDescription("parking" + i);
            depts.add(dept);
        }

        accCheckResponseModel.setDept(depts);

        return accCheckResponseModel;
    }

    public static boolean endsWithEvenDigit(String accNumber) {
        char lastChar = accNumber.charAt(accNumber.length() - 1);
        if (!Character.isDigit(lastChar)) {
            return false;
        }
        int lastDigit = Character.getNumericValue(lastChar);
        return lastDigit % 2 == 1;
    }


}
