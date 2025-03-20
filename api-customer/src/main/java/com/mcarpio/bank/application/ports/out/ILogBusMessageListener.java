package com.mcarpio.bank.application.ports.out;
import com.mcarpio.bank.domain.pojos.Log;

public interface ILogBusMessageListener {
    void receiveMsg(Log log);
}
