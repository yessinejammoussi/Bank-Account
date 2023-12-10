package org.bankAccount.domain.repository;

import org.bankAccount.domain.model.Account;

public interface AccountRepository {

    void save(Account account);
    Account findById(long accountId);
}
