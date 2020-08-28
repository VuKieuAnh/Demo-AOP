package aop;

import aop.account.Account;
import aop.account.AccountService;
import aop.account.AccountServiceImpl;
import aop.handler.AbstractHandler;
import aop.handler.ProxyFactory;
import aop.handler.impl.AfterHandlerImpl;
import aop.handler.impl.BeforeHandlerImpl;

import java.util.ArrayList;
import java.util.List;

public class AspectOrientedProgrammingInJdkExample {

        public static void main(String[] args) {

            List<AbstractHandler> handlers = new ArrayList<>();
            handlers.add(new BeforeHandlerImpl());
            handlers.add(new AfterHandlerImpl());

            AccountService proxy = (AccountService) ProxyFactory.getProxy(new AccountServiceImpl(), handlers);
            Account account = new Account("kieuanh", "USD", 10);
            proxy.addAccount(account);
            proxy.getSize();
            proxy.removeAccount(account);
            proxy.getSize();
        }
    }
