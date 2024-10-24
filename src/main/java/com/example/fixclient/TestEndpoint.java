package com.example.fixclient;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.field.TestReqID;
import quickfix.fix44.TestRequest;



@Slf4j
@RestController
public class TestEndpoint {



    void should_success_if_single_thread_send_message() {
        String sessionID = "FIX.4.4:ZEROMARKETS->NELOGICA";
        for (int i = 0; i < 100; i++) {
            sentTestRequest(new SessionID(sessionID), "test" + i);
        }
    }

    @SneakyThrows
    private void sentTestRequest(SessionID sessionID, String testReqId) {
        TestRequest testRequest = new TestRequest();
        testRequest.set(new TestReqID(testReqId));

        if (Session.sendToTarget(testRequest, sessionID)) {
            log.info("发送成功:{}", testReqId);
        }
        log.info("发送失败:{}", testReqId);
    }
}
