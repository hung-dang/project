package LHU.project.service.impl;

import LHU.project.entities.Account;
import LHU.project.repository.AccountRepository;
import LHU.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceimpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUserName(String userName) {

        return  accountRepository.findByUserName(userName);
    }

    @Override
    public boolean isExistAccount(String userName) {
        if (accountRepository.findByUserName(userName) == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isExistEmail(String email) {
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isExistPhone(String phone) {
        Account account = accountRepository.findByPhoneNumber(phone);
        if(account == null) {
            return false;
        }
        return true;
    }

    @Override
    public Account saveOrUpdate(Account account) {
        return accountRepository.save(account);
    }
}
