package LHU.project.service;

import LHU.project.entities.Account;

public interface AccountService {
 public  Account findByUserName(String userName);

 public boolean isExistAccount(String userName);

 public boolean isExistEmail(String email);

 public boolean isExistPhone(String Phone);

 public Account saveOrUpdate(Account account);
}
